package com.codeprehend.iqspace.listeners;

import java.util.List;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.dao.AtachementsDAO;
import com.codeprehend.iqspace.resources.Attachement;
import com.codeprehend.iqspace.resources.Patient;

public class AccesFilesExaminationButtonActionListener {
	
	public static void actionPerformed(IQSpaceGUI mainWindow, Patient patient){
		List<Attachement> attachements = AtachementsDAO.getAttachmentsByPatientId(patient.getId());
		mainWindow.showFilesPatientPanel(patient, attachements);
	}
}
