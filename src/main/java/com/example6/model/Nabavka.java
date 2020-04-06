package com.example6.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "nabavke")
public class Nabavka {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datumNabavke;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nabavka", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private  List<StavkaNabavke> stavkaNabavke = new ArrayList<>();
	
	@ManyToOne(optional = false)
	private Firma firma;
	
	@ManyToOne(optional = false)
	private Dobavljac dobavljac;

	public Nabavka() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nabavka(Long id, Date datumNabavke, List<StavkaNabavke> stavkaNabavke, Firma firma,
			Dobavljac dobavljac) {
		
		this.id = id;
		this.datumNabavke = datumNabavke;
		this.stavkaNabavke = stavkaNabavke;
		this.firma = firma;
		this.dobavljac = dobavljac;
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

	public List<StavkaNabavke> getStavkaNabavke() {
		return stavkaNabavke;
	}

	public void setStavkaNabavke(List<StavkaNabavke> stavkaNabavke) {
		this.stavkaNabavke = stavkaNabavke;
	}

	public Firma getFirma() {
		return firma;
	}

	public void setFirma(Firma firma) {
		this.firma = firma;
	}

	public Dobavljac getDobavljac() {
		return dobavljac;
	}

	public void setDobavljac(Dobavljac dobavljac) {
		this.dobavljac = dobavljac;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Nabavka)) {
			return false;
		}
		Nabavka other = (Nabavka) obj;
		return Objects.equals(datumNabavke, other.datumNabavke) && Objects.equals(dobavljac, other.dobavljac)
				&& Objects.equals(firma, other.firma) && Objects.equals(id, other.id)
				&& Objects.equals(stavkaNabavke, other.stavkaNabavke);
	}
	
	
	
	
	

}
