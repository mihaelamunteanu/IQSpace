package com.codeprehend.iqspace.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.resources.ObtainedAnswer;
import com.codeprehend.iqspace.resources.Test;

public class ResultPanel extends JPanel {

	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	private IQSpaceGUI parentPanel;
	private Test test;

	private JTextField textFieldDate = new JTextField();
	private JTextField textFieldName = new JTextField();
	private JTextField textFieldFirstName = new JTextField();
	private JTextField textFieldRegNumber = new JTextField();
	private JTextField textFieldPhoneNumber = new JTextField();
	private JTextField textFieldNaturalBirthsNumber = new JTextField();
	private JTextField textFieldcSectionBirthNumber = new JTextField();
	private JTextField textFieldRequestedAbortionNumber = new JTextField();
	private JTextField textFieldSpotaneousAbortionNumber = new JTextField();
	private JTextArea  textAreaAntecedents = new JTextArea();
	
	private List<ObtainedAnswer> obtainedAnswers = new ArrayList<ObtainedAnswer>();
	
	public ResultPanel(IQSpaceGUI parent) {
		super();
		this.setLayout(null);

		this.parentPanel = parent;
		this.setVisible(false);
	}
	
	public void loadResultsPanel(Test test) {
		this.test = test;
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		parentPanel.add(this, BorderLayout.CENTER);
		GridBagLayout gbl_GridBagLayoutPanel = new GridBagLayout();
		gbl_GridBagLayoutPanel.columnWidths = new int[] {0};
		gbl_GridBagLayoutPanel.rowHeights = new int[] {0, 0, 0, 0};
		gbl_GridBagLayoutPanel.columnWeights = new double[]{1.0};
		gbl_GridBagLayoutPanel.rowWeights = new double[]{0.03, 0.02, 0.9, 0.05};
		this.setLayout(gbl_GridBagLayoutPanel);
		
		JPanel InformationGridBagLayoutPanel =  new JPanel();
		GridBagConstraints gbc_InformationGridBagLayoutPanel = new GridBagConstraints();
		gbc_InformationGridBagLayoutPanel.anchor = GridBagConstraints.NORTH;
		gbc_InformationGridBagLayoutPanel.insets = new Insets(5, 45, 0, 45);
		gbc_InformationGridBagLayoutPanel.weightx = 1.0;
		gbc_InformationGridBagLayoutPanel.fill = GridBagConstraints.BOTH;
		gbc_InformationGridBagLayoutPanel.gridx = 0;
		gbc_InformationGridBagLayoutPanel.gridy = 0;
		this.add(InformationGridBagLayoutPanel, gbc_InformationGridBagLayoutPanel);
		GridBagLayout gbl_InformationGridBagLayoutPanel = new GridBagLayout();
		gbl_InformationGridBagLayoutPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_InformationGridBagLayoutPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_InformationGridBagLayoutPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1, 0.0, 1, Double.MIN_VALUE};
		gbl_InformationGridBagLayoutPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		InformationGridBagLayoutPanel.setLayout(gbl_InformationGridBagLayoutPanel);
		
		JLabel lblAntet = new JLabel("   ");
		GridBagConstraints gbc_lblAntet = new GridBagConstraints();
		gbc_lblAntet.anchor = GridBagConstraints.WEST;
		gbc_lblAntet.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntet.gridx = 0;
		gbc_lblAntet.gridy = 0;
		InformationGridBagLayoutPanel.add(lblAntet, gbc_lblAntet);
		
		JLabel NameLabel = new JLabel("Nume");
		GridBagConstraints gbc_NameLabel = new GridBagConstraints();
		gbc_NameLabel.anchor = GridBagConstraints.EAST;
		gbc_NameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_NameLabel.gridx = 0;
		gbc_NameLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(NameLabel, gbc_NameLabel);
		
		textFieldName.setText(test.getTestName());
		GridBagConstraints gbc_txtMunteanu = new GridBagConstraints();
		gbc_txtMunteanu.insets = new Insets(0, 0, 5, 5);
		gbc_txtMunteanu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMunteanu.gridx = 1;
		gbc_txtMunteanu.gridy = 1;
		InformationGridBagLayoutPanel.add(textFieldName, gbc_txtMunteanu);
		textFieldName.setColumns(20);
		
