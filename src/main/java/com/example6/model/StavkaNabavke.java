package com.example6.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name= "stavkaNabavke")
public class StavkaNabavke {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Type(type = "double")
	private double kolicina;
	
	@Column
	@Type(type = "double")
	private double cena;
	
	@ManyToOne(optional = false)
	private Nabavka nabavka;
	
	@ManyToOne(optional = false)
	private Artikal artikal;

	public StavkaNabavke() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StavkaNabavke(Long id, double kolicina, double cena, Nabavka nabavka, Artikal artikal) {
		
		this.id = id;
		this.kolicina = kolicina;
		this.cena = cena;
		this.nabavka = nabavka;
		this.artikal = artikal;
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

	public Nabavka getNabavka() {
		return nabavka;
	}

	public void setNabavka(Nabavka nabavka) {
		this.nabavka = nabavka;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
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
		if (!(obj instanceof StavkaNabavke)) {
			return false;
		}
		StavkaNabavke other = (StavkaNabavke) obj;
		return Objects.equals(artikal, other.artikal)
				&& Double.doubleToLongBits(cena) == Double.doubleToLongBits(other.cena) && Objects.equals(id, other.id)
				&& Double.doubleToLongBits(kolicina) == Double.doubleToLongBits(other.kolicina)
				&& Objects.equals(nabavka, other.nabavka);
	}
	
	

}
