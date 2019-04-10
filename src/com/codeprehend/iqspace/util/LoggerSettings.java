package com.codeprehend.iqspace.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerSettings {
	private static final Logger LOGGER = Logger.getLogger(Constants.LOGGER_NAME);
	
	public static void setLoggerSetting(String loggerOutputLocation) {
		try {
			FileHandler fh = new FileHandler(loggerOutputLocation);
			LOGGER.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  
	        
	        LOGGER.log(Level.INFO, "Log properties set");	
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
