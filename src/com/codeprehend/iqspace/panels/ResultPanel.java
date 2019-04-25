package com.codeprehend.iqspace.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.resources.AnswersPosition;
import com.codeprehend.iqspace.resources.Question;
import com.codeprehend.iqspace.resources.Test;
import com.codeprehend.iqspace.util.Constants;

public class ResultPanel extends JPanel {
	/**
	 * Default serial key. 
	 */
	private static final long serialVersionUID = 1L;
	
	private IQSpaceGUI parentPanel;
	
	public ResultPanel(IQSpaceGUI parent) {
		super();
		this.setLayout(null);

		this.parentPanel = parent;
		this.setVisible(false);
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void  loadResultPanel(List<Question> questions, Test test, 
			List<String> obtainedAnswers, List<AnswersPosition> answersPositions) {
		//JPanel GridBagLayoutPanel = new JPanel();
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		parentPanel.add(this, BorderLayout.CENTER);
		GridBagLayout gbl_GridBagLayout = new GridBagLayout();
		gbl_GridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_GridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_GridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_GridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		this.setLayout(gbl_GridBagLayout);
		
		JLabel lblAnswers = new JLabel("Raspunsuri");
		GridBagConstraints gbc_lblAnswers = new GridBagConstraints();
		gbc_lblAnswers.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswers.gridx = 2;
		gbc_lblAnswers.gridy = 2;
		this.add(lblAnswers, gbc_lblAnswers);
		
		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 3;
		this.add(label, gbc_label);
		
		int gridy = 4;
		
		for (int i=0; i<test.getNumberOfQuestions(); i++) {
			JLabel labela = new JLabel(" ");
			GridBagConstraints gbc_labela = new GridBagConstraints();
			gbc_labela.insets = new Insets(0, 0, 5, 5);
			gbc_labela.gridx = 1;
			gbc_labela.gridy = gridy;
			this.add(labela, gbc_labela);
			
			String choseOption = "";
			String correctOption = AnswersPosition.getLetterForPosition(
					answersPositions.get(i).getPositionOfCorrectAnswer());
			if (obtainedAnswers.get(i) == null) {
				choseOption = "Raspuns Neselectat";
			} else
				switch (obtainedAnswers.get(i)) {
				case Constants.CORRECT_ANSWER:
					choseOption = AnswersPosition.getLetterForPosition(
							answersPositions.get(i).getPositionOfCorrectAnswer());
					break;
				case Constants.WRONG_ANSWER1:
					choseOption = AnswersPosition.getLetterForPosition(
							answersPositions.get(i).getPositionOfWrongAnswer1());
					break;
				case Constants.WRONG_ANSWER2:
					choseOption = AnswersPosition.getLetterForPosition(
							answersPositions.get(i).getPositionOfWrongAnswer2());
					break;
				default:
					break;
				}
			
			JLabel lblNewLabel = new JLabel(" ");
			if (choseOption.equals(correctOption)) {
				lblNewLabel = new JLabel(" Ati ales " + choseOption + " - OK");
			} else {
				lblNewLabel = new JLabel(" " + choseOption + " - incorect. Raspunsul corect " + correctOption);
			}
				
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 2;
			gbc_lblNewLabel.gridy = gridy;
			gbc_lblNewLabel.gridwidth = 3;
			this.add(lblNewLabel, gbc_lblNewLabel);
			
			JButton btnNewButton = new JButton("Vezi explicatii");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
			gbc_btnNewButton.gridx = 5;
			gbc_btnNewButton.gridy = gridy;
			this.add(btnNewButton, gbc_btnNewButton);
			
			gridy = gridy + 1;
		}
		
		JButton btnReincepeTestul = new JButton("Reincepe testul");
		GridBagConstraints gbc_btnReincepeTestul = new GridBagConstraints();
		gbc_btnReincepeTestul.gridx = 5;
		gbc_btnReincepeTestul.gridy = gridy++;
		this.add(btnReincepeTestul, gbc_btnReincepeTestul);
		this.doLayout();
		
		JLabel labelx = new JLabel(" ");
		GridBagConstraints gbc_labelx = new GridBagConstraints();
		gbc_labelx.insets = new Insets(0, 0, 5, 5);
		gbc_labelx.gridx = 1;
		gbc_labelx.gridy = gridy;
		this.add(labelx, gbc_labelx);
	}
	
}
	

	
	
