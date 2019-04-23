package com.codeprehend.iqspace.admin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.codeprehend.iqspace.resources.Question;
import com.codeprehend.iqspace.resources.Test;

public class IQspaceAdminGUI extends JFrame {
	
	/**
	 * Default serial Version.
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField searchTestTitle;
	private JTextField searchTestNumber;
	private JTextField testTitle;
	private JTextField testNumber;
	private JTextField testCreationDate;
	private JTextField testModificationDate;
	private JTextField testObservations;
	private JTextField testType;
	private JTextField testNumberOfQuestions;
	
	private JTextField searchQuestionContent;
	private JTextField searchQuestionTest;
	private JTextField searchQuestionNumber;
	private JTextField txtQuestionTestId;
	private JTextField txtQuestionNumber;
	private JTextArea questionText;
	private JTextArea answer;
	private JTextArea wrongAnswer1;
	private JTextArea wrongAnswer2;
	private JTextArea hint1;
	private JTextArea explanations;
	private JTextArea otherObservations;
	private JTextArea questionType;
	
	private Test test;
	private Question question; 
	
	public static String numeFereastraPrincipala = "copyright IQSpace - IQSpace Admin";
	
	public IQspaceAdminGUI() {
		this.setTitle(numeFereastraPrincipala);
		
		JPanel MainPanel = new JPanel();
		getContentPane().add(MainPanel, BorderLayout.NORTH);
		GridBagLayout gbl_MainPanel = new GridBagLayout();
		gbl_MainPanel.columnWidths = new int[] {5, 5, 0, 0, 0, 0, 5, 0};
		gbl_MainPanel.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15};
		gbl_MainPanel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0};
		gbl_MainPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		MainPanel.setLayout(gbl_MainPanel);
		
		this.setVisible(true);
		
		int gridy = 0;

		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = gridy++;
		MainPanel.add(label, gbc_label);
		
		JLabel lblCautaIntrebare = new JLabel("Cauta intrebare:");
		lblCautaIntrebare.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCautaIntrebare.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCautaIntrebare = new GridBagConstraints();
		gbc_lblCautaIntrebare.insets = new Insets(10, 10, 5, 5);
		gbc_lblCautaIntrebare.gridx = 0;
		gbc_lblCautaIntrebare.gridy = gridy;
		MainPanel.add(lblCautaIntrebare, gbc_lblCautaIntrebare);
		
		searchQuestionContent = new JTextField();
		searchQuestionContent.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.weightx = 1.0;
		gbc_textField.insets = new Insets(10, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = gridy;
		MainPanel.add(searchQuestionContent, gbc_textField);
		searchQuestionContent.setColumns(10);
		
		JLabel lblTest = new JLabel("Test");
		GridBagConstraints gbc_lblTest = new GridBagConstraints();
		gbc_lblTest.anchor = GridBagConstraints.EAST;
		gbc_lblTest.insets = new Insets(10, 0, 5, 5);
		gbc_lblTest.gridx = 2;
		gbc_lblTest.gridy = gridy;
		MainPanel.add(lblTest, gbc_lblTest);
		
		searchQuestionTest = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(10, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = gridy;
		MainPanel.add(searchQuestionTest, gbc_textField_1);
		searchQuestionTest.setColumns(10);
		
		JLabel lblNumar = new JLabel("Numar");
		GridBagConstraints gbc_lblNumar = new GridBagConstraints();
		gbc_lblNumar.anchor = GridBagConstraints.EAST;
		gbc_lblNumar.insets = new Insets(10, 0, 5, 5);
		gbc_lblNumar.gridx = 4;
		gbc_lblNumar.gridy = gridy;
		MainPanel.add(lblNumar, gbc_lblNumar);
		
		searchQuestionNumber = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(10, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = gridy++;
		MainPanel.add(searchQuestionNumber, gbc_textField_2);
		searchQuestionNumber.setColumns(10);
		
		JButton buttonSearch = new JButton("Cauta");
		GridBagConstraints gbc_buttonSearch= new GridBagConstraints();
		gbc_buttonSearch.insets = new Insets(0, 0, 0, 5);
		gbc_buttonSearch.fill = GridBagConstraints.BOTH;
		gbc_buttonSearch.gridx = 5;
		gbc_buttonSearch.gridy = gridy++;
		MainPanel.add(buttonSearch, gbc_buttonSearch);
		buttonSearch.addActionListener(new SearchButtonListener(this));
		
		JLabel label4 = new JLabel(" ");
		GridBagConstraints gbc_label4 = new GridBagConstraints();
		gbc_label4.insets = new Insets(0, 0, 5, 5);
		gbc_label4.gridx = 0;
		gbc_label4.gridy = gridy++;
		MainPanel.add(label4, gbc_label4);
		
		JLabel lblIntrebare = new JLabel("Intrebare");
		GridBagConstraints gbc_lblIntrebare = new GridBagConstraints();
		gbc_lblIntrebare.anchor = GridBagConstraints.EAST;
		gbc_lblIntrebare.insets = new Insets(0, 0, 5, 5);
		
		gbc_lblIntrebare.gridx = 0;
		gbc_lblIntrebare.gridy = gridy;
		MainPanel.add(lblIntrebare, gbc_lblIntrebare);
		
		txtQuestionNumber = new JTextField();
		txtQuestionNumber.setText("x");
		GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.insets = new Insets(0, 0, 5, 5);
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.gridx = 1;
		gbc_txtX.gridy = gridy;
		MainPanel.add(txtQuestionNumber, gbc_txtX);
		txtQuestionNumber.setColumns(10);
		
		JLabel lblTestY = new JLabel("Test");
		GridBagConstraints gbc_lblTestY = new GridBagConstraints();
		gbc_lblTestY.anchor = GridBagConstraints.EAST;
		gbc_lblTestY.insets = new Insets(0, 0, 5, 5);
		gbc_lblTestY.gridx = 2;
		gbc_lblTestY.gridy = gridy;
		MainPanel.add(lblTestY, gbc_lblTestY);
		
		txtQuestionTestId = new JTextField();
		txtQuestionTestId.setText("y");
		GridBagConstraints gbc_txtY = new GridBagConstraints();
		gbc_txtY.insets = new Insets(0, 0, 5, 5);
		gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY.gridx = 3;
		gbc_txtY.gridy = gridy++;
		MainPanel.add(txtQuestionTestId, gbc_txtY);
		txtQuestionTestId.setColumns(10);

		JLabel label5 = new JLabel(" ");
		GridBagConstraints gbc_label5 = new GridBagConstraints();
		gbc_label5.insets = new Insets(0, 0, 5, 5);
		gbc_label5.gridx = 0;
		gbc_label5.gridy = gridy++;
		MainPanel.add(label5, gbc_label5);
		
		
		JLabel lblQuestionType = new JLabel("Tip intrebare:");
		GridBagConstraints gbc_lblQuestionType = new GridBagConstraints();
		gbc_lblQuestionType.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuestionType.gridx = 0;
		gbc_lblQuestionType.gridy = gridy;
		MainPanel.add(lblQuestionType, gbc_lblQuestionType);
		
		questionType = new JTextArea();
		GridBagConstraints gbc_questionType = new GridBagConstraints();
		gbc_questionType.gridwidth = 5;
		gbc_questionType.gridheight = 2;
		gbc_questionType.insets = new Insets(0, 0, 5, 5);
		gbc_questionType.fill = GridBagConstraints.BOTH;
		gbc_questionType.gridx = 1;
		gbc_questionType.gridy = gridy++; 
		MainPanel.add(questionType, gbc_questionType);
		
		JLabel label12 = new JLabel(" ");
		GridBagConstraints gbc_label12 = new GridBagConstraints();
		gbc_label12.insets = new Insets(0, 0, 5, 5);
		gbc_label12.gridx = 0;
		gbc_label12.gridy = gridy++;
		MainPanel.add(label12, gbc_label12);
		
		
		JLabel lblText = new JLabel("Text:");
		GridBagConstraints gbc_lblText = new GridBagConstraints();
		gbc_lblText.insets = new Insets(0, 0, 5, 5);
		gbc_lblText.gridx = 0;
		gbc_lblText.gridy = gridy;
		MainPanel.add(lblText, gbc_lblText);
		
		questionText = new JTextArea();
		GridBagConstraints gbc_textArea_7 = new GridBagConstraints();
		gbc_textArea_7.gridwidth = 5;
		gbc_textArea_7.gridheight = 2;
		gbc_textArea_7.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_7.fill = GridBagConstraints.BOTH;
		gbc_textArea_7.gridx = 1;
		gbc_textArea_7.gridy = gridy++; 
		MainPanel.add(questionText, gbc_textArea_7);
		
		JLabel label6 = new JLabel(" ");
		GridBagConstraints gbc_label6 = new GridBagConstraints();
		gbc_label6.insets = new Insets(0, 0, 5, 5);
		gbc_label6.gridx = 0;
		gbc_label6.gridy = gridy++;
		MainPanel.add(label6, gbc_label6);
		
		JLabel lblRaspuns = new JLabel("Raspuns:");
		GridBagConstraints gbc_lblRaspuns = new GridBagConstraints();
		gbc_lblRaspuns.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaspuns.gridx = 0;
		gbc_lblRaspuns.gridy = gridy;
		MainPanel.add(lblRaspuns, gbc_lblRaspuns);
		
		answer = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 5;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = gridy++;
		gbc_textArea.gridheight = 2;
		MainPanel.add(answer, gbc_textArea);
		
		JLabel label7 = new JLabel(" ");
		GridBagConstraints gbc_label7 = new GridBagConstraints();
		gbc_label7.insets = new Insets(0, 0, 5, 5);
		gbc_label7.gridx = 0;
		gbc_label7.gridy = gridy++;
		MainPanel.add(label7, gbc_label7);
		
		JLabel lblHint = new JLabel("Hint:");
		GridBagConstraints gbc_lblHint = new GridBagConstraints();
		gbc_lblHint.insets = new Insets(0, 0, 5, 5);
		gbc_lblHint.gridx = 0;
		gbc_lblHint.gridy = gridy;
		MainPanel.add(lblHint, gbc_lblHint);
		
		hint1 = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.gridwidth = 5;
		gbc_textArea_1.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 1;
		gbc_textArea_1.gridy = gridy++;
		gbc_textArea_1.gridheight = 2;
		MainPanel.add(hint1, gbc_textArea_1);
		
		JLabel label8 = new JLabel(" ");
		GridBagConstraints gbc_label8 = new GridBagConstraints();
		gbc_label8.insets = new Insets(0, 0, 5, 5);
		gbc_label8.gridx = 0;
		gbc_label8.gridy = gridy++;
		MainPanel.add(label8, gbc_label8);
		
		JLabel lblExplicatii = new JLabel("Explicatii");
		GridBagConstraints gbc_lblExplicatii = new GridBagConstraints();
		gbc_lblExplicatii.insets = new Insets(0, 0, 5, 5);
		gbc_lblExplicatii.gridx = 0;
		gbc_lblExplicatii.gridy = gridy;
		MainPanel.add(lblExplicatii, gbc_lblExplicatii);
		
		explanations = new JTextArea();
		GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
		gbc_textArea_2.gridwidth = 5;
		gbc_textArea_2.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_2.fill = GridBagConstraints.BOTH;
		gbc_textArea_2.gridx = 1;
		gbc_textArea_2.gridy = gridy++;
		gbc_textArea_2.gridheight = 2;
		MainPanel.add(explanations, gbc_textArea_2);
		
		JLabel label9 = new JLabel(" ");
		GridBagConstraints gbc_label9 = new GridBagConstraints();
		gbc_label9.insets = new Insets(0, 0, 5, 5);
		gbc_label9.gridx = 0;
		gbc_label9.gridy = gridy++;
		MainPanel.add(label9, gbc_label9);
		
		JLabel lblImagine = new JLabel("Imagine");
		GridBagConstraints gbc_lblImagine = new GridBagConstraints();
		gbc_lblImagine.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagine.gridx = 0;
		gbc_lblImagine.gridy = gridy;
		MainPanel.add(lblImagine, gbc_lblImagine);
		
		JTextArea textArea_3 = new JTextArea();
		GridBagConstraints gbc_textArea_3 = new GridBagConstraints();
		gbc_textArea_3.gridwidth = 5;
		gbc_textArea_3.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_3.fill = GridBagConstraints.BOTH;
		gbc_textArea_3.gridx = 1;
		gbc_textArea_3.gridy = gridy++;
		gbc_textArea_3.gridheight = 2;
		MainPanel.add(textArea_3, gbc_textArea_3);
		
		JLabel label10 = new JLabel(" ");
		GridBagConstraints gbc_label10 = new GridBagConstraints();
		gbc_label10.insets = new Insets(0, 0, 5, 5);
		gbc_label10.gridx = 0;
		gbc_label10.gridy = gridy++;
		MainPanel.add(label10, gbc_label10);
		
		JLabel lblRaspunsGresit = new JLabel("Raspuns gresit 1:");
		GridBagConstraints gbc_lblRaspunsGresit = new GridBagConstraints();
		gbc_lblRaspunsGresit.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaspunsGresit.gridx = 0;
		gbc_lblRaspunsGresit.gridy = gridy;
		MainPanel.add(lblRaspunsGresit, gbc_lblRaspunsGresit);
		
		wrongAnswer1 = new JTextArea();
		GridBagConstraints gbc_textArea_4 = new GridBagConstraints();
		gbc_textArea_4.gridwidth = 5;
		gbc_textArea_4.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_4.fill = GridBagConstraints.BOTH;
		gbc_textArea_4.gridx = 1;
		gbc_textArea_4.gridy = gridy++;
		gbc_textArea_4.gridheight = 2;
		MainPanel.add(wrongAnswer1, gbc_textArea_4);
		
		JLabel label11 = new JLabel(" ");
		GridBagConstraints gbc_label11 = new GridBagConstraints();
		gbc_label11.insets = new Insets(0, 0, 5, 5);
		gbc_label11.gridx = 0;
		gbc_label11.gridy = gridy++;
		MainPanel.add(label11, gbc_label11);
		
		JLabel lblRaspunsGresit_1 = new JLabel("Raspuns gresit 2:");
		GridBagConstraints gbc_lblRaspunsGresit_1 = new GridBagConstraints();
		gbc_lblRaspunsGresit_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaspunsGresit_1.gridx = 0;
		gbc_lblRaspunsGresit_1.gridy = gridy;
		MainPanel.add(lblRaspunsGresit_1, gbc_lblRaspunsGresit_1);
		
		wrongAnswer2 = new JTextArea();
		GridBagConstraints gbc_textArea_5 = new GridBagConstraints();
		gbc_textArea_5.gridwidth = 5;
		gbc_textArea_5.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_5.fill = GridBagConstraints.BOTH;
		gbc_textArea_5.gridx = 1;
		gbc_textArea_5.gridy = gridy++;
		gbc_textArea_5.gridheight = 2;
		MainPanel.add(wrongAnswer2, gbc_textArea_5);
		
		JLabel label3 = new JLabel(" ");
		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.insets = new Insets(0, 0, 5, 5);
		gbc_label3.gridx = 0;
		gbc_label3.gridy = gridy++;
		MainPanel.add(label3, gbc_label3);
		
		JLabel lblAlteObservatii = new JLabel("Alte observatii:");
		GridBagConstraints gbc_lblAlteObservatii = new GridBagConstraints();
		gbc_lblAlteObservatii.insets = new Insets(0, 0, 5, 5);
		gbc_lblAlteObservatii.gridx = 0;
		gbc_lblAlteObservatii.gridy = gridy;
		MainPanel.add(lblAlteObservatii, gbc_lblAlteObservatii);
		
		otherObservations = new JTextArea();
		GridBagConstraints gbc_textArea_6 = new GridBagConstraints();
		gbc_textArea_6.gridwidth = 5;
		gbc_textArea_6.insets = new Insets(0, 0, 5, 5);
		gbc_textArea_6.fill = GridBagConstraints.BOTH;
		gbc_textArea_6.gridx = 1;
		gbc_textArea_6.gridy = gridy++;
		gbc_textArea_6.gridheight = 2;
		MainPanel.add(otherObservations, gbc_textArea_6);
		
		JLabel label1 = new JLabel(" ");
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 0;
		gbc_label1.gridy = gridy++;
		MainPanel.add(label1, gbc_label1);
		
		JLabel label2 = new JLabel(" ");
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.insets = new Insets(0, 0, 5, 5);
		gbc_label2.gridx = 0;
		gbc_label2.gridy = gridy++;
		MainPanel.add(label2, gbc_label2);
		
		JButton buttonUpdate = new JButton("Insert/Update");
		GridBagConstraints gbc_buttonUpdate= new GridBagConstraints();
		gbc_buttonUpdate.insets = new Insets(0, 0, 0, 5);
		gbc_buttonUpdate.fill = GridBagConstraints.BOTH;
		gbc_buttonUpdate.gridx = 5;
		gbc_buttonUpdate.gridy = gridy++;
		MainPanel.add(buttonUpdate, gbc_buttonUpdate);
		
		buttonUpdate.addActionListener(new UpdateButtonListener(this));
		
		
		/*                ---------------------------   */
		
