package com.codeprehend.iqspace.resources;

public class ObtainedAnswer {

	private Long questionId;
	private Long testId;
	private Long questionNumber;
	
	private String obtainedAnswer;
	private String expectedAnswer;
	
	public ObtainedAnswer( ) {
		
	}
	
	public ObtainedAnswer(Long questionId, Long testId, Long questionNumber, 
			String obtainedAnswer, String expectedAnswer) {
		this.questionId = questionId;
		this.testId = testId;
		this.questionNumber = questionNumber;
		this.obtainedAnswer = obtainedAnswer;
		this.expectedAnswer = expectedAnswer;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Long getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Long questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getObtainedAnswer() {
		return obtainedAnswer;
	}

	public void setObtainedAnswer(String obtainedAnswer) {
		this.obtainedAnswer = obtainedAnswer;
	}

	public String getExpectedAnswer() {
		return expectedAnswer;
	}

	public void setExpectedAnswer(String expectedAnswer) {
		this.expectedAnswer = expectedAnswer;
	}
}
