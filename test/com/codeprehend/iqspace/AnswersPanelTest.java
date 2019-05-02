package com.codeprehend.iqspace;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Font;

public class AnswersPanelTest extends JFrame {
	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;

	public AnswersPanelTest() {
		setBackground(new Color(240, 240, 240));
		
		JPanel GridBagLayout = new JPanel();
		getContentPane().add(GridBagLayout, BorderLayout.CENTER);
		GridBagLayout gbl_GridBagLayout = new GridBagLayout();
		gbl_GridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_GridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_GridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_GridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		GridBagLayout.setLayout(gbl_GridBagLayout);
		
		JLabel lblAnswers = new JLabel("Raspunsuri");
		lblAnswers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblAnswers = new GridBagConstraints();
		gbc_lblAnswers.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswers.gridx = 2;
		gbc_lblAnswers.gridy = 2;
		GridBagLayout.add(lblAnswers, gbc_lblAnswers);
		
		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 3;
		GridBagLayout.add(label, gbc_label);
		
		JLabel lblNewLabel = new JLabel("answer");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 4;
		GridBagLayout.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("Vezi explicatii");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 4;
		GridBagLayout.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnReincepeTestul = new JButton("Reincepe testul");
		GridBagConstraints gbc_btnReincepeTestul = new GridBagConstraints();
		gbc_btnReincepeTestul.gridx = 4;
		gbc_btnReincepeTestul.gridy = 6;
		GridBagLayout.add(btnReincepeTestul, gbc_btnReincepeTestul);
	}

}
