package com.codeprehend.iqspace.listeners;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.resources.Question;
import com.codeprehend.iqspace.util.Utils;

public class ExplanationActionListener implements ActionListener {
	private IQSpaceGUI mainWindow;
	
	public ExplanationActionListener(IQSpaceGUI mainWindow){
		this.mainWindow = mainWindow;
	}
	
	public void actionPerformed(ActionEvent e){
		JButton btn = (JButton) e.getSource();
		
		Question questionToExplain = mainWindow.getQuestionsForTest().get(Integer.parseInt(btn.getName()) - 1);

		String explanation = questionToExplain.getQuestion() + "\n" +
				questionToExplain.getExplanations();
		
		JLabel expLabel = new JLabel(Utils.addHtml(explanation));
		expLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JOptionPane.showMessageDialog(mainWindow, expLabel, "Explicatie intrebarea " + btn.getName(), JOptionPane.INFORMATION_MESSAGE);
		
	}
}

