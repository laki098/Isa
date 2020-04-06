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

import com.example6.dto.FirmaDTO;
import com.example6.model.Firma;
import com.example6.service.FirmaService;

@Controller
@RequestMapping(path = "/api/firma")
public class FirmaController {
	
	@Autowired
	private FirmaService firmaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<List<FirmaDTO>> getAllFirma(){
		List<FirmaDTO> firme = new ArrayList<>();
		
		for(Firma f: firmaService.findAll()) {
			firme.add(new FirmaDTO(f));
		}
		return new ResponseEntity<>(firme, HttpStatus.OK);
			
		
	}
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FirmaDTO> getFirma(@PathVariable("id") Long id){
		Firma firma = firmaService.findById(id);
		if(firma == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		FirmaDTO firmaDTO = new FirmaDTO(firma);
		
		return new ResponseEntity<FirmaDTO>(firmaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<FirmaDTO> store(@RequestBody Firma novaFirma){
		if(firmaService.findOne(novaFirma.getMaticniBroj()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		firmaService.save(novaFirma);
		FirmaDTO firmaDTO = new FirmaDTO(novaFirma);
		return new ResponseEntity<FirmaDTO>(firmaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<FirmaDTO> update(@PathVariable("id") Long id, @RequestBody Firma ocitanaFirma){
		Firma firma = firmaService.findById(id);
		if(firma == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		firma.setSkracenoIme(ocitanaFirma.getSkracenoIme());
		firma.setPoslovnoIme(ocitanaFirma.getPoslovnoIme());
		firmaService.save(firma);
		FirmaDTO firmaDto = new FirmaDTO(firma);
		return new ResponseEntity<FirmaDTO>(firmaDto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<FirmaDTO> update(@PathVariable("id") Long id){
		Firma firma = firmaService.findById(id);
		if(firma == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		firmaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
