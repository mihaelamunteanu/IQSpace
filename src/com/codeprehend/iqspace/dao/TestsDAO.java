package com.codeprehend.iqspace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codeprehend.iqspace.resources.Test;
import com.codeprehend.iqspace.util.Constants;
import com.codeprehend.iqspace.util.DatabaseConnection;
import com.codeprehend.iqspace.util.Utils;

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
			}
 		} catch (SQLException ex) {
 			LOGGER.log(Level.SEVERE, ex.getMessage());
		}
		
		return test;
	}
	
	public static Long updateTest(Test test) throws Exception {
		String SQL = "UPDATE tests " + 
				"SET test_name = ?, observations = ?, creation_date = ?, test_type = ?, "
				+ "number_of_questions = ? " + "WHERE id = ?;";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);) {
			stmt.setObject(1, test.getTestName());
			stmt.setObject(2, test.getObservations());
			stmt.setObject(3, test.getCreationDate());
			stmt.setObject(4, test.getTestType());
			stmt.setObject(5, test.getNumberOfQuestions());
			stmt.setObject(6, test.getId());
			
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
				+ "(test_name, observations, creation_date, test_type, number_of_questions) "
				+ "values ('" + test.getTestName() + "','" + test.getObservations() + "', '" 
				+ test.getCreationDate() + "', '" + test.getTestType() + "', '" 
				+ test.getNumberOfQuestions() + "');";
		
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

	public static List<Test> getTestsByFilter(String testName, String testType, 
			Long numberOfQuestions, LocalDate creationDate) {
		List<Test> testsWithDate =new ArrayList<Test>();
		StringBuilder filterBuilder = new StringBuilder();
		

		boolean nextAndNeeded = addWhereClause("test_name", testName, filterBuilder, false);
		nextAndNeeded = addWhereClause("test_type", testType, filterBuilder, nextAndNeeded);
		nextAndNeeded = addWhereClauseForLong("number_of_questions", numberOfQuestions, filterBuilder, nextAndNeeded);
		nextAndNeeded = addWhereClauseForDate("creation_date", creationDate.toString(), filterBuilder, nextAndNeeded);
		filterBuilder.append("ORDER BY nume, prenume;");
		
		String SQL = "SELECT id, testName, observations, creation_date, test_type, number_of_question "
				+ "FROM paciente " + filterBuilder.toString();
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SQL)) {
			LOGGER.log(Level.INFO, "Retrieve tests: " + SQL);	
			// get the test information
			while(rs.next()) {
				Test pacient = new Test(rs.getLong("id"), rs.getString("test_name"),
						rs.getString("observations"), LocalDate.parse(rs.getString("creation_date")), 
						rs.getString("test_type"), rs.getLong("number_of_questions"));
				testsWithDate.add(pacient);	
			}
			rs.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return testsWithDate;
	}
	
	/**
	 * Method to add filters to where
	 * For example for ("name", "Astanei", empty, true) the return will be true 
	 * which means an ' AND ' has to be added for the next filters and 
	 * the StringBuilder object will have the value: " AND name='Astanei' "
	 * 
	 * @param filterName
	 * @param filter
	 * @param whereClauseBuilder
	 * @param andNeeded
	 * @return
	 */
	private static boolean addWhereClause(String filterName, String filter, StringBuilder whereClauseBuilder, boolean andNeeded) {
		boolean nextAndNeeded = false;
		if (filter !=  null && filter.length() > 0) {
			if (andNeeded) whereClauseBuilder.append(" AND ");
			else whereClauseBuilder.append(" WHERE ");
			whereClauseBuilder.append(filterName + " = '" + filter + "'");
			nextAndNeeded = true;
		} else if (andNeeded) {
			nextAndNeeded = true;
		}
		
		return nextAndNeeded;
	}

	private static boolean addWhereClauseForDate(String filterName, String filter, StringBuilder whereClauseBuilder, boolean andNeeded) {
		boolean nextAndNeeded = false;
		if (filter !=  null && filter.length() > 0) {
			if (andNeeded) whereClauseBuilder.append(" AND ");
			else whereClauseBuilder.append(" WHERE ");
			whereClauseBuilder.append(filterName + " = '" + Utils.parseLocalDate(filter).toString() + "'");
			nextAndNeeded = true;
		} else if (andNeeded) {
			nextAndNeeded = true;
		}
		
		return nextAndNeeded;
	}
	

	private static boolean addWhereClauseForLong(String filterName, Long filter, StringBuilder whereClauseBuilder, boolean andNeeded) {
		boolean nextAndNeeded = false;
		if (filter !=  null && filter > 0) {
			if (andNeeded) whereClauseBuilder.append(" AND ");
			else whereClauseBuilder.append(" WHERE ");
			whereClauseBuilder.append(filterName + " = '" + String.valueOf(filter) + "'");
			nextAndNeeded = true;
		} else if (andNeeded) {
			nextAndNeeded = true;
		}
		
		return nextAndNeeded;
	}
}
