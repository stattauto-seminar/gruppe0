package de.stattauto.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kunde implements Serializable {

	private static final long serialVersionUID = -7542231917768571604L;
	
	@Id 
	@GeneratedValue
	private Long id;
	private String nachname;
	private String vorname;
	private String nummer;
	
	public Kunde(String nachname, String vorname, String nummer) {
		this.nachname = nachname;
		this.vorname = vorname;
		this.nummer = nummer;
	}
	
	public Kunde() {
		
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public String getNummer() {
		return nummer;
	}
	
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}
}
