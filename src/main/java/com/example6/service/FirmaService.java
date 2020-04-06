package com.example6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example6.model.Firma;
import com.example6.repository.FirmaRepository;



@Service
public class FirmaService {

	@Autowired
	private FirmaRepository firmaRepository;
	
	public Iterable <Firma> findAll(){
		return firmaRepository.findAll();
	}
	public Firma findById(Long id) {
		return firmaRepository.findById(id).orElse(null);
	}
	
	public void save (Firma artikal) {
		firmaRepository.save(artikal);
	}
	public void delete(Long id) {
		firmaRepository.deleteById(id);
	}
	
	public Firma findOne(String maticniBroj) {
		Iterable<Firma> firme = firmaRepository.findAll();
		for(Firma firma: firme) {
			if(firma.getMaticniBroj().equals(maticniBroj)) {
				return firma;
			}
		}
		return null;
	}

}
