package com.example6.dto;

import com.example6.model.Dobavljac;

public class DobavljacDTO {

	private Long id;
	private String poslovnoIme;
	private String skracenoIme;
	public DobavljacDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DobavljacDTO(Dobavljac dobavljac) {
		super();
		this.id = dobavljac.getId() ;
		this.poslovnoIme = dobavljac.getPoslovnoIme();
		this.skracenoIme = dobavljac.getSkracenoIme();
	}
	public DobavljacDTO(Long id, String poslovnoIme, String skracenoIme) {
		
		this.id = id;
		this.poslovnoIme = poslovnoIme;
		this.skracenoIme = skracenoIme;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPoslovnoIme() {
		return poslovnoIme;
	}
	public void setPoslovnoIme(String poslovnoIme) {
		this.poslovnoIme = poslovnoIme;
	}
	public String getSkracenoIme() {
		return skracenoIme;
	}
	public void setSkracenoIme(String skracenoIme) {
		this.skracenoIme = skracenoIme;
	}
	
	
	
	
	
	
	
}


