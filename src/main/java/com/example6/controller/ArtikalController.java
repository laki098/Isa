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

import com.example6.dto.ArtikalDTO;
import com.example6.model.Artikal;
import com.example6.service.ArtikalService;



@Controller
@RequestMapping(path = "/api/artikal")
public class ArtikalController {

	@Autowired
	private ArtikalService artikalService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<List<ArtikalDTO>> getAllArtikal(){
		List<ArtikalDTO> artikal = new ArrayList<>();
		
		for(Artikal f: artikalService.findAll()) {
			artikal.add(new ArtikalDTO(f));
		}
		return new ResponseEntity<>(artikal, HttpStatus.OK);
			
		
	}
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ArtikalDTO> getArtikal(@PathVariable("id") Long id){
		Artikal artikal = artikalService.findById(id);
		if(artikal == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ArtikalDTO artikalDTO = new ArtikalDTO(artikal);
		
		return new ResponseEntity<ArtikalDTO>(artikalDTO, HttpStatus.OK);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<ArtikalDTO> store(@RequestBody Artikal noviArtikal){
		if(artikalService.findOne(noviArtikal.getNaziv()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		artikalService.save(noviArtikal);
		ArtikalDTO artikalDTO = new ArtikalDTO(noviArtikal);
		return new ResponseEntity<ArtikalDTO>(artikalDTO, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ArtikalDTO> update(@PathVariable("id") Long id, @RequestBody Artikal ocitanArtikal){
		Artikal artikal = artikalService.findById(id);
		if(artikal == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		artikal.setNaziv(ocitanArtikal.getNaziv());
		
		artikalService.save(artikal);
		ArtikalDTO artikalDto = new ArtikalDTO(artikal);
		return new ResponseEntity<ArtikalDTO>(artikalDto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ArtikalDTO> update(@PathVariable("id") Long id){
		Artikal artikal = artikalService.findById(id);
		if(artikal == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		artikalService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	

}
