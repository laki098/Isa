package com.example6.dto;

import com.example6.model.Artikal;

public class ArtikalDTO {
	private Long id;
	private String naziv;
	public ArtikalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArtikalDTO(Artikal artikal) {
		super();
		this.id = artikal.getId();
		this.naziv = artikal.getNaziv();
	}
	public ArtikalDTO(Long id, String naziv) {
		
		this.id = id;
		this.naziv = naziv;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	
}
