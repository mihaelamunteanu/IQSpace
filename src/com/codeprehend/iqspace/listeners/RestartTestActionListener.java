package com.codeprehend.iqspace.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codeprehend.iqspace.IQSpaceGUI;

public class RestartTestActionListener implements ActionListener {
	private IQSpaceGUI mainWindow;
	
	public RestartTestActionListener(IQSpaceGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		mainWindow.setNumberOfCurrentQuestion(1);
		mainWindow.reset();
		mainWindow.showQuestionPanel(mainWindow.getQuestionsForTest().get(0));
	}
}
