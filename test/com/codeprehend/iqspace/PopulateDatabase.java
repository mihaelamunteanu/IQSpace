package com.codeprehend.iqspace;

import java.io.IOException;

import com.codeprehend.iqspace.dao.QuestionsDAO;
import com.codeprehend.iqspace.resources.Question;
import com.codeprehend.iqspace.util.Utils;

public class PopulateDatabase {
	
	   public static void main(String[] args) throws Exception {
//		   String imagePath = "C:\\Mihaela\\Other projects\\StartupActivator\\Jocuri\\IQSpaceTest\\huge size.png";
		   
//		   Question question = new Question(1L, "Legislatia din Romania prevede legi de protejare a angajatilor",
//				   "educatie civica", "Da", "Legea curenta aplicabila in Romania ce tine de siguranta si securitatea in munca ce protejeaza angajtul este Legea 319/2006 "
//				   		+ "Hotararea de guvern 1425/2006 si Hotararea de Guvern 767/2016", null, null, 
//				   		"In monitorul Oficial sunt publicate toate legile, ordonantele, hotararile de gurvern care intra in vigoare", 
//				   		5L, null);
//		   
//		   saveQuestionToDB(question);
		   
//		   Question question6 = new Question(1L, "Cate picioare au crustaceele?",
//				   "biologie", "10", "Crustaceele au 5 perechi de membre, "
//				   		+ "iar cele din fata sunt, de obicei, transformate in clesti puternici."
//				   		+ "O pereche de clesti si 4 perechi de picioare subtiri", null, null, null, 6L, null);
//		   
//		   saveQuestionToDB(question6);
		   
//		   Question question7 = new Question(1L, "Ce sunt chinina si chitina?",
//				   "chimie", "Sunt substante chimice ce se gasesc in natura, iar ca si cuvinte sunt paronime", 
//				   "Chinina este o substanta produsa de arborele de chinina, ar chitina se gaseste in crusta animalelor: insecte, paianjeni. ",
//				   		"Doua cuvinte sunt paronime cand suna aprope la fel dar au inteles diferit.", null, null, "Chinina poate fi otravitoare. Mai exista si keratina care se gaseste in corpul mai multor animale", 7L, null);
//		   
//		   saveQuestionToDB(question7);
		   
		   
		   Question question8 = new Question(1L, "Verisoara sotului meu are o sora pe nume Maria. Ce este Maria pentru sora sotului meu?",
				   "logica", "verisoara", 
				   "Fratii/surorile au aceasi grad de rudenie cu toate rudele.", null, null, 
				  null, 8L, null);
		   
		   saveQuestionToDB(question8);
	   }
	   
	   private static void saveQuestionToDB(Question question) throws IOException {
		   Utils.loadProperties();
		   QuestionsDAO.saveQuestion(question);
	   }

}
