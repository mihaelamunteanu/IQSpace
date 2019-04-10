package com.codeprehend.iqspace.listeners;

import java.util.List;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.dao.ExaminationDAO;
import com.codeprehend.iqspace.resources.Antecedent;
import com.codeprehend.iqspace.resources.Examination;
import com.codeprehend.iqspace.resources.Patient;

public class BackFromModifyPatientPanelButtonActionListener {
	
	public static void backButtonPressed(IQSpaceGUI mainPanel, Patient patient, 
			List<Antecedent> antecedents){
		List<Examination> examinations = ExaminationDAO.getExaminationsByPatientId(patient.getId());
		mainPanel.showExaminationPatientPanel(patient, antecedents, examinations);
	}
}
