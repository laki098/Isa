package com.example6.dto;

import com.example6.model.StavkaNabavke;

public class StavkaNabavkeDTO {
	
	private Long id;
	private double kolicina;
	private double cena;
	public StavkaNabavkeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StavkaNabavkeDTO(StavkaNabavke stavkaNabavke) {
		super();
		this.id = stavkaNabavke.getId();
		this.kolicina = stavkaNabavke.getKolicina();
		this.cena = stavkaNabavke.getCena();
	}
	public StavkaNabavkeDTO(Long id, double kolicina, double cena) {
		
		this.id = id;
		this.kolicina = kolicina;
		this.cena = cena;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	
	
	
	

}
