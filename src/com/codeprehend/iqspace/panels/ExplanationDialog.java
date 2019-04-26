package com.codeprehend.iqspace.panels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExplanationDialog {
	private static JDialog explanationDialog;
	
	public static void showExplanationDialog(String explnation, String questionNo) {  
		
		JFrame f= new JFrame();  
		explanationDialog = new JDialog(f , "Explicatie intrebarea " + questionNo, true);  
		explanationDialog.setLayout( new FlowLayout() );  
		JButton b = new JButton ("OK");  
		b.addActionListener ( new ActionListener()  
		{  
			public void actionPerformed( ActionEvent e )  
			{  
				ExplanationDialog.explanationDialog.setVisible(false);  
			}  
		});  
		explanationDialog.add( new JLabel(explnation));
		explanationDialog.add( new JLabel(" \n \n"));
		explanationDialog.add(b);   
		explanationDialog.setSize(300,300);    
		explanationDialog.setVisible(true);  
	}  
}
