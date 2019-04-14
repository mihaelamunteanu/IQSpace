package com.codeprehend.iqspace.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageSettings {
	private static final Logger LOGGER = Logger.getLogger(Constants.LOGGER_NAME);
	public static String IMAGES_LOCATION;
	
	public static void setImageLocation(String imagesLocation) {
		IMAGES_LOCATION = imagesLocation;
	        
	    LOGGER.log(Level.INFO, "Image location properties set");	
	}
}
