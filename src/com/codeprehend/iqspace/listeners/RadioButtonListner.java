package com.codeprehend.iqspace.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import com.codeprehend.iqspace.IQSpaceGUI;

public class RadioButtonListner implements ActionListener {
	private IQSpaceGUI mainWindow;
	
	public RadioButtonListner(IQSpaceGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		
		JRadioButton btn = (JRadioButton) e.getSource();
        System.out.println("Selected Button = " + btn.getName());
        
		int numberOfCurrentQuestion = mainWindow.getNumberOfCurrentQuestion();
		
		mainWindow.getObtainedAnswers().set(numberOfCurrentQuestion - 1, btn.getName());
	}

}
