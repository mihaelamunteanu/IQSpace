package com.codeprehend.iqspace.resources;

import java.time.LocalDate;

public class Results {
	private Long id;
	private Long visitorId;
	private Long testId;
	private LocalDate testDate;
	private String testObservation;
	private String usedMail;
	
	
	private String result;
	
	public Results() {
		
	}
	
	public Results(Long visitorId, Long testId, LocalDate testDate, 
			String testObservation, String usedMail, String result) {
		this.visitorId = visitorId;
		this.testId = testId;
		this.testDate = testDate;
		this.testObservation = testObservation;
		this.usedMail = usedMail;
		this.result = result;
	}
	
	public Results(Long id, Long visitorId, Long testId, LocalDate testDate, 
			String testObservation, String usedMail, String result) {
		this.id = id;
		this.visitorId = visitorId;
		this.testId = testId;
		this.testDate = testDate;
		this.testObservation = testObservation;
		this.usedMail = usedMail;
		this.result = result;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(Long visitorId) {
		this.visitorId = visitorId;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public LocalDate getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}

	public String getTestObservation() {
		return testObservation;
	}

	public void setTestObservation(String testObservation) {
		this.testObservation = testObservation;
	}

	public String getUsedMail() {
		return usedMail;
	}

	public void setUsedMail(String usedMail) {
		this.usedMail = usedMail;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
