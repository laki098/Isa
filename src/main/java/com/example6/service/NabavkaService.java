package com.example6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example6.model.Nabavka;
import com.example6.repository.NabavkaRepository;



@Service
public class NabavkaService {

	@Autowired
	private NabavkaRepository nabavkalRepository;
	
	public Iterable <Nabavka> findAll(){
		return nabavkalRepository.findAll();
	}
	public Nabavka findById(Long id) {
		return nabavkalRepository.findById(id).orElse(null);
	}
	
	public void save (Nabavka artikal) {
		nabavkalRepository.save(artikal);
	}
	public void delete(Long id) {
		nabavkalRepository.deleteById(id);
	}
	
}