		JLabel label13 = new JLabel(" -------------------------------------------------------"
				+ "----------------------------------------------------------------------------"
				+ "---------------------------------------------------------------------------"
				+ "---------------------------------------------------------------------------"
				+ "-------------------------------------------------------------------------- ");
		GridBagConstraints gbc_label13 = new GridBagConstraints();
		gbc_label13.insets = new Insets(0, 0, 5, 5);
		gbc_label13.gridx = 0;
		gbc_label13.gridy = gridy++;
		gbc_label13.gridwidth = 6;
		MainPanel.add(label13, gbc_label13);
		
		
		JLabel lblCautaTest = new JLabel("Cauta Test:");
		lblCautaTest.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCautaTest.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCautaTest = new GridBagConstraints();
		gbc_lblCautaTest.insets = new Insets(10, 10, 5, 5);
		gbc_lblCautaTest.gridx = 0;
		gbc_lblCautaTest.gridy = gridy;
		MainPanel.add(lblCautaTest, gbc_lblCautaTest);
		
		JLabel lblEmpty = new JLabel(" ");
		GridBagConstraints gbc_lblEmpty = new GridBagConstraints();
		gbc_lblEmpty.insets = new Insets(10, 10, 5, 5);
		gbc_lblEmpty.gridx = 1;
		gbc_lblEmpty.gridy = gridy;
		MainPanel.add(lblEmpty, gbc_lblEmpty);
		
		
		JLabel lblTestTitle = new JLabel("Nume");
		GridBagConstraints gbc_lblTestTitle = new GridBagConstraints();
		gbc_lblTestTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTestTitle.insets = new Insets(10, 0, 5, 5);
		gbc_lblTestTitle.gridx = 2;
		gbc_lblTestTitle.gridy = gridy;
		MainPanel.add(lblTestTitle, gbc_lblTestTitle);
		
