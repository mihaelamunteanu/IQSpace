package com.codeprehend.iqspace.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.codeprehend.iqspace.dao.TestsDAO;
import com.codeprehend.iqspace.resources.Test;
import com.codeprehend.iqspace.util.InputValidation;

public class SearchTestButtonListener implements ActionListener {
	private IQspaceAdminGUI mainWindow;
	
	public SearchTestButtonListener(IQspaceAdminGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		String searchTestId = mainWindow.getSearchTestNumber().getText();
		String searchTestName = mainWindow.getSearchTestTitle().getText();
		
		try {
			InputValidation.validateNumber(searchTestId, true);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(mainWindow, exception.getMessage(), 
					"Eroare de Validare", JOptionPane.ERROR_MESSAGE);
			exception.printStackTrace();
			return;
		} 
		
		Test test = null;
		if (searchTestName != null && !searchTestName.isEmpty()) {
			test = TestsDAO.getTestByTitle(searchTestName);
		} else {
			Long testNo = Long.parseLong(searchTestId);
			test = TestsDAO.getTestById(testNo);
		}
		
		mainWindow.reset();
		mainWindow.setTest(test);
	}
}
