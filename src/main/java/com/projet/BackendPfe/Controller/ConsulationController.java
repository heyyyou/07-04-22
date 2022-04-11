package com.projet.BackendPfe.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.BackendPfe.model.Consultation;
import com.projet.BackendPfe.model.Patient;
import com.projet.BackendPfe.repository.ConsultationRepository;
@RestController
public class ConsulationController {
	@Autowired ConsultationRepository pr;
	@PostMapping("/Consultation/{id}")
	public void AddProduct(@RequestBody Consultation p ){
		pr.save(p);
	}
	
	@GetMapping("/Consultation/{id}/{idConsultation}")
	public Consultation productById(@PathVariable("id") long id ){
		return pr.findById(id).get();
	}
	@DeleteMapping("/deletepatient/{id}/{idConsultation}")
	public void deleteProduct(@PathVariable("id") long id){
		
	
		pr.deleteById(id);
	} 
	@GetMapping("/Consultation/{id}")
	public List<Consultation> getAllProducts(@PathVariable("id") @ModelAttribute("id") long id){
         //pr.findById(id);
		  
		return pr.findAll();
	} 
	
}