		JLabel PrenumeLabel = new JLabel("Prenume");
		GridBagConstraints gbc_PrenumeLabel = new GridBagConstraints();
		gbc_PrenumeLabel.anchor = GridBagConstraints.EAST;
		gbc_PrenumeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PrenumeLabel.gridx = 2;
		gbc_PrenumeLabel.gridy = 1;
		InformationGridBagLayoutPanel.add(PrenumeLabel, gbc_PrenumeLabel);
		
		JLabel lblTelefon = new JLabel("Telefon");
		GridBagConstraints gbc_lblTelefon = new GridBagConstraints();
		gbc_lblTelefon.anchor = GridBagConstraints.EAST;
		gbc_lblTelefon.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefon.gridx = 4;
		gbc_lblTelefon.gridy = 1;
		InformationGridBagLayoutPanel.add(lblTelefon, gbc_lblTelefon);
		
		JLabel DataNastereLabel = new JLabel("Data nasterii");
		GridBagConstraints gbc_DataNastereLabel = new GridBagConstraints();
		gbc_DataNastereLabel.insets = new Insets(0, 0, 5, 5);
		gbc_DataNastereLabel.anchor = GridBagConstraints.EAST;
		gbc_DataNastereLabel.gridx = 0;
		gbc_DataNastereLabel.gridy = 2;
		InformationGridBagLayoutPanel.add(DataNastereLabel, gbc_DataNastereLabel);
		
		JLabel CNPLabel = new JLabel("CNP");
		GridBagConstraints gbc_CNPLabel = new GridBagConstraints();
		gbc_CNPLabel.anchor = GridBagConstraints.EAST;
		gbc_CNPLabel.insets = new Insets(0, 0, 5, 5);
		gbc_CNPLabel.gridx = 2;
		gbc_CNPLabel.gridy = 2;
		InformationGridBagLayoutPanel.add(CNPLabel, gbc_CNPLabel);
		
