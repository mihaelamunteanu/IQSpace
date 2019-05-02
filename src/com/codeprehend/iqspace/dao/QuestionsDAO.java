package com.codeprehend.iqspace.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codeprehend.iqspace.resources.Question;
import com.codeprehend.iqspace.util.Constants;
import com.codeprehend.iqspace.util.DatabaseConnection;;

public class QuestionsDAO {
	
	private static final Logger LOGGER = Logger.getLogger(Constants.LOGGER_NAME);
	
	/**
	 * Return the generated id from sequence. 
	 * @param question
	 * @return generated id from sequence for questions table. if an error occurs returns -1.
	 */
	public static Long saveQuestion(Question question) {
		Long generatedId = -1L;
		String SQL = "INSERT into questions "
				+ "(test_id, question, question_type, answer, answer_explanations, "
				+ "hint1, hint2, other_observations, question_number, wrong_answer1, wrong_answer2, image1) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL,  PreparedStatement.RETURN_GENERATED_KEYS)) {
			LOGGER.log(Level.INFO, "Save question: " + stmt.toString());	

			stmt.setObject(1, question.getTestId());
			stmt.setObject(2, question.getQuestion());
			stmt.setObject(3, question.getQuestionType());
			stmt.setObject(4, question.getAnswer());
			stmt.setObject(5, question.getExplanations());
			stmt.setObject(6, question.getHint1());
			stmt.setObject(7, question.getHint2());
			stmt.setObject(8, question.getOtherObservations());
			stmt.setObject(9, question.getQuestionNumber());
			stmt.setObject(10, question.getWrongAnswer1());
			stmt.setObject(11, question.getWrongAnswer2());
			stmt.setObject(12, question.getImage());
			
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
	
	public static List<Question> getQuestionsByTestId(Long id) {
		List<Question> questionsForTest =new ArrayList<Question>();

		String SQL = "SELECT * FROM questions WHERE test_id = ? ORDER BY question_number ASC, id DESC;";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, id);
			
			LOGGER.log(Level.INFO, "Retrieve qustion: " + stmt.toString());	
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
//				byte[] image = rs.getBytes("image1");
				Question question = new Question(rs.getLong("id"), id, rs.getString("question"), 
						rs.getString("question_type"), rs.getString("answer"), rs.getString("answer_explanations"),
						rs.getString("hint1"), rs.getString("hint2"),
						rs.getString("other_observations"), rs.getLong("question_number"), rs.getString("image1"),
						rs.getString("wrong_answer1"), rs.getString("wrong_answer2"));
				questionsForTest.add(question);
			}
			rs.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return questionsForTest;
	}
	
	public static List<Question> getQuestionByTestIdAndQuestionNumber(Long id, Long no) {
		List<Question> questionsForTest =new ArrayList<Question>();

		String SQL = "SELECT * FROM questions WHERE test_id = ? AND question_number = ? ORDER BY question_number ASC, id DESC;";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, id);
			stmt.setObject(2, no);
			
			LOGGER.log(Level.INFO, "Retrieve qustion: " + stmt.toString());	
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				Question question = new Question(rs.getLong("id"), id, rs.getString("question"), 
						rs.getString("question_type"), rs.getString("answer"), rs.getString("answer_explanations"),
						rs.getString("hint1"), rs.getString("hint2"),
						rs.getString("other_observations"), rs.getLong("question_number"), rs.getString("image1"),
						rs.getString("wrong_answer1"), rs.getString("wrong_answer2"));
				questionsForTest.add(question);
			}
			rs.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return questionsForTest;
	}
	
	public static Long updateQuestion(Question question) throws Exception {
		String SQL = "UPDATE questions	 " + 
				"SET test_id = ?, question_type = ?, question_number = ?, question = ?, "
				+ "answer = ?, hint1 = ?, wrong_answer1 = ?, wrong_answer2 = ?, " 
				+ "answer_explanations = ?, other_observations = ?, image1 = ? " + 
				"WHERE id = ?;";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);) {
			stmt.setObject(1, question.getTestId());
			stmt.setObject(2, question.getQuestionType());
			stmt.setObject(3, question.getQuestionNumber());
			stmt.setObject(4, question.getQuestion());
			stmt.setObject(5, question.getAnswer());
			stmt.setObject(6, question.getHint1());
			stmt.setObject(7, question.getWrongAnswer1());
			stmt.setObject(8, question.getWrongAnswer2());
			stmt.setObject(9, question.getExplanations());
			stmt.setObject(10, question.getOtherObservations());
			stmt.setObject(11, question.getImage());
			stmt.setObject(12, question.getId());
			
			LOGGER.log(Level.INFO, stmt.toString());
						
			stmt.executeUpdate();
 		} 
		
		return question.getId();
	}
}
