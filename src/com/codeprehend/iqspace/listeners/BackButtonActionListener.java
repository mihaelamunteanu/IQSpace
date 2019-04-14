package com.codeprehend.iqspace.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.resources.Question;

public class BackButtonActionListener implements ActionListener {
	
	private IQSpaceGUI mainWindow;
	
	public BackButtonActionListener(IQSpaceGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		int numberOfCurrentQuestion = mainWindow.getNumberOfCurrentQuestion();
		if (numberOfCurrentQuestion > 2) {
			numberOfCurrentQuestion = numberOfCurrentQuestion - 1;
			Question question = mainWindow.getQuestionsForTest().get(numberOfCurrentQuestion - 1);
			mainWindow.setNumberOfCurrentQuestion(numberOfCurrentQuestion);
			mainWindow.showQuestionPanel(question);
		}
		else { 
			JOptionPane.showMessageDialog(mainWindow, "Este deja prima pagina!", "Notificare" , JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