		JPanel pregnaciesGridBagLayoutPanel =  new JPanel();
		GridBagConstraints gbc_PregnanciesGridBagLayoutPanel = new GridBagConstraints();
		gbc_PregnanciesGridBagLayoutPanel.insets = new Insets(0, 45, 6, 45);
		gbc_PregnanciesGridBagLayoutPanel.weightx = 1.0;
		gbc_PregnanciesGridBagLayoutPanel.fill = GridBagConstraints.BOTH;
		gbc_PregnanciesGridBagLayoutPanel.gridx = 0;
		gbc_PregnanciesGridBagLayoutPanel.gridy = 1;
		this.add(pregnaciesGridBagLayoutPanel, gbc_PregnanciesGridBagLayoutPanel);
		GridBagLayout gbl_PregnanciesGridBagLayoutPanel = new GridBagLayout();
		gbl_PregnanciesGridBagLayoutPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_PregnanciesGridBagLayoutPanel.rowHeights = new int[]{0};
		gbl_PregnanciesGridBagLayoutPanel.columnWeights = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, Double.MIN_VALUE};
		gbl_PregnanciesGridBagLayoutPanel.rowWeights = new double[]{0.0};
		pregnaciesGridBagLayoutPanel.setLayout(gbl_PregnanciesGridBagLayoutPanel);
		
		JLabel lblNasteriNaturale = new JLabel("Nasteri naturale");
		GridBagConstraints gbc_lblNasteriNaturale = new GridBagConstraints();
		gbc_lblNasteriNaturale.anchor = GridBagConstraints.EAST;
		gbc_lblNasteriNaturale.insets = new Insets(0, 0, 0, 5);
		gbc_lblNasteriNaturale.gridx = 0;
		gbc_lblNasteriNaturale.gridy = 0;
		pregnaciesGridBagLayoutPanel.add(lblNasteriNaturale, gbc_lblNasteriNaturale);
		
		JLabel lblCezariene = new JLabel("Cezariene");
		GridBagConstraints gbc_lblCezariene = new GridBagConstraints();
		gbc_lblCezariene.anchor = GridBagConstraints.EAST;
		gbc_lblCezariene.insets = new Insets(0, 0, 0, 5);
		gbc_lblCezariene.gridx = 2;
		gbc_lblCezariene.gridy = 0;
		pregnaciesGridBagLayoutPanel.add(lblCezariene, gbc_lblCezariene);
		
		
		JLabel lblAvorturiLaCerere = new JLabel("Avorturi la cerere");
		GridBagConstraints gbc_lblAvorturiLaCerere = new GridBagConstraints();
		gbc_lblAvorturiLaCerere.anchor = GridBagConstraints.EAST;
		gbc_lblAvorturiLaCerere.insets = new Insets(0, 0, 0, 5);
		gbc_lblAvorturiLaCerere.gridx = 4;
		gbc_lblAvorturiLaCerere.gridy = 0;
		pregnaciesGridBagLayoutPanel.add(lblAvorturiLaCerere, gbc_lblAvorturiLaCerere);
		
		JLabel lblAvorturiSpontane = new JLabel("Avorturi spontane");
		GridBagConstraints gbc_lblAvorturiSpontane = new GridBagConstraints();
		gbc_lblAvorturiSpontane.anchor = GridBagConstraints.EAST;
		gbc_lblAvorturiSpontane.insets = new Insets(0, 0, 0, 5);
		gbc_lblAvorturiSpontane.gridx = 6;
		gbc_lblAvorturiSpontane.gridy = 0;
		pregnaciesGridBagLayoutPanel.add(lblAvorturiSpontane, gbc_lblAvorturiSpontane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 45, 5, 45);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		this.add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setRowHeaderView(panel_1);
		
		JPanel medicalInfoPanel = new JPanel();
		scrollPane.setViewportView(medicalInfoPanel);
		GridBagLayout gbl_medicalInfoPanel = new GridBagLayout();
		gbl_medicalInfoPanel.columnWidths = new int[]{0};
		gbl_medicalInfoPanel.rowHeights = new int[]{0, 0, 0, 0, 0,0};
		gbl_medicalInfoPanel.columnWeights = new double[]{1.0};
		gbl_medicalInfoPanel.rowWeights = new double[]{1.0, 100.0, 1.0, 1.0, 1.0, 1.0};
		medicalInfoPanel.setLayout(gbl_medicalInfoPanel);
		
		JLabel lblAntecedente_1 = new JLabel("Antecedente");
		GridBagConstraints gbc_lblAntecedente_1 = new GridBagConstraints();
		gbc_lblAntecedente_1.anchor = GridBagConstraints.WEST;
		gbc_lblAntecedente_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblAntecedente_1.gridx = 0;
		gbc_lblAntecedente_1.gridy = 0;
		medicalInfoPanel.add(lblAntecedente_1, gbc_lblAntecedente_1);
		
		textAreaAntecedents.setFont(new Font("Monospaced", Font.ITALIC, 13));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 1;
		gbc_textArea.gridheight = 6;
		gbc_textArea.insets = new Insets(3, 0, 10, 10);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		medicalInfoPanel.add(textAreaAntecedents, gbc_textArea);
		textAreaAntecedents.setRows(6);
		
//		JLabel label = new JLabel("     ");
//		GridBagConstraints gbc_label = new GridBagConstraints();
//		gbc_label.insets = new Insets(0, 0, 5, 0);
//		gbc_label.gridx = 0;
//		gbc_label.gridy = 7;
//		medicalInfoPanel.add(label, gbc_label);
		
		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(8, 25, 35, 15);
		gbc_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 3;
		this.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[]{0};
		gbl_buttonPanel.rowHeights = new int[]{0, 0};
		gbl_buttonPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_buttonPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JButton btnNewButton_7 = new JButton("Inapoi");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_7.gridx = 1;
		gbc_btnNewButton_7.gridy = 0;
		buttonPanel.add(btnNewButton_7, gbc_btnNewButton_7);
		
