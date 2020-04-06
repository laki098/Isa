package com.example6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example6.model.Artikal;

import com.example6.repository.ArtikalRepository;

@Service
public class ArtikalService {
	
	@Autowired
	private ArtikalRepository artikalRepository;
	
	public Iterable <Artikal> findAll(){
		return artikalRepository.findAll();
	}
	public Artikal findById(Long id) {
		return artikalRepository.findById(id).orElse(null);
	}
	
	public void save (Artikal artikal) {
		artikalRepository.save(artikal);
	}
	public void delete(Long id) {
		artikalRepository.deleteById(id);
	}

	public Artikal findOne(String naziv) {
		Iterable<Artikal> artikli = artikalRepository.findAll();
		for(Artikal artikal: artikli) {
			if(artikal.getNaziv().equals(naziv)) {
				return artikal;
			}
		}
		return null;
	}
}
