/**
 * Author: Deanna Streffer
 *
 * Description: Main quiz class which provides an interface for taking the quiz and initializes 
 * questions for the quiz object.
 * 
 */


package hw4;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizMain {

	public static void main(String[] args) {
		Quiz quiz = initializeQuiz();
		boolean takeQuiz = true;
				
		while (takeQuiz == true)
			mainMenu(quiz);
}
	
	
	
	
	
	public static void mainMenu(Quiz quiz) {
		Scanner scan = new Scanner(System.in);
		System.out.print("******The Office Trivia Quiz******\n" +
						   "1. Take Quiz \n" +
						   "2. View Last Score \n" +
						   "3. Exit Program\n" + 
						   "Your choice: ");
		int choice = scan.nextInt();
		scan.nextLine();
		
		switch (choice) {
			case 1: 
				quiz.takeQuiz();
				quiz.gradeQuiz();
				break;
			case 2:
				try {
					quiz.gradeQuiz();
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No score found. Try taking the quiz first.\n");
				}
				break;
			case 3:
				System.exit(0);
		}
	}
	
	
	
	
	
	public static Quiz initializeQuiz() {
		Quiz quiz = new Quiz();
		ArrayList<Question> questions = initializeQuestions();
		
		quiz.setQuestions(questions);
		
		return quiz;
	}
	
	
	
	
	
	public static ArrayList<Question> initializeQuestions() {
		ArrayList<Question> questions = new ArrayList<>();
		
		MCQuestion q1 = new MCQuestion("Who does Michael impersonate that leads to the branch having a Diversity Day?");
		q1.addChoice("Chris Rock", true);
		q1.addChoice("Adolf Hitler", false);
		q1.addChoice("Michelle Obama", false);
		q1.addChoice("Lewis Black", false);
		
		FiBQuestion q2 = new FiBQuestion("Andy Bernard attended _Cornell_ University.");
		
		MCQuestion q3 = new MCQuestion("What is the national sport of Icelandic paper companies?");
		q3.addChoice("Floggington", false);
		q3.addChoice("Farhampton", false);
		q3.addChoice("Flonkerton", true);
		q3.addChoice("Frogger", false);
		
		FiBQuestion q4 = new FiBQuestion("During Movie Mondays, they watched _Varsity Blues_");
		
		MCQuestion q5 = new MCQuestion("What is the security guard's name?");
		q5.addChoice("Eddy", false);
		q5.addChoice("Hank", true);
		q5.addChoice("Evan", false);
		q5.addChoice("Elliot", false);
		
		FiBQuestion q6 = new FiBQuestion("What is Todd Packer's Liscence Plate? _WLHUNG_");
		
		MCQuestion q7 = new MCQuestion("What did Pam win a Dundie for at Chilie's?");
		q7.addChoice("Whitest Sneakers", true);
		q7.addChoice("Tidiest Desk", false);
		q7.addChoice("Busiest Beaver Award", false);
		q7.addChoice("Longest Engagement", false);
		
		FiBQuestion q8 = new FiBQuestion("Jim says, \"Michael is preparing for the birth of a _watermelon_ with Dwight.\"");
		
		MCQuestion q9 = new MCQuestion("What is Erin's real first name?");
		q9.addChoice("Pamela", false);
		q9.addChoice("Angela", false);
		q9.addChoice("Phyllis", false);
		q9.addChoice("Kelly", true);
		
		FiBQuestion q10 = new FiBQuestion("The worst thing about prison was... the _dementors_!");
				
		questions.add(q1);
		questions.add(q2);
		questions.add(q3);
		questions.add(q4);
		questions.add(q5);
		questions.add(q6);
		questions.add(q7);
		questions.add(q8);
		questions.add(q9);
		questions.add(q10);
		
		return questions;
	}
}

