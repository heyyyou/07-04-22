package com.projet.BackendPfe.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projet.BackendPfe.model.Images;
import com.projet.BackendPfe.repository.DBFileRepository;
import com.projet.BackendPfe.request.UploadFileResponse;
import com.projet.BackendPfe.services.DBFileStorageService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;
    @Autowired
    private   DBFileRepository    dbFileRepository;
 

    @PostMapping("/uploadFile/{id}/{cin}")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file  ,@RequestParam ("type") String type) {
    	Images dbFile = dbFileStorageService.storeFile(file , type);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new UploadFileResponse(dbFile.getType() ,dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files  ,@RequestParam ("type") String type) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file , type))
                .collect(Collectors.toList());
    }
    @GetMapping("/downloadFile/{fileId}/{id}/{cin}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
    	Images dbFile = dbFileStorageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
    @DeleteMapping("/deleteFile/{fileId}/{id}/{cin}")
    public String deleteFile(@PathVariable String fileId) {
    	dbFileRepository.deleteById(fileId);
		return fileId;
    }
    @PutMapping("/updateImage/{id}")
	  public String updateExpert(@RequestParam("id") String id ,  @RequestParam("file") MultipartFile file ,@RequestParam ("type") String type) throws IOException		    		  {
    Images img=    	dbFileRepository.findById(id).get();

    	
    	dbFileStorageService.updateFile(file,img.getType(),id);
		    	return "Done !!!";
		    }


}
