package com.codeprehend.iqspace.resources;

/**
 * Information to be displayed in the generated PDF about the Cabinet. 
 * It will be taken from DB. 
 * 
 * @author Mihaela Munteanu
 *
 */
public class CabinetData {
	private static String cabinetName = "C.M. Dr. RUGINA";
	private static String cabinetAddress = "Str. Bd. 9Mai, nr. 1, Bl. A13, Ap.2";
	private static String cabinetTelNumber = "0233-237969";
	private static String folderLocation = "C:\\DosareMedicale\\";
	private static String medicAplicatie = "Rugina Cosmin";
	
	public static void loadCabinetData(String cabinetName, String cabinetAddress, 
			String cabinetTelNumber, String medicAplicatie, String folderLocation) {
		CabinetData.cabinetName = cabinetName;
		CabinetData.cabinetAddress = cabinetAddress;
		CabinetData.cabinetTelNumber = cabinetTelNumber;
		CabinetData.medicAplicatie = medicAplicatie;
		CabinetData.folderLocation = folderLocation;
	}
	
	public static String getCabinetName() {
		return cabinetName;
	}
	
	public static String getCabinetAddress() {
		return cabinetAddress;
	}
	
	public static String getCabinetTelNumber() {
		return cabinetTelNumber;
	}

	public static String getFolderLocation() {
		return folderLocation;
	}
	
	public static String getMedicAplicatie() {
		return medicAplicatie;
	}
}
