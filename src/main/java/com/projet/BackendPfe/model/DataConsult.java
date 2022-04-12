package com.projet.BackendPfe.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DataConsult {
	public DataConsult(Generaliste generaliste, Patient patient) {
		super();
		this.generaliste = generaliste;
		this.patient = patient;
	}
	public DataConsult(Generaliste generaliste, Patient patient, Expert expert) {
		super();
		this.generaliste = generaliste;
		this.patient = patient;
		this.expert = expert;
	}
/*@OneToMany(targetEntity=ImageConsultation.class, mappedBy = "consultation")
	private List<ImageConsultation>liste1=new ArrayList<ImageConsultation>();*/
@OneToMany(mappedBy="dataConsult",fetch=FetchType.LAZY)
private Collection<Consultation>consultation;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne()
	protected Generaliste generaliste;
	@ManyToOne()
	protected Patient patient;
	public Generaliste getGeneraliste() {
		return generaliste;
	}
	public void setGeneraliste(Generaliste generaliste) {
		this.generaliste = generaliste;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Expert getExpert() {
		return expert;
	}
	public void setExpert(Expert expert) {
		this.expert = expert;
	}
	@ManyToOne()
	protected Expert expert;
	 
}
