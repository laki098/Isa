package com.example6.dto;


import java.util.Date;

import com.example6.model.Nabavka;

public class NabavkaDTO {
	private Long id;
	private Date datumNabavke;
	public NabavkaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NabavkaDTO(Nabavka nabavka) {
		super();
		this.id = nabavka.getId();
		this.datumNabavke = nabavka.getDatumNabavke();
	}
	public NabavkaDTO(Long id, Date datumNabavke) {
		
		this.id = id;
		this.datumNabavke = datumNabavke;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatumNabavke() {
		return datumNabavke;
	}
	public void setDatumNabavke(Date datumNabavke) {
		this.datumNabavke = datumNabavke;
	}
	
	
	
	
	

}