		searchTestTitle = new JTextField();
		GridBagConstraints gbc_searchTestTitle = new GridBagConstraints();
		gbc_searchTestTitle.insets = new Insets(10, 0, 5, 5);
		gbc_searchTestTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchTestTitle.gridx = 3;
		gbc_searchTestTitle.gridy = gridy;
		MainPanel.add(searchTestTitle, gbc_searchTestTitle);
		searchTestTitle.setColumns(10);
		
		JLabel lblSearchTestNumber = new JLabel("Numar");
		GridBagConstraints gbc_lblSearchTestNumber = new GridBagConstraints();
		gbc_lblSearchTestNumber.anchor = GridBagConstraints.EAST;
		gbc_lblSearchTestNumber.insets = new Insets(10, 0, 5, 5);
		gbc_lblSearchTestNumber.gridx = 4;
		gbc_lblSearchTestNumber.gridy = gridy;
		MainPanel.add(lblSearchTestNumber, gbc_lblSearchTestNumber);
		
		searchTestNumber = new JTextField();
		GridBagConstraints gbc_searchTestNumber = new GridBagConstraints();
		gbc_searchTestNumber.insets = new Insets(10, 0, 5, 5);
		gbc_searchTestNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchTestNumber.gridx = 5;
		gbc_searchTestNumber.gridy = gridy++;
		MainPanel.add(searchTestNumber, gbc_searchTestNumber);
		searchTestNumber.setColumns(10);
		
