package com.projet.BackendPfe.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projet.BackendPfe.model.DataConsult;
import com.projet.BackendPfe.model.Expert;
import com.projet.BackendPfe.model.Generaliste;
import com.projet.BackendPfe.model.Patient;
import com.projet.BackendPfe.repository.ConsultationDataRepository;
import com.projet.BackendPfe.repository.ExpertRepository;
import com.projet.BackendPfe.repository.GeneralisteRepository;
import com.projet.BackendPfe.repository.PatientRepository;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DataConsulationController {
	@Autowired ConsultationDataRepository pr;
	@Autowired GeneralisteRepository pr1;
	@Autowired PatientRepository pr2;
	@Autowired ExpertRepository pr3;
	@PostMapping("/Consultations/{id}/{cin}")
	public void AddProduct(@PathVariable("id") long id ,@PathVariable("cin") long cin  ){
		Generaliste gen = pr1.findById(id).get();
		Patient pat = pr2.findById(cin).get();
	
		DataConsult data = new DataConsult(gen,pat);
		
		pr.save(data);
	}
	
	@GetMapping("/Consultations/{id}/{idConsultation}")
	public DataConsult productById(@PathVariable("id") long id ){
		return pr.findById(id).get();
	}
	@DeleteMapping("/deletepatients/{id}/{idConsultation}")
	public void deleteProduct(@PathVariable("id") long id){
		
	
		pr.deleteById(id);
	} 
	@GetMapping("/Consultations/{id}")
	public List<DataConsult> getAllProducts(@PathVariable("id") @ModelAttribute("id") long id){
         //pr.findById(id);
		  
		return pr.findAll();
	} 
	
}
