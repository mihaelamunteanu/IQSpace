package com.codeprehend.iqspace.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
	
	private static final Logger LOGGER = Logger.getLogger(Constants.LOGGER_NAME);
	
	public static Properties prop = new Properties();
	
	public static LocalDate parseLocalDate(String date) {
		if (date.contains("."))
			return LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
		else 
			return LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.SLASH_DATE_PATTER));
	
	}
	
	public static String fromDateToString(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern(Constants.DATE_PATTERN));
	}
	
	public static void loadProperties() {
		InputStream input = null; 
		
		try {
	
			input = new FileInputStream("config.properties");
	
			// load a properties file
			prop.load(input);
	
			// get the property value and print it out
			LOGGER.log(Level.INFO, "Loaded DB Server Name: " + prop.getProperty("dbserver"));	
			LOGGER.log(Level.INFO, "Loaded DB Port       : " + prop.getProperty("dbport"));
			LOGGER.log(Level.INFO, "Loaded DB User       : " + prop.getProperty("dbuser"));
			LOGGER.log(Level.INFO, "Images location       : " + prop.getProperty("image_location"));
			
			DatabaseConnection.loadDatabaseProperties(prop.getProperty("dbserver"), 
					prop.getProperty("dbport"), prop.getProperty("dbuser"), prop.getProperty("dbpass"));
			
			String loggerLocation = prop.getProperty("log_location");
			String dateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
			String logFileName = "log" + dateTime.substring(0, 
					dateTime.lastIndexOf(".")).replaceAll(":", "_") + "." + "log";
			if (loggerLocation != null && !loggerLocation.isEmpty()) {
				LoggerSettings.setLoggerSetting(loggerLocation + "\\" + logFileName);
			} else {
				LoggerSettings.setLoggerSetting("." + "\\" + logFileName);
			}
			
			String imagesLocation = prop.getProperty("image_location");
			if (imagesLocation != null && !imagesLocation.isEmpty()) {
				ImageSettings.setImageLocation(imagesLocation);
			} else {
				ImageSettings.setImageLocation("\\");
			}
		} catch (IOException ex) {
			LOGGER.log(Level.SEVERE, "Error reading config.properties file", ex);
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void loadLoggingProperties( ) {
		
	}
	
	/**
	 * Public static method to detect the number of lines in a text. 
	 * 
	 * @param text
	 * @return number of lines in the given text
	 */
	public static int countLines(String text) {
	    if(text == null || text.isEmpty())
	    {
	        return 0;
	    }
	    int lines = 1;
	    int pos = 0;
	    while ((pos = text.indexOf("\n", pos) + 1) != 0) {
	        lines++;
	    }
	    return lines;
	}
	
	/**
	 * Method to get the index of the nth occurrence of a char. It will be used mainly for newline \n.
	 * 
	 * @param str
	 * @param c
	 * @param n
	 * @return position of nth occurrence of char c in the given text
	 */
	public static int nthLastIndexOf(String text, char c, int n) {
	    for (int i = 0; i < text.length(); i++)
	    {
	        if (text.charAt(i) == c)
	        {
	            n--;
	            if (n == 0)
	            {
	                return i;
	            }
	        }
	    }
	    return -1;
	}

}