		JButton buttonSearchTest = new JButton("Cauta Test");
		GridBagConstraints gbc_buttonSearchTest= new GridBagConstraints();
		gbc_buttonSearchTest.insets = new Insets(0, 0, 0, 5);
		gbc_buttonSearchTest.fill = GridBagConstraints.BOTH;
		gbc_buttonSearchTest.gridx = 5;
		gbc_buttonSearchTest.gridy = gridy++;
		MainPanel.add(buttonSearchTest, gbc_buttonSearchTest);
		buttonSearchTest.addActionListener(new SearchTestButtonListener(this));
		
		JLabel labelEmpty2 = new JLabel(" ");
		GridBagConstraints gbc_labelEmpty2 = new GridBagConstraints();
		gbc_labelEmpty2.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmpty2.gridx = 0;
		gbc_labelEmpty2.gridy = gridy++;
		MainPanel.add(labelEmpty2, gbc_labelEmpty2);
		
		JLabel lblTest2 = new JLabel("Id test");
		GridBagConstraints gbc_lblTest2 = new GridBagConstraints();
		gbc_lblTest2.anchor = GridBagConstraints.EAST;
		gbc_lblTest2.insets = new Insets(0, 0, 5, 5);
		gbc_lblTest2.gridx = 0;
		gbc_lblTest2.gridy = gridy;
		MainPanel.add(lblTest2, gbc_lblTest2);
		
