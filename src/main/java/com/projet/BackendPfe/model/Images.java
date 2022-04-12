package com.projet.BackendPfe.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity

public class Images {

	
	
	  @Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
		//@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	    private String id;

	  
	  
		/*@ManyToOne()
		protected Consultation consultation;
*/
	  @OneToMany(mappedBy="images",fetch=FetchType.EAGER)
	  private Collection<Consultation>consultation;
	    private String fileName;

	    private String fileType;

	    @Lob
	    private byte[] data;
	    
	    private String type ; 

	    public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Images() {

	    }

	    public Images(String type , String fileName, String fileType, byte[] data) {
	        this.fileName = fileName;
	        this.fileType = fileType;
	        this.data = data;
	        this.type=type ; 
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getFileName() {
	        return fileName;
	    }

	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }

	    public String getFileType() {
	        return fileType;
	    }

	    public void setFileType(String fileType) {
	        this.fileType = fileType;
	    }

	    public byte[] getData() {
	        return data;
	    }

	    public void setData(byte[] data) {
	        this.data = data;
	    }
	}


