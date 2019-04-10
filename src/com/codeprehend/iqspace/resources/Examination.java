package com.codeprehend.iqspace.resources;

import java.time.LocalDate;

/**
 * Class to define a consulation (from chitanta)
 * 
 * @since 30th of September 2015
 * @author Gabriel Munteanu
  *
 */
public class Examination {
	
	private Long id; 
	
	/**
	 * Consultation date
	 */
	private LocalDate consultationDate;
	
	/**
	 * Client id that has the consultation.
	 */
	private Long patientId;
	
	/**
	 * Consultation's text
	 */
	private String text;
	
	/** 
	 * Field to be used if the doctor wants to have information that is not printed. 
	 */
	private String otherObservations;
	
	//TODO add attachments BLOBs
	private String attachments; 
	
	/**
	 * Empty default constructor 
	 */
	public Examination(){
		
	}

	/**
	 * Constructor with parameters without id - needed before being saved to DB.
	 */
	public Examination(Long patientId, String text, 
			LocalDate consultationDate){
		this.patientId = patientId;
		this.text = text;
		this.consultationDate = consultationDate;
	}
	
	/**
	 * Constructor with parameters to set all the variables
	 */
	public Examination(Long id, Long patientId, String text, 
			LocalDate consultationDate, String otherObservations){
		this.id = id;
		this.patientId = patientId;
		this.text = text;
		this.consultationDate = consultationDate;
		this.otherObservations = otherObservations;
	}

	public LocalDate getConsultationDate() {
		return consultationDate;
	}

	public void setConsultationDate(LocalDate consultationDate) {
		this.consultationDate = consultationDate;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long  patientId) {
		this.patientId = patientId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getOtherObservations() {
		return otherObservations;
	}

	public void setOtherObservations(String otherObservations) {
		this.otherObservations = otherObservations;
	}
}