		testNumber = new JTextField();
		GridBagConstraints gbc_testNumber = new GridBagConstraints();
		gbc_testNumber.insets = new Insets(0, 0, 5, 5);
		gbc_testNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_testNumber.gridx = 1;
		gbc_testNumber.gridy = gridy;
		MainPanel.add(testNumber, gbc_testNumber);
		txtQuestionNumber.setColumns(10);
		
		JLabel lblTestName = new JLabel("Nume");
		GridBagConstraints gbc_lblTestName = new GridBagConstraints();
//		gbc_lblTestName.anchor = GridBagConstraints.EAST;
		gbc_lblTestName.insets = new Insets(0, 0, 5, 5);
		gbc_lblTestName.gridx = 2;
		gbc_lblTestName.gridy = gridy;
		MainPanel.add(lblTestName, gbc_lblTestName);
		
		testTitle = new JTextField();
		GridBagConstraints gbc_testTitle = new GridBagConstraints();
		gbc_testTitle.insets = new Insets(0, 0, 5, 5);
		gbc_testTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_testTitle.gridx = 3;
		gbc_testTitle.gridy = gridy++;
		MainPanel.add(testTitle, gbc_testTitle);
		testTitle.setColumns(10);

		JLabel labelEmpty3 = new JLabel(" ");
		GridBagConstraints gbc_labelEmpty3 = new GridBagConstraints();
		gbc_labelEmpty3.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmpty3.gridx = 0;
		gbc_labelEmpty3.gridy = gridy++;
		MainPanel.add(labelEmpty3, gbc_labelEmpty3);
		
		
		JLabel lblTestType = new JLabel("Tip test:");
		GridBagConstraints gbc_lblTestType = new GridBagConstraints();
		gbc_lblTestType.insets = new Insets(0, 0, 5, 5);
		gbc_lblTestType.gridx = 0;
		gbc_lblTestType.gridy = gridy;
		MainPanel.add(lblTestType, gbc_lblTestType);
		
