package com.codeprehend.iqspace.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.dao.AntecedentsDAO;
import com.codeprehend.iqspace.dao.PatientsDAO;
import com.codeprehend.iqspace.resources.Antecedent;
import com.codeprehend.iqspace.resources.Examination;
import com.codeprehend.iqspace.resources.Patient;
import com.codeprehend.iqspace.util.InputValidation;
import com.codeprehend.iqspace.util.Utils;

public class SaveNewPatientButtonActionListener implements ActionListener {
	
	private IQSpaceGUI mainWindow;
	
	public SaveNewPatientButtonActionListener(IQSpaceGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = mainWindow.getNewPatientPanel().getTextFieldName().getText();
		String firstName = mainWindow.getNewPatientPanel().getTextFieldFirstName().getText();
		String birthDate = mainWindow.getNewPatientPanel().getTextFieldDate().getText();
		String phoneNumber = mainWindow.getNewPatientPanel().getTextFieldPhoneNumber().getText();
		String regNumber = mainWindow.getNewPatientPanel().getTextFieldRegNumber().getText();
		String naturalBirths = mainWindow.getNewPatientPanel().getTextFieldNaturalBirthsNumber().getText();
		String csectionBirths = mainWindow.getNewPatientPanel().getTextFieldcSectionBirthNumber().getText();
		String requestedAborstions = mainWindow.getNewPatientPanel().getTextFieldRequestedAbortionNumber().getText();
		String spontaneusAbortions = mainWindow.getNewPatientPanel().getTextFieldSpotaneousAbortionNumber().getText();
		
		String altele = "Not used";
		String address = "Not needed";
		
		String antecedents = mainWindow.getNewPatientPanel().getTextAreaAntecedents().getText();
		
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

		Long patientId = PatientsDAO.savePatient(newPatient);
		
		if (patientId <= 0) {
			JOptionPane.showMessageDialog(mainWindow, "Pacientul " + name + " " + firstName + " nu a putut fi inregistrat ", 
					"Erroare", JOptionPane.ERROR_MESSAGE);
			return;
		}
		newPatient.setId(patientId);
		if (antecedents != null && antecedents.length() > 0) {
			Antecedent antecedent = new Antecedent(patientId, antecedents, LocalDate.now());
			Long antecedentId = AntecedentsDAO.saveAntecedente(antecedent);
			
			if (antecedentId > 0) {
				JOptionPane.showMessageDialog(mainWindow, "Patient inregistrat " + name + " " + firstName + " cu succes", 
						"Confirmare inregistrare", JOptionPane.INFORMATION_MESSAGE);
				List<Antecedent> antecedentsList = new ArrayList<Antecedent>();
				antecedentsList.add(antecedent);
				List<Examination> examinationsList = new ArrayList<Examination>();
				
				List <Patient> listOfPatients =  new ArrayList<Patient>();
				listOfPatients.add(newPatient);
				mainWindow.showPanelListOfPatients(listOfPatients);
				mainWindow.showExaminationPatientPanel(newPatient, antecedentsList, examinationsList);
			} else {
				JOptionPane.showMessageDialog(mainWindow, "Antecedentele pacientului " + name + " " + firstName + " nu au fost inregistrate ", 
						"Erroare", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} else {
			JOptionPane.showMessageDialog(mainWindow, "Patient inregistrat " + name + " " + firstName + " cu succes", 
					"Confirmare inregistrare", JOptionPane.INFORMATION_MESSAGE);
			List<Antecedent> antecedentsList = new ArrayList<Antecedent>();
			List<Examination> examinationsList = new ArrayList<Examination>();
			
			List <Patient> listOfPatients =  new ArrayList<Patient>();
			listOfPatients.add(newPatient);
			mainWindow.showPanelListOfPatients(listOfPatients);
			mainWindow.showExaminationPatientPanel(newPatient, antecedentsList, examinationsList);
		}
		
	}
}
