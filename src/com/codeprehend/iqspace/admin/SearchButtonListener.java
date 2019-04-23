package com.codeprehend.iqspace.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.codeprehend.iqspace.dao.QuestionsDAO;
import com.codeprehend.iqspace.resources.Question;
import com.codeprehend.iqspace.util.InputValidation;

public class SearchButtonListener implements ActionListener {
	private IQspaceAdminGUI mainWindow;
	
	public SearchButtonListener(IQspaceAdminGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		String searchTestId = mainWindow.getSearchQuestionTest().getText();
		String searchQestionId = mainWindow.getSearchQuestionNumber().getText();
		
		try {
			InputValidation.validateNumber(searchTestId, false);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(mainWindow, exception.getMessage(), 
					"Eroare de Validare", JOptionPane.ERROR_MESSAGE);
			exception.printStackTrace();
			return;
		} 
		Long testNo = Long.parseLong(searchTestId);
		
		try {
			InputValidation.validateNumber(searchQestionId, false);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(mainWindow, exception.getMessage(), 
					"Eroare de Validare", JOptionPane.ERROR_MESSAGE);
			exception.printStackTrace();
			return;
		} 
		Long questionNo = Long.parseLong(searchQestionId);
		
		List<Question> questions =  QuestionsDAO.getQuestionByTestIdAndQuestionNumber(testNo, questionNo);
		
		if (questions != null && questions.size() > 0) {
			mainWindow.reset();
			mainWindow.setQuestion(questions.get(0));
		} else {
			JOptionPane.showMessageDialog(mainWindow, "Nu exista intrebarea!", 
					"Inexistent", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
