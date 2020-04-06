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

import com.example6.dto.StavkaNabavkeDTO;
import com.example6.model.StavkaNabavke;
import com.example6.service.StavkaNabavkeService;



@Controller
@RequestMapping(path = "/api/stavkaNabavke")
public class StavkaNabavkeController {

	@Autowired
	private StavkaNabavkeService stavkaNabavkeService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<List<StavkaNabavkeDTO>> getAllStavkaNabavke(){
		List<StavkaNabavkeDTO> stavkaNabavke = new ArrayList<>();
		
		for(StavkaNabavke sn: stavkaNabavkeService.findAll()) {
			stavkaNabavke.add(new StavkaNabavkeDTO(sn));
		}
		return new ResponseEntity<>(stavkaNabavke, HttpStatus.OK);
			
		
	}
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StavkaNabavkeDTO> getStavkaNabavke(@PathVariable("id") Long id){
		StavkaNabavke stavkaNabavke = stavkaNabavkeService.findById(id);
		if(stavkaNabavke == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		StavkaNabavkeDTO stavkaNabavkeDTO = new StavkaNabavkeDTO(stavkaNabavke);
		
		return new ResponseEntity<StavkaNabavkeDTO>(stavkaNabavkeDTO, HttpStatus.OK);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<StavkaNabavkeDTO> store(@RequestBody StavkaNabavke novaStavkaNabavke){
		if(stavkaNabavkeService.findById(novaStavkaNabavke.getId()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		stavkaNabavkeService.save(novaStavkaNabavke);
		StavkaNabavkeDTO stavkaNabavkeDTO = new StavkaNabavkeDTO(novaStavkaNabavke);
		return new ResponseEntity<StavkaNabavkeDTO>(stavkaNabavkeDTO, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<StavkaNabavkeDTO> update(@PathVariable("id") Long id, @RequestBody StavkaNabavke ocitaneStavkaNabavke){
		StavkaNabavke stavkaNabavke = stavkaNabavkeService.findById(id);
		if(stavkaNabavke == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		stavkaNabavke.setCena(ocitaneStavkaNabavke.getCena());
		stavkaNabavke.setKolicina(ocitaneStavkaNabavke.getKolicina());
		stavkaNabavkeService.save(stavkaNabavke);
		StavkaNabavkeDTO stavkaNabavkeDto = new StavkaNabavkeDTO(stavkaNabavke);
		return new ResponseEntity<StavkaNabavkeDTO>(stavkaNabavkeDto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StavkaNabavkeDTO> update(@PathVariable("id") Long id){
		StavkaNabavke stavkaNabavke = stavkaNabavkeService.findById(id);
		if(stavkaNabavke == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		stavkaNabavkeService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
