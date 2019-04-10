package com.codeprehend.iqspace.resources;

/**
 * Class to define a question 
 * 
 * @since 30th of September 2015
 * @author Gabriel Munteanu
  *
 */
public class Question {
	
	private Long id; 
	private Long testId;
	private String question;
	private String answer;
	private String explanations;
	private String questionType;
	private byte[] image;
	private String hint1;
	private String hint2;
	private Long questionNumber;
	private String otherObservations;
	
	
	/**
	 * Empty default constructor 
	 */
	public Question(){
		
	}

	/**
	 * Constructor with parameters without id - needed before being saved to DB.
	 */
	public Question(Long testId, String question, String questionType, String answer, String explanations,
			String hint1, String hint2, String otherObservations, Long questionNumber, byte[] image) {
		this.testId = testId;
		this.question = question;
		this.questionType = questionType;
		this.answer = answer;
		this.explanations = explanations;
		this.hint1 = hint1;
		this.hint2 = hint2;
		this.otherObservations = otherObservations;
		this.questionNumber = questionNumber;
		this.image = image;
	}
	
	/**
	 * Constructor with parameters to set all the variables
	 */
	public Question(Long id, Long testId, String question, String questionType, String answer, 
			String explanations, String hint1, String hint2, 
			String otherObservations, Long questionNumber, byte[] image){
		this.id = id;
		this.testId = testId;
		this.question = question;
		this.questionType = questionType;
		this.answer = answer;
		this.explanations = explanations;
		this.hint1 = hint1;
		this.hint2 = hint2;
		this.otherObservations = otherObservations;
		this.questionNumber = questionNumber;
		this.image = image;
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

	public Long getTestId() {
		return testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getExplanations() {
		return explanations;
	}

	public void setExplanations(String explanations) {
		this.explanations = explanations;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getHint1() {
		return hint1;
	}

	public void setHint1(String hint1) {
		this.hint1 = hint1;
	}

	public String getHint2() {
		return hint2;
	}

	public void setHint2(String hint2) {
		this.hint2 = hint2;
	}

	public Long getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Long questionNumber) {
		this.questionNumber = questionNumber;
	}
	
	
}