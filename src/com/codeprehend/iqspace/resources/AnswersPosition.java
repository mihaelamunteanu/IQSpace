package com.codeprehend.iqspace.resources;

public class AnswersPosition {
	private Integer positionOfCorrectAnswer;
	private Integer positionOfWrongAnswer1;
	private Integer positionOfWrongAnswer2;
	public Integer getPositionOfCorrectAnswer() {
		return positionOfCorrectAnswer;
	}
	public void setPositionOfCorrectAnswer(Integer positionOfCorrectAnswer) {
		this.positionOfCorrectAnswer = positionOfCorrectAnswer;
	}
	public Integer getPositionOfWrongAnswer1() {
		return positionOfWrongAnswer1;
	}
	public void setPositionOfWrongAnswer1(Integer positionOfWrongAnswer1) {
		this.positionOfWrongAnswer1 = positionOfWrongAnswer1;
	}
	public Integer getPositionOfWrongAnswer2() {
		return positionOfWrongAnswer2;
	}
	public void setPositionOfWrongAnswer2(Integer positionOfWrongAnswer2) {
		this.positionOfWrongAnswer2 = positionOfWrongAnswer2;
	}

	public static String getLetterForPosition(int positionOfAnswer) {
		switch (positionOfAnswer) {
		case 1:
			return "a)";
		case 2:
			return "b)";
		case 3:
			return "c)";
		default:
			return "a)";
		}
	}
}
