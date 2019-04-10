package com.codeprehend.iqspace.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.codeprehend.iqspace.IQSpaceGUI;

public class QuestionPanel extends JPanel {
	/**
	 * Default serial key. 
	 */
	private static final long serialVersionUID = 1L;
	
	private IQSpaceGUI parentPanel;
	
	public QuestionPanel(IQSpaceGUI parent) {
		super();
		this.setLayout(null);

		this.parentPanel = parent;
		this.setVisible(false);
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void  loadQuestionPanel(int questionNumber) {
		//JPanel GridBagLayoutPanel = new JPanel();
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		parentPanel.add(this, BorderLayout.CENTER);
		GridBagLayout gbl_GridBagLayoutPanel = new GridBagLayout();
		gbl_GridBagLayoutPanel.columnWidths = new int[] {0};
		gbl_GridBagLayoutPanel.rowHeights = new int[] {0, 0, 0, 0};
		gbl_GridBagLayoutPanel.columnWeights = new double[]{1.0};
		gbl_GridBagLayoutPanel.rowWeights = new double[]{0.03, 0.5, 0.44, 0.03};
		this.setLayout(gbl_GridBagLayoutPanel);
		
		JPanel questionLabelGridBagLayoutPanel =  new JPanel();
		GridBagConstraints gbc_InformationGridBagLayoutPanel = new GridBagConstraints();
		gbc_InformationGridBagLayoutPanel.anchor = GridBagConstraints.NORTH;
		gbc_InformationGridBagLayoutPanel.insets = new Insets(5, 45, 0, 45);
		gbc_InformationGridBagLayoutPanel.weightx = 1.0;
		gbc_InformationGridBagLayoutPanel.fill = GridBagConstraints.BOTH;
		gbc_InformationGridBagLayoutPanel.gridx = 0;
		gbc_InformationGridBagLayoutPanel.gridy = 0;
		this.add(questionLabelGridBagLayoutPanel, gbc_InformationGridBagLayoutPanel);
		GridBagLayout gbl_InformationGridBagLayoutPanel = new GridBagLayout();
		gbl_InformationGridBagLayoutPanel.columnWidths = new int[]{0, 0};
		gbl_InformationGridBagLayoutPanel.rowHeights = new int[]{0};
		gbl_InformationGridBagLayoutPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_InformationGridBagLayoutPanel.rowWeights = new double[]{0.0};
		questionLabelGridBagLayoutPanel.setLayout(gbl_InformationGridBagLayoutPanel);
		//se asteapta doua randuri si punem doar unul
		
		
		JLabel questionaNoLabel = new JLabel("Intrebarea numarul x din y");
		questionaNoLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_Intrebarea = new GridBagConstraints();
		gbc_Intrebarea.anchor = GridBagConstraints.EAST;
		gbc_Intrebarea.insets = new Insets(0, 0, 5, 5);
		gbc_Intrebarea.gridx = 0;
		gbc_Intrebarea.gridy = 0;
		questionLabelGridBagLayoutPanel.add(questionaNoLabel, gbc_Intrebarea);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 45, 5, 45);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		this.add(scrollPane, gbc_scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setRowHeaderView(panel_1);
		GridBagLayout gbl_scrollPanel = new GridBagLayout();
		gbl_scrollPanel.columnWidths = new int[]{0, 0, 0};
		gbl_scrollPanel.rowHeights = new int[]{0};
		gbl_scrollPanel.columnWeights = new double[]{0.33, 0.33, 0.33};
		gbl_scrollPanel.rowWeights = new double[]{1.0};
		panel_1.setLayout(gbl_scrollPanel);
		
		JPanel image1Panel = new ImagePanel();
		scrollPane.setViewportView(image1Panel);
		GridBagLayout gbl_imagePanel = new GridBagLayout();
		gbl_imagePanel.columnWidths = new int[]{0};
		gbl_imagePanel.rowHeights = new int[]{0};
		gbl_imagePanel.columnWeights = new double[]{1.0};
		gbl_imagePanel.rowWeights = new double[]{1.0};
		image1Panel.setLayout(gbl_imagePanel);

		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_scrollPane2 = new GridBagConstraints();
		gbc_scrollPane2.insets = new Insets(0, 45, 0, 45);
		gbc_scrollPane2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane2.gridx = 0;
		gbc_scrollPane2.gridy = 2;
		this.add(scrollPane2, gbc_scrollPane2);
		
		JPanel panel2 = new JPanel();
		scrollPane2.setColumnHeaderView(panel2);
		
		JPanel panel_12 = new JPanel();
		scrollPane2.setRowHeaderView(panel_12);
		
		JPanel questionSectionPanel = new JPanel();
		scrollPane2.setViewportView(questionSectionPanel);
		GridBagLayout gbl_questionSectionPanel = new GridBagLayout();
		gbl_questionSectionPanel.columnWidths = new int[]{0};
		gbl_questionSectionPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_questionSectionPanel.columnWeights = new double[]{1.0};
		gbl_questionSectionPanel.rowWeights = new double[]{0.25, 0.25, 0.25, 0.25};
		questionSectionPanel.setLayout(gbl_questionSectionPanel);
		
		JLabel questionText = new JLabel("Raspundeti la intrebarea aceasta lunga, trebuie si sectiune de optiuni?");
		GridBagConstraints glb_questionTextLbl = new GridBagConstraints();
		glb_questionTextLbl.anchor = GridBagConstraints.WEST;
		glb_questionTextLbl.insets = new Insets(0, 0, 5, 0);
		glb_questionTextLbl.gridx = 0;
		glb_questionTextLbl.gridy = 0;
		questionSectionPanel.add(questionText, glb_questionTextLbl);
		
		JRadioButton rdbtnC = new JRadioButton("  c)");
		rdbtnC.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_rdbtnC = new GridBagConstraints();
		gbc_rdbtnC.anchor = GridBagConstraints.WEST;
		gbc_rdbtnC.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnC.gridx = 0;
		gbc_rdbtnC.gridy = 1;
		questionSectionPanel.add(rdbtnC, gbc_rdbtnC);
		
		JRadioButton rdbtnB = new JRadioButton("  b)");
		rdbtnB.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_rdbtnB = new GridBagConstraints();
		gbc_rdbtnB.anchor = GridBagConstraints.WEST;
		gbc_rdbtnB.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnB.gridx = 0;
		gbc_rdbtnB.gridy = 2;
		questionSectionPanel.add(rdbtnB, gbc_rdbtnB);
		
		JRadioButton rdbtnA = new JRadioButton("  a)");
		rdbtnA.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_rdbtnA = new GridBagConstraints();
		gbc_rdbtnA.anchor = GridBagConstraints.WEST;
		gbc_rdbtnA.gridx = 0;
		gbc_rdbtnA.gridy = 3;
		questionSectionPanel.add(rdbtnA, gbc_rdbtnA);
		
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
		gbl_buttonPanel.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_buttonPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JButton backBtn = new JButton(" <- Inapoi  ");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.anchor = GridBagConstraints.WEST;
		gbc_btnBack.insets = new Insets(0, 45, 0, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 0;
		buttonPanel.add(backBtn, gbc_btnBack);
		
		JButton nextBtn = new JButton("Urmatoarea ->");
		nextBtn.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 5, 0, 50);
		gbc_btnNext.anchor = GridBagConstraints.EAST;
		gbc_btnNext.gridheight = 2;
		gbc_btnNext.gridx = 1;
		gbc_btnNext.gridy = 0;
		buttonPanel.add(nextBtn, gbc_btnNext);


//		//Action Listeners
//		btnNewButton_7.addActionListener(new BackFromExaminationPatientPanelButtonActionListener(this.parentPanel));
//		btnNewButton_6.addActionListener(new GoHomeFromExaminationPatientButtonListener(this.parentPanel));
//		btnNewButton_5.addActionListener(new ModifyPatientButtonActionListener(this.parentPanel, patient, Constants.FROM_EXAMINATION_PANEL));
//		btnSalveaza.addActionListener(new SaveExaminationButtonActionListener(parentPanel, patient, antecedents, examinations));
//		
//		btnNewButton_4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				AccesFilesExaminationButtonActionListener.actionPerformed(parentPanel, patient);
//			}
//		});
	}
	
}
	

	
	
