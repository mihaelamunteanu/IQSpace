package com.codeprehend.iqspace.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.dao.QuestionsDAO;
import com.codeprehend.iqspace.resources.Question;

public class NextQuestionButtonActionListener implements ActionListener {
	private IQSpaceGUI mainWindow;
	
	public NextQuestionButtonActionListener(IQSpaceGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		int numberOfCurrentQuestion = mainWindow.getNumberOfCurrentQuestion();
		if (mainWindow.getTestResource().getNumberOfQuestions() > numberOfCurrentQuestion) {
			Question question = mainWindow.getQuestionsForTest().get(numberOfCurrentQuestion);
			numberOfCurrentQuestion = numberOfCurrentQuestion + 1;
			mainWindow.setNumberOfCurrentQuestion(numberOfCurrentQuestion);
			mainWindow.showQuestionPanel(question);
		}
		else { 
			mainWindow.showResultsPanel(mainWindow.getTestResource());
		}
	}
}
