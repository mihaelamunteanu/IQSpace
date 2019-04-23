package com.codeprehend.iqspace.admin;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.codeprehend.iqspace.util.Constants;
import com.codeprehend.iqspace.util.Utils;

/** 
 * Main class launcher. 
 * 
 * @author Gabriel Munteanu
 *
 */
public class IQSpaceLauncherAdmin {
	/**
	 * Versiunea se incrementeaza dupa versiunea bazei de date. 
	 * Cand se modifica DB fara sa se mofice aplicatia creste doar versiunea minora la DB 
	 * 	e.g. 1.0 -> 1.1
	 * Cand se modifica aplicatia fara sa se modifice DB creste versiunea minora la app. 
	 * 	e.g. 1.2 -> 1.3
	 * Cand se modifica ambele cresc ambele versiuni la versiune majora.
	 * 	e.g. DB  1.0 -> 2.0
	 *       App 1.3 -> 2.0
	 */
	 
	public static String versiune = "v1.0";
	public static IQspaceAdminGUI IQSpaceGUI = new IQspaceAdminGUI();
	
	private static final Logger LOGGER = Logger.getLogger(Constants.LOGGER_NAME);
	

	public static void main(String[] args) {
		Utils.loadProperties();
		
		LOGGER.log(Level.INFO, "Admin app ************************************************  ");
	}

}
