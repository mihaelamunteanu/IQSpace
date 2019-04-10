package com.codeprehend.iqspace;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.codeprehend.iqspace.panels.QuestionPanel;
import com.codeprehend.iqspace.panels.ResultPanel;
import com.codeprehend.iqspace.resources.Antecedent;
import com.codeprehend.iqspace.resources.Patient;
import com.codeprehend.iqspace.util.Utils;


/**
 * Class containing the main window and the process.
 * 
 * @author Gabriel Munteanu
 * @since 13.11.2015
 *
 */

public class IQSpaceGUI extends JFrame {
	
	/**
	 * Default serial Version
	 */
	private static final long serialVersionUID = 1L;
	
	public static String numeFereastraPrincipala = 
			"Test IQSpace " + " " + IQSpaceLauncher.versiune + " @codeprehend.com " + 
					Utils.fromDateToString(LocalDate.now());

	public static String questionString = "Question";
	
//	private JFrame framePrincipal;
	
	private QuestionPanel questionPanel;
	private ResultPanel resultsPanel;
	
	public IQSpaceGUI(){
		super();
		//initialize GUI
		
		this.setBounds(100, 100, 813, 516);
		this.setExitBehaviour();
		this.setTitle(numeFereastraPrincipala);
		
		//Create main panel
		questionPanel = new QuestionPanel(this);
		resultsPanel = new ResultPanel(this);
		
	    this.setVisible(true);
	}
	
	private void setExitBehaviour() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Da","Nu"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Sigur doriti sa parasiti aplicatia?","Confirmare EXIT",
		        		JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ObjButtons,ObjButtons[0]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});

	}
	
	public void showQuestionPanel(int questionNumber) {
		/*Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setSize(1100, dim.getSize().height);
		this.setLocation(dim.width/2-this.getSize().width/2, 0);
		*/
		this.remove(questionPanel);
		questionPanel = new QuestionPanel(this);
		this.add(questionPanel);

		questionPanel.loadQuestion(1);
		
		questionPanel.setVisible(true);
		
		resultsPanel.setVisible(false);
	}
	
	public void showResultsPanel(Patient patient, List<Antecedent> antecedents, String fromPanel) {
		this.remove(resultsPanel);
		resultsPanel = new ResultPanel(this);
		this.add(resultsPanel);
		
		resultsPanel.setPacient(patient);
		resultsPanel.setAntecedents(antecedents);
		resultsPanel.loadModifyGUIPanelForPatient(patient, fromPanel);
		resultsPanel.setVisible(true);
		
		questionPanel.setVisible(false);
	}
	
	//** Getters and setters //

	public QuestionPanel getQuestionPanel() {
		return questionPanel;
	}

	public ResultPanel getModifyPatientPanel() {
		return resultsPanel;
	}
	
}