		testType = new JTextField();
		GridBagConstraints gbc_testType = new GridBagConstraints();
		gbc_testType.gridwidth = 5;
		gbc_testType.insets = new Insets(0, 0, 5, 5);
		gbc_testType.fill = GridBagConstraints.BOTH;
		gbc_testType.gridx = 1;
		gbc_testType.gridy = gridy++; 
		MainPanel.add(testType, gbc_testType);
		
		
		
		JLabel lblTestNumberOfQuestions = new JLabel("Numar de intrebari:");
		GridBagConstraints gbc_lblTestNumberOfQuestions = new GridBagConstraints();
		gbc_lblTestNumberOfQuestions.insets = new Insets(0, 0, 5, 5);
		gbc_lblTestNumberOfQuestions.gridx = 0;
		gbc_lblTestNumberOfQuestions.gridy = gridy;
		MainPanel.add(lblTestNumberOfQuestions, gbc_lblTestNumberOfQuestions);
		
		testNumberOfQuestions = new JTextField();
		GridBagConstraints gbc_testNumberOfQuestions = new GridBagConstraints();
		gbc_testNumberOfQuestions.gridwidth = 5;
		gbc_testNumberOfQuestions.insets = new Insets(0, 0, 5, 5);
		gbc_testNumberOfQuestions.fill = GridBagConstraints.BOTH;
		gbc_testNumberOfQuestions.gridx = 1;
		gbc_testNumberOfQuestions.gridy = gridy++; 
		MainPanel.add(testNumberOfQuestions, gbc_testNumberOfQuestions);
		
		
		JLabel lblTestObservations = new JLabel("Observatii test:");
		GridBagConstraints gbc_lblTestObservations = new GridBagConstraints();
		gbc_lblTestObservations.insets = new Insets(0, 0, 5, 5);
		gbc_lblTestObservations.gridx = 0;
		gbc_lblTestObservations.gridy = gridy;
		MainPanel.add(lblTestObservations, gbc_lblTestObservations);
		
