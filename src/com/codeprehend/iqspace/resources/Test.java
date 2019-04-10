package com.codeprehend.iqspace.resources;

import java.time.LocalDate;

public class Test {
	
	//TODO establish the form of Date
	private Long id;
	private String testName;
	private LocalDate creationDate;
	private String observations;
	private String testType;
	private Long numberOfQuestions;
	
	public Test(){
		
	}
	
	public Test(Long id, String testName, String observations, 
			LocalDate creationDate, String testType, Long numberOfQuestions){
		this.id = id;
		this.testName = testName;
		this.creationDate = creationDate;
		this.observations = observations;
		this.testType = testType;
		this.numberOfQuestions = numberOfQuestions;
	}
	
	public boolean equals(Test second){
		if(!this.getTestName().equals(second.getTestName()))
			return false;
		
		if(this.getNumberOfQuestions() != second.getNumberOfQuestions())
			return false;
		
		if(!this.getTestType().equals(second.getTestType()))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public void setPrimaConsultatie(LocalDate primaConsultatie) {
		this.creationDate = primaConsultatie;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public Long getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(Long numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
	
 }
