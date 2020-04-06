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
@Table(name= "dobavljac")
public class Dobavljac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "text")
	private String skracenoIme;
	
	@Column
	@Type(type = "text")
	private String poslovnoIme;

	public Dobavljac() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dobavljac(Long id, String skracenoIme, String poslovnoIme) {
		
		this.id = id;
		this.skracenoIme = skracenoIme;
		this.poslovnoIme = poslovnoIme;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkracenoIme() {
		return skracenoIme;
	}

	public void setSkracenoIme(String skracenoIme) {
		this.skracenoIme = skracenoIme;
	}

	public String getPoslovnoIme() {
		return poslovnoIme;
	}

	public void setPoslovnoIme(String poslovnoIme) {
		this.poslovnoIme = poslovnoIme;
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
		if (!(obj instanceof Dobavljac)) {
			return false;
		}
		Dobavljac other = (Dobavljac) obj;
		return Objects.equals(id, other.id) && Objects.equals(poslovnoIme, other.poslovnoIme)
				&& Objects.equals(skracenoIme, other.skracenoIme);
	}
	
	
	
	
	
	
}
