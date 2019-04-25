package com.codeprehend.iqspace.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codeprehend.iqspace.resources.AnswersPosition;

public class Utils {
	
	private static final Logger LOGGER = Logger.getLogger(Constants.LOGGER_NAME);
	
	public static Properties prop = new Properties();
	
	/**
	 * Returns a random number between 1 and 3 (it will be used to choose from three options).
	 * 
	 * @return int a rondom number 1, 2 or 3
	 */
	public static int getRandomOption(int x){
        Random r = new Random();

        int i = r.nextInt()%x;

        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            default:
            	return 1;
        }

    }
	
	public static List<AnswersPosition> getRandomPositionsForAnswers(long sizeOfList){
		List<AnswersPosition> radomPositions = new ArrayList<>((int)sizeOfList);
		for (int i = 0; i < sizeOfList; i++) {
			AnswersPosition answersPosition = new AnswersPosition();
			int x = getRandomOption(3);
			
			int y = getRandomOption(2);
			if (x==2) {
				if (y==1) y=1; else y=3;
			} else if (x==1) {
				if (y==1) y=2; else y=3;
			}
				
			; //2 options left, calculate to be a number other than x
			int z = 6-x-y;//left number other than 
			
			answersPosition.setPositionOfCorrectAnswer(x); //3 options
			answersPosition.setPositionOfWrongAnswer1(y); 
			answersPosition.setPositionOfWrongAnswer2(z);
			
			radomPositions.add(answersPosition);
		}
		return radomPositions;
	}
	
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
