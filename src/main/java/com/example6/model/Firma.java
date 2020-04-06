package com.example6.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "firme")
public class Firma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "text")
	private String poslovnoIme;
	
	@Column
	@Type(type = "text")
	private String skracenoIme;
	
	@Column
	@Type(type = "text")
	private String pib;
	
	@Column
	@Type(type = "text")
	private String maticniBroj;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "firma", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private  List<Nabavka> nabavka = new ArrayList<>();

	public Firma() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Firma(Long id, String poslovnoIme, String skracenoIme, String pib, String maticniBroj,
			List<Nabavka> nabavka) {
		super();
		this.id = id;
		this.poslovnoIme = poslovnoIme;
		this.skracenoIme = skracenoIme;
		this.pib = pib;
		this.maticniBroj = maticniBroj;
		this.nabavka = nabavka;
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

	public List<Nabavka> getNabavka() {
		return nabavka;
	}

	public void setNabavka(List<Nabavka> nabavka) {
		this.nabavka = nabavka;
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
		if (!(obj instanceof Firma)) {
			return false;
		}
		Firma other = (Firma) obj;
		return Objects.equals(id, other.id) && Objects.equals(maticniBroj, other.maticniBroj)
				&& Objects.equals(nabavka, other.nabavka) && Objects.equals(pib, other.pib)
				&& Objects.equals(poslovnoIme, other.poslovnoIme) && Objects.equals(skracenoIme, other.skracenoIme);
	}
	
	

}
