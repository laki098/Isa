package com.example6.dto;


import java.util.List;

import com.example6.model.Firma;


public class FirmaDTO {
	
	private Long id;
	private String poslovnoIme;
	private String skracenoIme;
	private String pib;
	private String maticniBroj;

	public FirmaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public FirmaDTO(Firma firma) {
		super();
		this.id =firma.getId();
		this.poslovnoIme = firma.getPoslovnoIme();
		this.skracenoIme = firma.getSkracenoIme();
		this.pib = firma.getPib();
		this.maticniBroj = firma.getMaticniBroj();
	}
	public FirmaDTO(Long id, String poslovnoIme, String skracenoIme, String pib, String maticniBroj,
			List<NabavkaDTO> nabavka) {
		
		this.id = id;
		this.poslovnoIme = poslovnoIme;
		this.skracenoIme = skracenoIme;
		this.pib = pib;
		this.maticniBroj = maticniBroj;
		
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
	public String getPib() {
		return pib;
	}
	public void setPib(String pib) {
		this.pib = pib;
	}
	public String getMaticniBroj() {
		return maticniBroj;
	}
	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}
	
	
	
	

}
