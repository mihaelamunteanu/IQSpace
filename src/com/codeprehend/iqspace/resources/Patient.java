package com.codeprehend.iqspace.resources;

import java.time.LocalDate;

public class Patient {
	
	//TODO establish the form of Date
	private Long id;
	private String nume;
	private String prenume;
	private String cnp;
	private LocalDate dataNasterii;
	private String adresa;
	private LocalDate primaConsultatie;
	private String numarTelefon;
	private String altele;
	private int nasteriNaturale;
	private int cezariene; 
	private int avorturiLaCerere;
	private int avorturiSpontane;
	
	public Patient(){
		
	}
	
	public Patient(Long id, String nume, String prenume, String cnp, 
			LocalDate dataNasterii, LocalDate primaConsultatie, String adresa, String numarTelefon){
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.cnp = cnp;
		this.dataNasterii = dataNasterii;
		this.primaConsultatie = primaConsultatie;
		this.adresa = adresa;
		this.numarTelefon = numarTelefon;
	}
	
	public boolean equals(Patient second){
		if(!this.getNume().equals(second.getNume()))
			return false;
		
		if(!this.getCnp().equals(second.getCnp()))
			return false;
		
		if(!this.getPrenume().equals(second.getPrenume()))
			return false;
		
		if(!this.getDataNasterii().equals(second.getDataNasterii()))
			return false;
		
		return true;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	
	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public LocalDate getDataNasterii() {
		return dataNasterii;
	}

	public void setDataNasterii(LocalDate dataNasterii) {
		this.dataNasterii = dataNasterii;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public LocalDate getPrimaConsultatie() {
		return primaConsultatie;
	}

	public void setPrimaConsultatie(LocalDate primaConsultatie) {
		this.primaConsultatie = primaConsultatie;
	}

	public String getAltele() {
		return altele;
	}

	public void setAltele(String altele) {
		this.altele = altele;
	}

	public String getNumarTelefon() {
		return numarTelefon;
	}

	public void setNumarTelefon(String numarTelefon) {
		this.numarTelefon = numarTelefon;
	}

	public int getNasteriNaturale() {
		return nasteriNaturale;
	}

	public void setNasteriNaturale(int nasteriNaturale) {
		this.nasteriNaturale = nasteriNaturale;
	}

	public int getCezariene() {
		return cezariene;
	}

	public void setCezariene(int cezariene) {
		this.cezariene = cezariene;
	}

	public int getAvorturiLaCerere() {
		return avorturiLaCerere;
	}

	public void setAvorturiLaCerere(int avorturiLaCerere) {
		this.avorturiLaCerere = avorturiLaCerere;
	}

	public int getAvorturiSpontane() {
		return avorturiSpontane;
	}

	public void setAvorturiSpontane(int avorturiSpontane) {
		this.avorturiSpontane = avorturiSpontane;
	}
	
 }
