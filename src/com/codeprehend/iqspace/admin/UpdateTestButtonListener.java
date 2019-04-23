package com.codeprehend.iqspace.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.codeprehend.iqspace.dao.TestsDAO;
import com.codeprehend.iqspace.resources.Test;
import com.codeprehend.iqspace.util.InputValidation;

public class UpdateTestButtonListener implements ActionListener {
	private IQspaceAdminGUI mainWindow;
	
	public UpdateTestButtonListener(IQspaceAdminGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		String testId = mainWindow.getTestNumber().getText();
		String testName = mainWindow.getTestTitle().getText();
		
		String numberOfQuestionsString = mainWindow.getTestNumberOfQuestions().getText();
		
		try {
			InputValidation.validateNumber(testId, true);
			InputValidation.validateNumber(numberOfQuestionsString, true);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(mainWindow, exception.getMessage(), 
					"Eroare de Validare a campurilor Insert/Update", JOptionPane.ERROR_MESSAGE);
			exception.printStackTrace();
			return;
		} 
		Long testNo = 0L;
		if (testId != null && !testId.isEmpty())
			testNo = Long.parseLong(testId);
		Long noOfQuestions = 20L; 
		if (numberOfQuestionsString != null && !numberOfQuestionsString.isEmpty()) {
			noOfQuestions = Long.parseLong(numberOfQuestionsString);
		}
		
		Test test =  null;
		if (testName != null && !testName.isEmpty()) {
			test = TestsDAO.getTestById(testNo);
		} else if (testNo> 0) {
			test = TestsDAO.getTestByTitle(testName);
		}
		
		Test testFromPanel = new Test();
		testFromPanel.setNumberOfQuestions(noOfQuestions);
		testFromPanel.setObservations(mainWindow.getTestObservations().getText());
		testFromPanel.setTestName(mainWindow.getTestTitle().getText());
		testFromPanel.setTestType(mainWindow.getTestType().getText());
		testFromPanel.setLastModification(LocalDate.now());
		
		if (test != null) {
			//update question 
			try {
				TestsDAO.updateTest(testFromPanel);
				JOptionPane.showMessageDialog(mainWindow, null, 
						"Testul " + testName + " cu id-ul " + testNo + "a fost updatat.", 
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(mainWindow, exception.getMessage(), 
						"Eroare la updatarea testului in DB. Vezi log.", JOptionPane.ERROR_MESSAGE);
				exception.printStackTrace();
				return;
			}
		} else {
			testFromPanel.setCreationDate(LocalDate.now());
			TestsDAO.saveTest(testFromPanel);
			JOptionPane.showMessageDialog(mainWindow, "Testul " + testName + "a fost salvat.", 
					null, JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
