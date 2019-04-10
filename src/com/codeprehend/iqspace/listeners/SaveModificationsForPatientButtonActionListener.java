package com.codeprehend.iqspace.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.dao.AntecedentsDAO;
import com.codeprehend.iqspace.dao.ExaminationDAO;
import com.codeprehend.iqspace.dao.PatientsDAO;
import com.codeprehend.iqspace.resources.Antecedent;
import com.codeprehend.iqspace.resources.Examination;
import com.codeprehend.iqspace.resources.Patient;
import com.codeprehend.iqspace.util.InputValidation;
import com.codeprehend.iqspace.util.Utils;

public class SaveModificationsForPatientButtonActionListener implements ActionListener {
	
	private IQSpaceGUI mainWindow;
	private Patient oldPatient;
	
	public SaveModificationsForPatientButtonActionListener(IQSpaceGUI mainWindow, Patient oldPatient){
		this.mainWindow = mainWindow;
		this.oldPatient = oldPatient;
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = mainWindow.getModifyPatientPanel().getTextFieldName().getText();
		String firstName = mainWindow.getModifyPatientPanel().getTextFieldFirstName().getText();
		String birthDate = mainWindow.getModifyPatientPanel().getTextFieldDate().getText();
		String phoneNumber = mainWindow.getModifyPatientPanel().getTextFieldPhoneNumber().getText();
		String regNumber = mainWindow.getModifyPatientPanel().getTextFieldRegNumber().getText();
		String naturalBirths = mainWindow.getModifyPatientPanel().getTextFieldNaturalBirthsNumber().getText();
		String csectionBirths = mainWindow.getModifyPatientPanel().getTextFieldcSectionBirthNumber().getText();
		String requestedAborstions = mainWindow.getModifyPatientPanel().getTextFieldRequestedAbortionNumber().getText();
		String spontaneusAbortions = mainWindow.getModifyPatientPanel().getTextFieldSpotaneousAbortionNumber().getText();
		
		String altele = "Not used";
		String address = "Not needed";
		
		String antecedents = mainWindow.getModifyPatientPanel().getTextAreaAntecedents().getText();
		
		Patient newPatient = new Patient();
		
		try {
			InputValidation.validateTextField(name);
			InputValidation.validateTextField(firstName);
			InputValidation.validatePhoneNumber(phoneNumber);
			InputValidation.validateRegNumber(regNumber);
			InputValidation.validateBirthsNumber(naturalBirths, false);
			InputValidation.validateBirthsNumber(csectionBirths, false);
			InputValidation.validateBirthsNumber(requestedAborstions, false);
			InputValidation.validateBirthsNumber(spontaneusAbortions, false);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(mainWindow, exception.getMessage(), 
					"Erore de Validare", JOptionPane.ERROR_MESSAGE);
			exception.printStackTrace();
			return;
		}
		
		try {
			newPatient.setDataNasterii(Utils.parseLocalDate(birthDate));
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(mainWindow, "Data nasterii nu este corecta", 
					"Erore de Validare", JOptionPane.ERROR_MESSAGE);
			exception.printStackTrace();
			return;
		}
		
		//save the Patient
		newPatient.setNume(name);
		newPatient.setPrenume(firstName);
		newPatient.setCnp(regNumber);
		newPatient.setPrimaConsultatie(LocalDate.now());
		newPatient.setAdresa(address);
		newPatient.setNumarTelefon(phoneNumber);
		newPatient.setAltele(altele);
		newPatient.setNasteriNaturale(Integer.valueOf(naturalBirths));
		newPatient.setCezariene(Integer.valueOf(csectionBirths));
		newPatient.setAvorturiLaCerere(Integer.valueOf(requestedAborstions));
		newPatient.setAvorturiSpontane(Integer.valueOf(spontaneusAbortions));
		newPatient.setId(oldPatient.getId());
		try {
			PatientsDAO.updatePatient(newPatient);
		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(mainWindow, "Pacientul " + name + " " + firstName + " nu a putut fi modificat ", 
					"Erroare", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (mainWindow.getModifyPatientPanel().getTextAreaAntecedents().getText().length() > 0) {
			Antecedent antecedent = new Antecedent(oldPatient.getId(), antecedents, LocalDate.now());
			Long antecedentId = AntecedentsDAO.saveAntecedente(antecedent);
			
			if (antecedentId <= 0) {
				JOptionPane.showMessageDialog(mainWindow, "Antecedentele pacientului " + name + " " + firstName + " nu au fost inregistrate ", 
						"Erroare", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		JOptionPane.showMessageDialog(mainWindow, "Patient modificat " + name + " " + firstName + " cu succes", 
				"Confirmare modificare", JOptionPane.INFORMATION_MESSAGE);
		
		List<Antecedent> antecedentsList = AntecedentsDAO.getAntecedentsByPatientId(newPatient.getId());
		List <Examination> examinationsList = ExaminationDAO.getExaminationsByPatientId(newPatient.getId());
		mainWindow.showExaminationPatientPanel(newPatient, antecedentsList, examinationsList);
	}
	
}
