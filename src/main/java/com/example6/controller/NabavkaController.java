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

import com.example6.dto.NabavkaDTO;
import com.example6.model.Nabavka;
import com.example6.service.NabavkaService;



@Controller
@RequestMapping(path = "/api/nabavka")
public class NabavkaController {

	
	@Autowired
	private NabavkaService nabavkaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<List<NabavkaDTO>> getAllNabavka(){
		List<NabavkaDTO> nabavka = new ArrayList<>();
		
		for(Nabavka n: nabavkaService.findAll()) {
			nabavka.add(new NabavkaDTO(n));
		}
		return new ResponseEntity<>(nabavka, HttpStatus.OK);
			
		
	}
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<NabavkaDTO> getNabavka(@PathVariable("id") Long id){
		Nabavka nabavka = nabavkaService.findById(id);
		if(nabavka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		NabavkaDTO nabavkaDTO = new NabavkaDTO(nabavka);
		
		return new ResponseEntity<NabavkaDTO>(nabavkaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<NabavkaDTO> store(@RequestBody Nabavka novaNabavka){
		if(nabavkaService.findById(novaNabavka.getId()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		nabavkaService.save(novaNabavka);
		NabavkaDTO nabavkaDTO = new NabavkaDTO(novaNabavka);
		return new ResponseEntity<NabavkaDTO>(nabavkaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<NabavkaDTO> update(@PathVariable("id") Long id, @RequestBody Nabavka ocitanaNabavka){
		Nabavka nabavka = nabavkaService.findById(id);
		if(nabavka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		nabavka.setDatumNabavke(ocitanaNabavka.getDatumNabavke());
		nabavkaService.save(nabavka);
		NabavkaDTO nabavkaDto = new NabavkaDTO(nabavka);
		return new ResponseEntity<NabavkaDTO>(nabavkaDto, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<NabavkaDTO> update(@PathVariable("id") Long id){
		Nabavka nabavka = nabavkaService.findById(id);
		if(nabavka == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		nabavkaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
