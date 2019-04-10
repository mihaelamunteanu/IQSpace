
package com.codeprehend.iqspace.dao;

import java.io.ByteArrayInputStream;
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

import com.codeprehend.iqspace.resources.Attachement;
import com.codeprehend.iqspace.util.Constants;
import com.codeprehend.iqspace.util.DatabaseConnection;

public class AtachementsDAO {
	
	private static final Logger LOGGER = Logger.getLogger(Constants.LOGGER_NAME);
	
	/**
	 * Method to save attachment into DB.
	 * 
	 * @param antecedent
	 * @return the generated id from sequence 
	 */
	public static Long saveAttachment(Attachement attachment) {
		Long generatedId = -1L;
		String SQL = "INSERT into atasamente "
				+ "(pacient_id, nume_fisier, tip_fisier, lungime_fisier, "
				+ "atasament, data_salvare) values (?,?,?,?,?,?);";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);) {
			stmt.setObject(1, attachment.getPacientId());
			stmt.setObject(2, attachment.getFileName());
			stmt.setObject(3, attachment.getFileType());
			stmt.setObject(4, attachment.getFileLength());
			stmt.setBinaryStream(5, new ByteArrayInputStream(attachment.getFileStream()));
			stmt.setObject(6, attachment.getRegistrationDate());
			
			LOGGER.log(Level.INFO, "Save attachments: " + stmt.toString());	
			
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
	
	//TODO change to Date type instead String
	public static List<Attachement> getAttachmentsByPatientId(Long patientId) {
		List<Attachement> attachmentsForPatient = new ArrayList<Attachement>();
		String SQL = "SELECT * from  atasamente "
				+ "where pacient_id = ? ORDER BY data_salvare DESC; ";
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, patientId);
			
			LOGGER.log(Level.INFO, "Retrieve attachments: " + stmt.toString());	
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				Attachement attachement = new Attachement(patientId, rs.getString("nume_fisier"),
						rs.getString("tip_fisier"), 0, null, 
						LocalDate.parse(rs.getString("data_salvare"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				attachement.setId(rs.getLong("id"));
				attachmentsForPatient.add(attachement);
			}
			rs.close();
 		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return attachmentsForPatient;	
	}
	
	//TODO change to Date type instead String
	public static Attachement getAttachmentsById(Long attachmentId) {
		Attachement attachmentById = null;
		String SQL = "SELECT * from  atasamente WHERE id = ?; ";
		
		
		try (Connection conn = DatabaseConnection.getDatabaseConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL)) {
			stmt.setObject(1, attachmentId);
			
			LOGGER.log(Level.INFO, "Retreieve attachments: " + stmt.toString());	
			
			ResultSet rs = stmt.executeQuery();
			while (rs != null && rs.next()) {
				byte[] pdfAttachment = rs.getBytes("atasament");
				attachmentById = new Attachement(rs.getLong("pacient_id"), rs.getString("nume_fisier"),
						rs.getString("tip_fisier"), 0, pdfAttachment, 
						LocalDate.parse(rs.getString("data_salvare"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				attachmentById.setId(rs.getLong("id"));
			}
			rs.close();
 		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return attachmentById;
	}
}