		testObservations = new JTextField();
		GridBagConstraints gbc_testObservations = new GridBagConstraints();
		gbc_testObservations.gridwidth = 5;
		gbc_testObservations.insets = new Insets(0, 0, 5, 5);
		gbc_testObservations.fill = GridBagConstraints.BOTH;
		gbc_testObservations.gridx = 1;
		gbc_testObservations.gridy = gridy++; 
		MainPanel.add(testObservations, gbc_testObservations);
		
		
		JLabel lblTestCreationDate = new JLabel("Data creare test:");
		GridBagConstraints gbc_lblTestCreationDate = new GridBagConstraints();
		gbc_lblTestCreationDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblTestCreationDate.gridx = 0;
		gbc_lblTestCreationDate.gridy = gridy;
		MainPanel.add(lblTestCreationDate, gbc_lblTestCreationDate);
		
		testCreationDate = new JTextField();
		GridBagConstraints gbc_testCreationDate = new GridBagConstraints();
		gbc_testCreationDate.gridwidth = 5;
		gbc_testCreationDate.insets = new Insets(0, 0, 5, 5);
		gbc_testCreationDate.fill = GridBagConstraints.BOTH;
		gbc_testCreationDate.gridx = 1;
		gbc_testCreationDate.gridy = gridy++; 
		MainPanel.add(testCreationDate, gbc_testCreationDate);
		
		JLabel lblModificationDate= new JLabel("Ultima modificare:");
		GridBagConstraints gbc_lblModificationDate = new GridBagConstraints();
		gbc_lblModificationDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblModificationDate.gridx = 0;
		gbc_lblModificationDate.gridy = gridy;
		MainPanel.add(lblModificationDate, gbc_lblModificationDate);
		
		testModificationDate = new JTextField();
		GridBagConstraints gbc_testModificationDate = new GridBagConstraints();
		gbc_testModificationDate.gridwidth = 5;
		gbc_testModificationDate.insets = new Insets(0, 0, 5, 5);
		gbc_testModificationDate.fill = GridBagConstraints.BOTH;
		gbc_testModificationDate.gridx = 1;
		gbc_testModificationDate.gridy = gridy++; 
		MainPanel.add(testModificationDate, gbc_testModificationDate);
		
		JLabel labelEmpty4 = new JLabel(" ");
		GridBagConstraints gbc_labelEmpty4 = new GridBagConstraints();
		gbc_labelEmpty4.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmpty4.gridx = 0;
		gbc_labelEmpty4.gridy = gridy++;
		MainPanel.add(labelEmpty4, gbc_labelEmpty4);
		
		JButton buttonUpdateTest = new JButton("Insert/Update Test");
		GridBagConstraints gbc_buttonUpdateTest= new GridBagConstraints();
		gbc_buttonUpdateTest.insets = new Insets(0, 0, 0, 5);
		gbc_buttonUpdateTest.fill = GridBagConstraints.BOTH;
		gbc_buttonUpdateTest.gridx = 5;
		gbc_buttonUpdateTest.gridy = gridy++;
		MainPanel.add(buttonUpdateTest, gbc_buttonUpdateTest);
		
		buttonUpdateTest.addActionListener(new UpdateTestButtonListener(this));
		
		/*        ------------------------------------------ */
		this.setBounds(5, 5, 1600, 1050);
		
