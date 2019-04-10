package com.codeprehend.iqspace.listeners;

import java.util.List;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.dao.AntecedentsDAO;
import com.codeprehend.iqspace.dao.ExaminationDAO;
import com.codeprehend.iqspace.dao.PatientsDAO;
import com.codeprehend.iqspace.resources.Antecedent;
import com.codeprehend.iqspace.resources.Examination;
import com.codeprehend.iqspace.resources.Patient;

public class AccessExamButtonActionListener  {
	
	public static void actionPerformed(IQSpaceGUI mainWindow, Patient patient){
		Patient newPatient = PatientsDAO.getPatientById(patient.getId());
		List<Antecedent> antecedents = AntecedentsDAO.getAntecedentsByPatientId(patient.getId());
		List<Examination> examinations = ExaminationDAO.getExaminationsByPatientId(patient.getId());
		
		mainWindow.showExaminationPatientPanel(newPatient, antecedents, examinations);
		
	}

}
