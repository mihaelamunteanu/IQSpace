package com.codeprehend.iqspace.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codeprehend.iqspace.IQSpaceGUI;

public class BackFromListOfPatientsPanelButtonActionListener implements ActionListener {
	private IQSpaceGUI mainWindow;
	
	public BackFromListOfPatientsPanelButtonActionListener(IQSpaceGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		mainWindow.showSearchPatientPanel();
		
	}
}
