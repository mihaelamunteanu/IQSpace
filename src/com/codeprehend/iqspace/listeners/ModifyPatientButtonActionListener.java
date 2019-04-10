package com.codeprehend.iqspace.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.dao.AntecedentsDAO;
import com.codeprehend.iqspace.resources.Antecedent;
import com.codeprehend.iqspace.resources.Patient;


public class ModifyPatientButtonActionListener implements ActionListener {
	
	private IQSpaceGUI mainWindow;
	private Patient patient;
	private String fromPanel;
	
	public ModifyPatientButtonActionListener(IQSpaceGUI mainWindow, Patient patient, String fromPanel){
		this.mainWindow = mainWindow;
		this.patient = patient;
		this.fromPanel = fromPanel;
	}

	public void actionPerformed(ActionEvent event){
		Long pacientId = patient.getId();
		List<Antecedent> antecedents = AntecedentsDAO.getAntecedentsByPatientId(pacientId);
		mainWindow.showModifyPatientPanel(patient, antecedents, fromPanel);
	}

}