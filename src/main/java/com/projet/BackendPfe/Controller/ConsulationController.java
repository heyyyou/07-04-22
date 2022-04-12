package com.projet.BackendPfe.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.BackendPfe.model.Consultation;
import com.projet.BackendPfe.model.DataConsult;
import com.projet.BackendPfe.model.Images;
import com.projet.BackendPfe.repository.ConsultationDataRepository;
import com.projet.BackendPfe.repository.ConsultationRepositoey;
import com.projet.BackendPfe.repository.DBFileRepository;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ConsulationController {
	@Autowired ConsultationRepositoey pr;
	@Autowired ConsultationDataRepository pr1;
	@Autowired DBFileRepository pr2;
	@PostMapping("/Consultation/{id}/{idimg}")
	public void AddProduct(@PathVariable("id") long id ,@PathVariable("idimg") String img  ){
		DataConsult r=pr1.findById(id).get();
		Images p=pr2.findById(img).get();
		Consultation ha= new Consultation(r,p);
		pr.save(ha);
	}
	
	@GetMapping("/Consultation/{id}")
	public Consultation productById(@PathVariable("id") long id ){
		return pr.findById(id).get();
	}
	@DeleteMapping("/deletepatient/{id}/{idConsultation}")
	public void deleteProduct(@PathVariable("id") long id){
		
	
		pr.deleteById(id);
	} 

	/*@GetMapping("/Consultation/{id}")
	public List<Consultation> getAllProductss(@PathVariable("id") @ModelAttribute("id") long id){
         //pr.findById(id);
		  
		return pr.findAll();*/
	} 
	
