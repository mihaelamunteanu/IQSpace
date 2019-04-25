package com.codeprehend.iqspace;

import java.util.List;

import com.codeprehend.iqspace.resources.AnswersPosition;
import com.codeprehend.iqspace.util.Utils;

public class TestRandomFunctions {
	public static void main(String args[]) {
//		for (int i=0; i<80; i++) {
//			int a = Utils.getRandomOption(3);
//			int b = Utils.getRandomOption(2);
//			System.out.println(a + "  " + b + "  " + (5-a-b));
//		}
		
		List<AnswersPosition> answersPositions = Utils.getRandomPositionsForAnswers(80);
		for (int i=0;i<80; i++) {
			System.out.println(answersPositions.get(i).getPositionOfCorrectAnswer() + "  " + 
					answersPositions.get(i).getPositionOfWrongAnswer1() + "  " + 
					answersPositions.get(i).getPositionOfWrongAnswer2());
		}
	}
}
