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

import com.codeprehend.iqspace.resources.Examination;
import com.codeprehend.iqspace.util.Constants;
import com.codeprehend.iqspace.util.DatabaseConnection;;

public class ExaminationDAO {
	
	private static final Logger LOGGER = Logger.getLogger(Constants.LOGGER_NAME);
	
	/**
	 * Return the generated id from sequence. 
	 * @param exam
	 * @return generated id from sequence for consultatie table. if an error occurs returns -1.
	 */
	public static Long saveExamination(Examination exam) {
		Long generatedId = -1L;
		String SQL = "INSERT into consultatii "
				+ "(id_pacienta, data_consultatie, consultatie, alte_observatii) "
				+ "values (?, ?, ?, ?);";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL,  PreparedStatement.RETURN_GENERATED_KEYS)) {
			LOGGER.log(Level.INFO, "Save examination: " + stmt.toString());	

			stmt.setObject(1, exam.getPatientId());
			stmt.setObject(2, exam.getConsultationDate());
			stmt.setObject(3, exam.getText());
			stmt.setObject(4, exam.getOtherObservations());
			
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs != null && stmt.getGeneratedKeys().next()) {
				generatedId = stmt.getGeneratedKeys().getLong(1);
			}
			rs.close();
 		} catch (SQLException ex) {
 			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		
		return generatedId;	
	}
	
	public static List<Examination> getExaminationsByPatientId(Long id) {
		List<Examination> examinationsForPatient =new ArrayList<Examination>();

		String SQL = "SELECT * FROM consultatii WHERE id_pacienta = ? ORDER BY data_consultatie DESC, id DESC;";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, id);
			
			LOGGER.log(Level.INFO, "Retrieve examination: " + stmt.toString());	
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				Examination examination = new Examination(rs.getLong("id"), id, rs.getString("consultatie"), 
						LocalDate.parse(rs.getString("data_consultatie"), DateTimeFormatter.ofPattern("yyyy-MM-dd")), 
						rs.getString("alte_observatii"));
				examinationsForPatient.add(examination);
			}
			rs.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return examinationsForPatient;
	}
}
