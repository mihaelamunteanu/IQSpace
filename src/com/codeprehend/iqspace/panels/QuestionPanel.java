package com.codeprehend.iqspace.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.listeners.BackButtonActionListener;
import com.codeprehend.iqspace.listeners.NextQuestionButtonActionListener;
import com.codeprehend.iqspace.listeners.RadioButtonListner;
import com.codeprehend.iqspace.resources.AnswersPosition;
import com.codeprehend.iqspace.resources.Question;
import com.codeprehend.iqspace.resources.Test;
import com.codeprehend.iqspace.util.Constants;
import com.codeprehend.iqspace.util.ImageSettings;
import com.codeprehend.iqspace.util.Utils;

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
	public void  loadQuestionPanel(Question question, Test test, List<AnswersPosition> answersPosition) {
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
		
		
		JLabel questionaNoLabel = new JLabel("Intrebarea numarul " 
					+ question.getQuestionNumber() + " din " + test.getNumberOfQuestions());
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
		
		JPanel image1Panel = new JPanel(); //new ImagePanel(test.getTestName(), question.getQuestionNumber());
		scrollPane.setViewportView(image1Panel);
		GridBagLayout gbl_imagePanel = new GridBagLayout();
		gbl_imagePanel.columnWidths = new int[]{0};
		gbl_imagePanel.rowHeights = new int[]{0};
		gbl_imagePanel.columnWeights = new double[]{1.0};
		gbl_imagePanel.rowWeights = new double[]{1.0};
		image1Panel.setLayout(gbl_imagePanel);
		
		JLabel contentPane = new JLabel();
		String path1 = ImageSettings.IMAGES_LOCATION + "\\" + test.getTestName() + "Q" + question.getQuestionNumber() + ".png";
		String path2 = ImageSettings.IMAGES_LOCATION + "\\" + question.getImage(); 
		String defaultPath = ImageSettings.IMAGES_LOCATION + "\\Default.png";
		File tempFile = new File(path1);
		if (tempFile.exists()) {
			contentPane.setIcon(new ImageIcon(path1)); 
		} else {
			File tempFile2 = new File(path2);
			if (question.getImage() != null && !question.getImage().isEmpty() 
					&& !"null".equalsIgnoreCase(question.getImage()) && tempFile2.exists()) 
				contentPane.setIcon(new ImageIcon(path2)); 
			else contentPane.setIcon(new ImageIcon(defaultPath));
		}
		contentPane.setLayout( new BorderLayout() );
		image1Panel.add(contentPane);


		
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
		gbl_questionSectionPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_questionSectionPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_questionSectionPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		gbl_questionSectionPanel.rowWeights = new double[]{0.25, 0.25, 0.25, 0.25};
		questionSectionPanel.setLayout(gbl_questionSectionPanel);
		
		JLabel questionText = new JLabel(Utils.addHtml(question.getQuestion()));
		questionText.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints glb_questionTextLbl = new GridBagConstraints();
		glb_questionTextLbl.anchor = GridBagConstraints.WEST;
		glb_questionTextLbl.insets = new Insets(0, 0, 5, 0);
		glb_questionTextLbl.gridx = 1;
		glb_questionTextLbl.gridy = 0;
		questionSectionPanel.add(questionText, glb_questionTextLbl);
		
		AnswersPosition positonsForAnswers = answersPosition.get(question.getQuestionNumber().intValue()-1);
		
		JRadioButton rdbtnA = new JRadioButton(Utils.addHtml("   " + AnswersPosition.getLetterForPosition(positonsForAnswers.getPositionOfCorrectAnswer()) 
								+  " "  + question.getAnswer() ));
//		rdbtnA.setText("<html>"+ AnswersPosition.getLetterForPosition(positonsForAnswers.getPositionOfCorrectAnswer()) 
//								+  " "  + question.getAnswer() + " </html>" );
		rdbtnA.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnA.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnA.setName(Constants.CORRECT_ANSWER);
		rdbtnA.addActionListener(new RadioButtonListner(parentPanel));
		GridBagConstraints gbc_rdbtnA = new GridBagConstraints();
		gbc_rdbtnA.anchor = GridBagConstraints.WEST;
		gbc_rdbtnA.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnA.gridx = 1;
		gbc_rdbtnA.gridy = positonsForAnswers.getPositionOfCorrectAnswer();
		questionSectionPanel.add(rdbtnA, gbc_rdbtnA); 
		
		JRadioButton rdbtnB = new JRadioButton(Utils.addHtml("   " + AnswersPosition.getLetterForPosition(positonsForAnswers.getPositionOfWrongAnswer1()) 
								+  " "  + question.getWrongAnswer1()));
//		rdbtnB.setText("<html> "+ AnswersPosition.getLetterForPosition(positonsForAnswers.getPositionOfWrongAnswer1()) 
//		+  " "  + question.getWrongAnswer1() + " </html>" );
		rdbtnB.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnB.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnB.setName(Constants.WRONG_ANSWER1);
		rdbtnB.addActionListener(new RadioButtonListner(parentPanel));
		GridBagConstraints gbc_rdbtnB = new GridBagConstraints();
		gbc_rdbtnB.anchor = GridBagConstraints.WEST;
		gbc_rdbtnB.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnB.gridx = 1;
		gbc_rdbtnB.gridy = positonsForAnswers.getPositionOfWrongAnswer1();
		questionSectionPanel.add(rdbtnB, gbc_rdbtnB);
		
		JRadioButton rdbtnC = new JRadioButton(Utils.addHtml("   " + AnswersPosition.getLetterForPosition(positonsForAnswers.getPositionOfWrongAnswer2()) 
								+  " "  + question.getWrongAnswer2()));
//		rdbtnC.setText("<html> "+ AnswersPosition.getLetterForPosition(positonsForAnswers.getPositionOfWrongAnswer2()) 
//		+  "</html> "  + question.getWrongAnswer2() + " " );
		rdbtnC.setFont(new Font("Tahoma", Font.BOLD, 16));
		rdbtnC.setName(Constants.WRONG_ANSWER2);
		rdbtnC.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnC.addActionListener(new RadioButtonListner(parentPanel));
		GridBagConstraints gbc_rdbtnC = new GridBagConstraints();
		gbc_rdbtnC.anchor = GridBagConstraints.WEST;
		gbc_rdbtnC.gridx = 1;
		gbc_rdbtnC.gridy = positonsForAnswers.getPositionOfWrongAnswer2();
		questionSectionPanel.add(rdbtnC, gbc_rdbtnC);
		
	    //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnA);
	    group.add(rdbtnB);
	    group.add(rdbtnC);
		
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
		
		if (question.getQuestionNumber() > 1) { 
			JButton backBtn = new JButton(" <- Inapoi  ");
			backBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
			GridBagConstraints gbc_btnBack = new GridBagConstraints();
			gbc_btnBack.anchor = GridBagConstraints.WEST;
			gbc_btnBack.insets = new Insets(0, 45, 0, 5);
			gbc_btnBack.gridx = 0;
			gbc_btnBack.gridy = 0;
			buttonPanel.add(backBtn, gbc_btnBack);
			
			backBtn.addActionListener(new BackButtonActionListener(this.parentPanel));
		} else {
			JLabel noLabel = new JLabel(" ");
		questionaNoLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_noLabel = new GridBagConstraints();
		gbc_noLabel.anchor = GridBagConstraints.EAST;
		gbc_noLabel.insets = new Insets(0, 0, 5, 5);
		gbc_noLabel.gridx = 0;
		gbc_noLabel.gridy = 0;
		questionLabelGridBagLayoutPanel.add(noLabel, gbc_noLabel);
		}
		
		JButton nextBtn = new JButton("Urmatoarea ->");
		nextBtn.setVerticalAlignment(SwingConstants.TOP);
		nextBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 5, 0, 50);
		gbc_btnNext.anchor = GridBagConstraints.EAST;
		gbc_btnNext.gridheight = 2;
		gbc_btnNext.gridx = 1;
		gbc_btnNext.gridy = 0;
		buttonPanel.add(nextBtn, gbc_btnNext);


		//Action Listeners
		
		nextBtn.addActionListener(new NextQuestionButtonActionListener(this.parentPanel));
		
		this.doLayout();
	}
	
}
	

	
	
