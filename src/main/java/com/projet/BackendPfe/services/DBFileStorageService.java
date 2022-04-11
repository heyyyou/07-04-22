package com.projet.BackendPfe.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.projet.BackendPfe.exception.FileStorageException;
import com.projet.BackendPfe.exception.MyFileNotFoundException;
import com.projet.BackendPfe.model.Images;
import com.projet.BackendPfe.model.Patient;
import com.projet.BackendPfe.repository.DBFileRepository;


@SpringBootApplication
public class DBFileStorageService {
	  @Autowired
	    private DBFileRepository dbFileRepository;

	    public Images storeFile(MultipartFile file , String  type) {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	            }

	            Images dbFile = new Images( type , fileName, file.getContentType(), file.getBytes());

	            return dbFileRepository.save(dbFile);
	        } catch (IOException ex) {
	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	        }
	    }

	  
	    


	  	    public Images updateFile(MultipartFile file ,String type, String id ) {
	  	        // Normalize file name
	  	  	   Images UtilisateurInfo = dbFileRepository.findById(id).get();
	  	  
	  	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	  	        try {
	  	        	
	  	            // Check if the file's name contains invalid characters
	  	            if(fileName.contains("..")) {
	  	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	  	            }


	  	          //  Images dbFile = new Images( UtilisateurInfo.getType() , fileName, file.getContentType(), file.getBytes());
	  	          UtilisateurInfo.setData(file.getBytes());
	  	        UtilisateurInfo.setFileName(fileName);
	  	            return dbFileRepository.save( UtilisateurInfo);
	  	        } catch (IOException ex) {
	  	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	  	        }
	  	    }

	  	    public Images getFile(String fileId) {
	  	        return dbFileRepository.findById(fileId)
	  	                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
	  	    }
	    
	    
	    
	}