//		btnNewButton_7.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				if (Constants.FROM_EXAMINATION_PANEL.equals(fromPanel)) {
//					BackFromModifyPatientPanelButtonActionListener.backButtonPressed(
//							parentPanel, pacient, antecedents);
//				} else {
//					AccesFilesExaminationButtonActionListener.actionPerformed(parentPanel, pacient);
//				}
//			}
//		});
		
		
		JButton btnSalveaza = new JButton("SALVEAZA MODIFICARI");
		btnSalveaza.setVerticalAlignment(SwingConstants.TOP);
		btnSalveaza.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnSalveaza = new GridBagConstraints();
		gbc_btnSalveaza.anchor = GridBagConstraints.NORTH;
		gbc_btnSalveaza.gridheight = 2;
		gbc_btnSalveaza.gridx = 5;
		gbc_btnSalveaza.gridy = 0;
		buttonPanel.add(btnSalveaza, gbc_btnSalveaza);
//		btnSalveaza.addActionListener(new SaveModificationsForPatientButtonActionListener(parentPanel, pacient));
	}
	
	/**
	 * Loads the patient into JPanel
	 * 
	 * @param patients
	 */
	public void seTestInfo(Test test){
		this.test = test;
	}
	

		
	public void setObtainedAnswers(List<ObtainedAnswer> obtainedAnswers) {
		this.obtainedAnswers = obtainedAnswers;
	}

	public IQSpaceGUI getParentPanel() {
		return parentPanel;
	}

	public void setParentPanel(IQSpaceGUI parentPanel) {
		this.parentPanel = parentPanel;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public JTextField getTextFieldDate() {
		return textFieldDate;
	}

	public void setTextFieldDate(JTextField textFieldDate) {
		this.textFieldDate = textFieldDate;
	}

	public JTextField getTextFieldName() {
		return textFieldName;
	}

	public void setTextFieldName(JTextField textFieldName) {
		this.textFieldName = textFieldName;
	}

	public JTextField getTextFieldFirstName() {
		return textFieldFirstName;
	}

	public void setTextFieldFirstName(JTextField textFieldFirstName) {
		this.textFieldFirstName = textFieldFirstName;
	}

	public JTextField getTextFieldRegNumber() {
		return textFieldRegNumber;
	}

	public void setTextFieldRegNumber(JTextField textFieldRegNumber) {
		this.textFieldRegNumber = textFieldRegNumber;
	}

	public JTextField getTextFieldPhoneNumber() {
		return textFieldPhoneNumber;
	}

	public void setTextFieldPhoneNumber(JTextField textFieldPhoneNumber) {
		this.textFieldPhoneNumber = textFieldPhoneNumber;
	}

	public JTextField getTextFieldNaturalBirthsNumber() {
		return textFieldNaturalBirthsNumber;
	}

	public void setTextFieldNaturalBirthsNumber(JTextField textFieldNaturalBirthsNumber) {
		this.textFieldNaturalBirthsNumber = textFieldNaturalBirthsNumber;
	}

	public JTextField getTextFieldcSectionBirthNumber() {
		return textFieldcSectionBirthNumber;
	}

	public void setTextFieldcSectionBirthNumber(JTextField textFieldcSectionBirthNumber) {
		this.textFieldcSectionBirthNumber = textFieldcSectionBirthNumber;
	}

	public JTextField getTextFieldRequestedAbortionNumber() {
		return textFieldRequestedAbortionNumber;
	}

	public void setTextFieldRequestedAbortionNumber(JTextField textFieldRequestedAbortionNumber) {
		this.textFieldRequestedAbortionNumber = textFieldRequestedAbortionNumber;
	}

	public JTextField getTextFieldSpotaneousAbortionNumber() {
		return textFieldSpotaneousAbortionNumber;
	}

	public void setTextFieldSpotaneousAbortionNumber(JTextField textFieldSpotaneousAbortionNumber) {
		this.textFieldSpotaneousAbortionNumber = textFieldSpotaneousAbortionNumber;
	}

	public JTextArea getTextAreaAntecedents() {
		return textAreaAntecedents;
	}



}
