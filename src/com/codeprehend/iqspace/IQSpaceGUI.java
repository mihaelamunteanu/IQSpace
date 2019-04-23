package com.codeprehend.iqspace;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.codeprehend.iqspace.dao.QuestionsDAO;
import com.codeprehend.iqspace.dao.TestsDAO;
import com.codeprehend.iqspace.panels.QuestionPanel;
import com.codeprehend.iqspace.panels.ResultPanel;
import com.codeprehend.iqspace.resources.ObtainedAnswer;
import com.codeprehend.iqspace.resources.Question;
import com.codeprehend.iqspace.resources.Test;
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
			"copyright IQSpace -  Test IQSpace " + " " + IQSpaceLauncher.versiune + " @codeprehend.com " + 
					Utils.fromDateToString(LocalDate.now());

	public static String questionString = "Question";
	
//	private JFrame framePrincipal;
	
	private QuestionPanel questionPanel;
	private ResultPanel resultsPanel;
	
	Test testResource = null;
	private List<Question> questionsForTest = null;
	private List<ObtainedAnswer> obtainedAnswers = new ArrayList<>();
	private int numberOfCurrentQuestion = 1;
	private Long usedTest;
	
	public IQSpaceGUI(){
		super();
		//initialize GUI
		
		this.setBounds(100, 100, 1613, 1016);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setSize(dim.getSize().width, dim.getSize().height);
		this.setLocation(dim.width/2-this.getSize().width/2, 0);
		
		
		this.setExitBehaviour();
		this.setResizable(false);
		
		this.setTitle(numeFereastraPrincipala);
		
//        this.addKeyListener(new KeyAdapter()
//        {
//            public void keyPressed(KeyEvent e)
//            {
//            	//verific fie ca acele conbinatii sa fie acceptate. fie cele care nu sunt, vad cum e mai convenabil
//                AWTKeyStroke ak = AWTKeyStroke.getAWTKeyStrokeForEvent(e);
//        		JOptionPane.showMessageDialog(IQSpaceLauncher.IQSpaceGUI,
//        				" Ati apasat: " + ak.toString());
//                if(ak.toString().equals("pressed F2") ||
//                		ak.toString().equals("alt pressed ALT"))
//                {
//            		JOptionPane.showMessageDialog(IQSpaceLauncher.IQSpaceGUI,
//            				" Va rugam folositi aplicatia doar raspunzand la intrebari!");
//                }
//            }
//        });
		
		//Create main panel
		questionPanel = new QuestionPanel(this);
//		resultsPanel = new ResultPanel(this);
		
	    this.setVisible(true);
	}
	
	public void reset() {
		obtainedAnswers = new ArrayList<>();
		numberOfCurrentQuestion = 0;
	}
	
	public void loadTest(Long testId) {
		usedTest = testId;
		testResource = TestsDAO.getTestById(testId);
		questionsForTest = QuestionsDAO.getQuestionsByTestId(testId);
		showQuestionPanel(questionsForTest.get(0));
	}
	
	private void setExitBehaviour() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		    	JOptionPane.showMessageDialog(we.getWindow(), "Aplicatia trebuie sa ramana deschisa. Multumim!", 
						"Neautorizat", JOptionPane.NO_OPTION);
		    }
		});

	}
	
	public void showQuestionPanel(Question question) {
		this.remove(questionPanel);
		questionPanel = new QuestionPanel(this);
		this.add(questionPanel);

		questionPanel.loadQuestionPanel(question, testResource);
		questionPanel.setVisible(true);
	}
	
	public void showResultsPanel(Test test) {
		this.remove(resultsPanel);
		resultsPanel = new ResultPanel(this);
		this.add(resultsPanel);
		
		resultsPanel.setTest(test);
		resultsPanel.setObtainedAnswers(obtainedAnswers);
		resultsPanel.loadResultsPanel(test);
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

	public List<ObtainedAnswer> getObtainedAnswers() {
		return obtainedAnswers;
	}

	public int getNumberOfCurrentQuestion() {
		return numberOfCurrentQuestion;
	}

	public void setNumberOfCurrentQuestion(int numberOfCurrentQuestion) {
		this.numberOfCurrentQuestion = numberOfCurrentQuestion;
	}

	public Test getTestResource() {
		return testResource;
	}

	public List<Question> getQuestionsForTest() {
		return questionsForTest;
	}
	
}