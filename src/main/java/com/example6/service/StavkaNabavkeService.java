package com.example6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example6.model.StavkaNabavke;
import com.example6.repository.StavkaNabavkeRepository;



@Service
public class StavkaNabavkeService {
	
	@Autowired
	private StavkaNabavkeRepository stavkaNabavkeRepository;
	
	public Iterable <StavkaNabavke> findAll(){
		return stavkaNabavkeRepository.findAll();
	}
	public StavkaNabavke findById(Long id) {
		return stavkaNabavkeRepository.findById(id).orElse(null);
	}
	
	public void save (StavkaNabavke artikal) {
		stavkaNabavkeRepository.save(artikal);
	}
	public void delete(Long id) {
		stavkaNabavkeRepository.deleteById(id);
	}

}
