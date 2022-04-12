package com.projet.BackendPfe.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Consultation {
	public Consultation(DataConsult dataConsult, Images images) {
		super();
		this.dataConsult = dataConsult;
		this.images = images;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
@ManyToOne()
private DataConsult dataConsult;
@ManyToOne()
private Images images;
public Consultation() {
	
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public DataConsult getDataConsult() {
	return dataConsult;
}
public void setDataConsult(DataConsult dataConsult) {
	this.dataConsult = dataConsult;
}
public Images getImages() {
	return images;
}
public void setImages(Images images) {
	this.images = images;
}
public Consultation(long id, DataConsult dataConsult, Images images) {
	super();
	this.id = id;
	this.dataConsult = dataConsult;
	this.images = images;
}

}
