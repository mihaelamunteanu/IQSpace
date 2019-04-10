package com.codeprehend.iqspace.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton class to get the Database Connection Instance
 *
 * @since 4 Dec 2018
 */
public class DatabaseConnection {
	private static String url = "jdbc:postgresql://localhost:5432/CabinetRugina";
    private static String server = "localhost";
    private static String port = "5432";
    private static String user = "postgres";
    private static String password = "root";
    private static int accessed = 0;
    
	private static Connection conn = null;

	public static void loadDatabaseProperties(String serverName, String portNo, String userDb, String passDb) {
		if (accessed == 0) {
			if (serverName != null && !serverName.isEmpty()) server = serverName;
			if (portNo != null && !portNo.isEmpty()) port = portNo;
			if (userDb != null && !userDb.isEmpty()) user = userDb;
			if (passDb != null && !passDb.isEmpty()) password = passDb;
			
			url = "jdbc:postgresql://" + server + ":" + port + "/CabinetRugina";
			
			accessed = 1;
		}
		
	}
	
	/** Private Constructor, only static references */
	private DatabaseConnection() {
		
	}
	
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    private static Connection connect() {
        
        try {
            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
    
    /**
     * The public method to get the instance of database connection.
     * 
     * @return Connection - the connection instance to database
     */
    public static Connection getDatabaseConnection() {
    	try {
			if (conn == null || conn.isClosed()) {
				conn = DatabaseConnection.connect();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return conn;
    }

}