		this.doLayout();
	}

	public JTextField getSearchQuestionContent() {
		return searchQuestionContent;
	}

	public void setSearchQuestionContent(JTextField searchQuestionContent) {
		this.searchQuestionContent = searchQuestionContent;
	}

	public JTextField getSearchQuestionTest() {
		return searchQuestionTest;
	}

	public void setSearchQuestionTest(JTextField searchQuestionTest) {
		this.searchQuestionTest = searchQuestionTest;
	}

	public JTextField getSearchQuestionNumber() {
		return searchQuestionNumber;
	}

	public void setSearchQuestionNumber(JTextField searchQuestionNumber) {
		this.searchQuestionNumber = searchQuestionNumber;
	}

	public JTextField getTxtQuestionTestId() {
		return txtQuestionTestId;
	}

	public void setTxtQuestionTestId(JTextField txtQuestionTestId) {
		this.txtQuestionTestId = txtQuestionTestId;
	}

	public JTextField getTxtQuestionNumber() {
		return txtQuestionNumber;
	}

	public void setTxtQuestionNumber(JTextField txtQuestionNumber) {
		this.txtQuestionNumber = txtQuestionNumber;
	}

	public JTextArea getQuestionText() {
		return questionText;
	}

	public void setQuestionText(JTextArea questionText) {
		this.questionText = questionText;
	}

	public JTextArea getAnswer() {
		return answer;
	}

	public void setAnswer(JTextArea answer) {
		this.answer = answer;
	}

	public JTextArea getWrongAnswer1() {
		return wrongAnswer1;
	}

	public void setWrongAnswer1(JTextArea wrongAnswer1) {
		this.wrongAnswer1 = wrongAnswer1;
	}

	public JTextArea getWrongAnswer2() {
		return wrongAnswer2;
	}

	public void setWrongAnswer2(JTextArea wrongAnswer2) {
		this.wrongAnswer2 = wrongAnswer2;
	}

	public JTextArea getHint1() {
		return hint1;
	}

	public void setHint1(JTextArea hint1) {
		this.hint1 = hint1;
	}

	public JTextArea getExplanations() {
		return explanations;
	}

	public void setExplanations(JTextArea explanations) {
		this.explanations = explanations;
	}

	public JTextArea getOtherObservations() {
		return otherObservations;
	}

	public void setOtherObservations(JTextArea otherObservations) {
		this.otherObservations = otherObservations;
	}

	public JTextArea getQuestionType() {
		return questionType;
	}

	public void setQuestionType(JTextArea questionType) {
		this.questionType = questionType;
	}

	public JTextField getSearchTestTitle() {
		return searchTestTitle;
	}

	public void setSearchTestTitle(JTextField searchTestTitle) {
		this.searchTestTitle = searchTestTitle;
	}

	public JTextField getSearchTestNumber() {
		return searchTestNumber;
	}

	public void setSearchTestNumber(JTextField searchTestNumber) {
		this.searchTestNumber = searchTestNumber;
	}

	public JTextField getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(JTextField testTitle) {
		this.testTitle = testTitle;
	}

	public JTextField getTestNumber() {
		return testNumber;
	}

	public void setTestNumber(JTextField testNumber) {
		this.testNumber = testNumber;
	}

	public JTextField getTestCreationDate() {
		return testCreationDate;
	}

	public void setTestCreationDate(JTextField testCreationDate) {
		this.testCreationDate = testCreationDate;
	}

	public JTextField getTestModificationDate() {
		return testModificationDate;
	}

	public void setTestModificationDate(JTextField testModificationDate) {
		this.testModificationDate = testModificationDate;
	}

	public JTextField getTestObservations() {
		return testObservations;
	}

	public void setTestObservations(JTextField testObservations) {
		this.testObservations = testObservations;
	}

	public JTextField getTestType() {
		return testType;
	}

	public void setTestType(JTextField testType) {
		this.testType = testType;
	}

	public JTextField getTestNumberOfQuestions() {
		return testNumberOfQuestions;
	}

	public void setTestNumberOfQuestions(JTextField testNumberOfQuestions) {
		this.testNumberOfQuestions = testNumberOfQuestions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Test getTest() {
		return test;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
		this.questionText.setText(question.getQuestion());
		this.answer.setText(question.getAnswer());
		this.hint1.setText(question.getHint1());
		this.explanations.setText(question.getExplanations());
		this.otherObservations.setText(question.getOtherObservations());
		this.wrongAnswer1.setText(question.getWrongAnswer1());
		this.wrongAnswer2.setText(question.getWrongAnswer2());
		this.questionType.setText(question.getQuestionType());
		this.txtQuestionNumber.setText(String.valueOf(question.getQuestionNumber()));
		this.txtQuestionTestId.setText(String.valueOf(question.getTestId()));
	}
	
	public void setTest(Test test) {
		this.test = test;
		this.testCreationDate.setText(test.getCreationDate().format( DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		this.testModificationDate.setText(test.getLastModification().format( DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		this.testNumber.setText(String.valueOf(test.getId()));
		this.testNumberOfQuestions.setText(String.valueOf(test.getNumberOfQuestions()));
		this.testObservations.setText(test.getObservations());
		this.testTitle.setText(test.getTestName());
		this.testType.setText(test.getTestType());
	}
	
	public void reset() {
		this.questionText.setText("");
		this.answer.setText("");
		this.hint1.setText("");
		this.explanations.setText("");
		this.otherObservations.setText("");
		this.wrongAnswer1.setText("");
		this.wrongAnswer2.setText("");
		this.questionType.setText("");
		this.txtQuestionNumber.setText("");
		this.txtQuestionTestId.setText("");
		
		this.testCreationDate.setText("");
		this.testModificationDate.setText("");
		this.testNumber.setText("");
		this.testNumberOfQuestions.setText("");
		this.testObservations.setText("");
		this.testTitle.setText("");
		this.testType.setText("");
	}
}
