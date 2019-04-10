package com.codeprehend.iqspace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codeprehend.iqspace.resources.Antecedent;
import com.codeprehend.iqspace.util.Constants;
import com.codeprehend.iqspace.util.DatabaseConnection;

public class AntecedentsDAO {
	
	private static final Logger LOGGER = Logger.getLogger(Constants.LOGGER_NAME);
	
	/**
	 * Method to save antecedent into DB.
	 * 
	 * @param antecedent
	 * @return the generated id from sequence 
	 */
	public static Long saveAntecedente(Antecedent antecedent) {
		Long generatedId = -1L;
		String SQL = "INSERT into antecedente "
				+ "(pacient_id, antecedent, data_inregistrare) "
				+ "values (?,?,?);";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);) {
			stmt.setObject(1, antecedent.getPacientId());
			stmt.setObject(2, antecedent.getAntecedentText());
			stmt.setObject(3, antecedent.getRegistrationDate());
			
			LOGGER.log(Level.INFO, "Save antecedents: " + stmt.toString());	
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs != null && stmt.getGeneratedKeys().next()) {
				generatedId = stmt.getGeneratedKeys().getLong(1);
			}
			rs.close();
 		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return generatedId;	
	}
	
	public static List<Antecedent> getAntecedentsByPatientId(Long patientId) {
		List<Antecedent> antecedentsForPatient =new ArrayList<Antecedent>();
		String SQL = "SELECT id, data_inregistrare, antecedent from  antecedente "
				+ "where pacient_id = ?; ";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, patientId);
			
			LOGGER.log(Level.INFO, "Retrieve antecedents: " + stmt.toString());	
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				Antecedent antecedent = new Antecedent(patientId, rs.getString("antecedent"), 
						LocalDate.parse(rs.getString("data_inregistrare"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				
				antecedentsForPatient.add(antecedent);
			}
			rs.close();
 		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return antecedentsForPatient;	
	}
	
}
