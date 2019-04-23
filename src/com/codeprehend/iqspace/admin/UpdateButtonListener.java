package com.codeprehend.iqspace.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.codeprehend.iqspace.dao.QuestionsDAO;
import com.codeprehend.iqspace.resources.Question;
import com.codeprehend.iqspace.util.InputValidation;

public class UpdateButtonListener implements ActionListener {
	private IQspaceAdminGUI mainWindow;
	
	public UpdateButtonListener(IQspaceAdminGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		String testId = mainWindow.getTxtQuestionTestId().getText();
		String questionId = mainWindow.getTxtQuestionNumber().getText();
		
		try {
			InputValidation.validateNumber(testId, false);
			InputValidation.validateNumber(questionId, false);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(mainWindow, exception.getMessage(), 
					"Eroare de Validare Insert/Update", JOptionPane.ERROR_MESSAGE);
			exception.printStackTrace();
			return;
		} 
		Long testNo = Long.parseLong(testId);
		Long questionNo = Long.parseLong(questionId);
		
		List<Question> questions =  QuestionsDAO.getQuestionByTestIdAndQuestionNumber(testNo, questionNo);
		
		Question questionFromPanel = new Question();
		questionFromPanel.setAnswer(mainWindow.getAnswer().getText());
		questionFromPanel.setExplanations(mainWindow.getExplanations().getText());
		questionFromPanel.setHint1(mainWindow.getHint1().getText());
		questionFromPanel.setOtherObservations(mainWindow.getOtherObservations().getText());
		questionFromPanel.setQuestion(mainWindow.getQuestionText().getText());
		questionFromPanel.setQuestionNumber(questionNo);
		questionFromPanel.setTestId(testNo);
		questionFromPanel.setQuestionType(mainWindow.getQuestionType().getText());
		questionFromPanel.setWrongAnswer1(mainWindow.getWrongAnswer1().getText());
		questionFromPanel.setWrongAnswer2(mainWindow.getWrongAnswer2().getText());
		
		if (questions != null && questions.size() > 0) {
			//update question 
			try {
				questionFromPanel.setId(questions.get(0).getId());
				QuestionsDAO.updateQuestion(questionFromPanel);
				JOptionPane.showMessageDialog(mainWindow,  
						"Intrebarea " + questionNo + " din testul " + testNo + " a fost updatata.", 
						"Update", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(mainWindow, exception.getMessage(), 
						"Eroare la updatarea intrebarii in DB. Vezi log.", JOptionPane.ERROR_MESSAGE);
				exception.printStackTrace();
				return;
			}
		} else {
			QuestionsDAO.saveQuestion(questionFromPanel);
			JOptionPane.showMessageDialog(mainWindow,
					"Intrebarea " + questionNo + " din testul " + testNo + " a fost salvata.", 
					"Salvat", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
