package com.example6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example6.model.Dobavljac;
import com.example6.repository.DobavljacRepository;



@Service
public class DobavljacService {

	@Autowired
	private DobavljacRepository dobavljacRepository;
	
	public Iterable <Dobavljac> findAll(){
		return dobavljacRepository.findAll();
	}
	public Dobavljac findById(Long id) {
		return dobavljacRepository.findById(id).orElse(null);
	}
	
	public void save (Dobavljac artikal) {
		dobavljacRepository.save(artikal);
	}
	public void delete(Long id) {
		dobavljacRepository.deleteById(id);
	}
	
	public Dobavljac findOne(String skracenoIme) {
		Iterable<Dobavljac> dobavljaci = dobavljacRepository.findAll();
		for(Dobavljac dobavljac: dobavljaci) {
			if(dobavljac.getSkracenoIme().equals(skracenoIme)) {
				return dobavljac;
			}
		}
		return null;
	}
}
