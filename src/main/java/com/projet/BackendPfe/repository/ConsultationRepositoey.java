package com.projet.BackendPfe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.projet.BackendPfe.model.Consultation;
import com.projet.BackendPfe.model.DataConsult;
import com.projet.BackendPfe.model.Images;
import com.projet.BackendPfe.model.Patient;

public interface ConsultationRepositoey extends JpaRepository<Consultation,Long> {
	
	

}

