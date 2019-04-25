package com.codeprehend.iqspace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codeprehend.iqspace.resources.Test;
import com.codeprehend.iqspace.util.Constants;
import com.codeprehend.iqspace.util.DatabaseConnection;

public class TestsDAO {
	
	private static final Logger LOGGER = Logger.getLogger(Constants.LOGGER_NAME);
	
	public static Test getTestById(Long testId) {
		Test test = null;
		String SQL = "SELECT * FROM tests WHERE id = ?";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, testId);
			LOGGER.log(Level.INFO, "Retrieve test: " + stmt.toString());			
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				test = new Test(rs.getLong("id"), rs.getString("test_name"),
						rs.getString("observations"), LocalDate.parse(rs.getString("creation_date")), 
						rs.getString("test_type"), rs.getLong("number_of_questions"));
				test.setLastModification(LocalDate.parse(rs.getString("modification_date")));
			}
 		} catch (SQLException ex) {
 			LOGGER.log(Level.SEVERE, ex.getMessage());
		}
		
		return test;
	}

	
	public static Test getTestByTitle(String testName) {
		Test test = null;
		String SQL = "SELECT * FROM tests WHERE test_name = ?";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, testName);
			LOGGER.log(Level.INFO, "Retrieve test: " + stmt.toString());			
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				test = new Test(rs.getLong("id"), rs.getString("test_name"),
						rs.getString("observations"), LocalDate.parse(rs.getString("creation_date")), 
						rs.getString("test_type"), rs.getLong("number_of_questions"));
				test.setLastModification(LocalDate.parse(rs.getString("modification_date")));
			}
 		} catch (SQLException ex) {
 			LOGGER.log(Level.SEVERE, ex.getMessage());
		}
		
		return test;
	}
	
	public static Long updateTest(Test test) throws Exception {
		String SQL = "UPDATE tests " + 
				"SET test_name = ?, observations = ?, creation_date = ?, test_type = ?, "
				+ "number_of_questions = ?, modification_date = ? " + "WHERE id = ?;";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);) {
			stmt.setObject(1, test.getTestName());
			stmt.setObject(2, test.getObservations());
			stmt.setObject(3, test.getCreationDate());
			stmt.setObject(4, test.getTestType());
			stmt.setObject(5, test.getNumberOfQuestions());
			stmt.setObject(6, LocalDate.now());
			stmt.setObject(7, test.getId());
			
			
			LOGGER.log(Level.INFO, stmt.toString());
						
			stmt.executeUpdate();
 		} 
		
		return test.getId();
	}
	
	/**
	 * Data Access Method to save a Test into Database.
	 * 
	 * @param test
	 * @return Integer - the id generated for the Test
	 */
	public static Long saveTest(Test test) {
		Long generatedId = -1L;
		String SQL = "INSERT into tests "
				+ "(test_name, observations, creation_date, test_type, number_of_questions, modification_date) "
				+ "values ('" + test.getTestName() + "','" + test.getObservations() + "', '" 
				+ test.getCreationDate() + "', '" + test.getTestType() + "', '" 
				+ test.getNumberOfQuestions() + "', '" + test.getLastModification() + "');";
		
		LOGGER.log(Level.INFO, "Save test: " + SQL);	
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				Statement stmt = conn.createStatement();) {
			LOGGER.log(Level.INFO, "Save test: " + stmt.toString());	

			stmt.executeUpdate(SQL, new String[] {"id"});
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
}
