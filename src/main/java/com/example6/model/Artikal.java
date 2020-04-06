package com.example6.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "artikli")
public class Artikal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "text")
	private String naziv;

	public Artikal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artikal(Long id, String naziv) {
		
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
		if (!(obj instanceof Artikal)) {
			return false;
		}
		Artikal other = (Artikal) obj;
		return Objects.equals(id, other.id) && Objects.equals(naziv, other.naziv);
	}
	
	
	
	
}
