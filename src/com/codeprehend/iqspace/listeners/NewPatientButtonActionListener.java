package com.codeprehend.iqspace.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.codeprehend.iqspace.IQSpaceGUI;

public class NewPatientButtonActionListener implements ActionListener {
	private IQSpaceGUI mainWindow;
	
	public NewPatientButtonActionListener(IQSpaceGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		mainWindow.showNewPatientPanel();
		
	}
}
