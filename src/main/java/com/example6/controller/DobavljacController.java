package com.example6.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example6.dto.DobavljacDTO;
import com.example6.model.Dobavljac;
import com.example6.service.DobavljacService;



@Controller
@RequestMapping(path = "/api/dobavljac")
public class DobavljacController {
	@Autowired
	private DobavljacService dobavljacService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<List<DobavljacDTO>> getAllDobavljac(){
		List<DobavljacDTO> dobavljac = new ArrayList<>();
		
		for(Dobavljac d: dobavljacService.findAll()) {
			dobavljac.add(new DobavljacDTO(d));
		}
		return new ResponseEntity<>(dobavljac, HttpStatus.OK);
			
		
	}
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DobavljacDTO> getDobavljac(@PathVariable("id") Long id){
		Dobavljac dobavljac = dobavljacService.findById(id);
		if(dobavljac == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		DobavljacDTO dobavljacDTO = new DobavljacDTO(dobavljac);
		
		return new ResponseEntity<DobavljacDTO>(dobavljacDTO, HttpStatus.OK);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<DobavljacDTO> store(@RequestBody Dobavljac noviDobavljac){
		if(dobavljacService.findOne(noviDobavljac.getPoslovnoIme()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		dobavljacService.save(noviDobavljac);
		DobavljacDTO dobavljacDTO = new DobavljacDTO(noviDobavljac);
		return new ResponseEntity<DobavljacDTO>(dobavljacDTO, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DobavljacDTO> update(@PathVariable("id") Long id, @RequestBody Dobavljac ocitaniDobavljac){
		Dobavljac dobavljac = dobavljacService.findById(id);
		if(dobavljac == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		dobavljac.setSkracenoIme(ocitaniDobavljac.getSkracenoIme());
		dobavljac.setPoslovnoIme(ocitaniDobavljac.getPoslovnoIme());
		dobavljacService.save(dobavljac);
		DobavljacDTO dobavljacDto = new DobavljacDTO(dobavljac);
		return new ResponseEntity<DobavljacDTO>(dobavljacDto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<DobavljacDTO> update(@PathVariable("id") Long id){
		Dobavljac firma = dobavljacService.findById(id);
		if(firma == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		dobavljacService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
