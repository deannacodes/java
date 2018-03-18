/**
 * Author: Deanna Streffer
 *
 * Description: Quiz object which consists of an arraylist of questions and the submitted answers. 
 * Displays the quiz itself and collects the answers, then grades the quiz by comparing the submitted 
 * answers to the correct ones.
 * 
 */



package hw4;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {

	ArrayList<Question> questions = new ArrayList<>();
	ArrayList<String> answers = new ArrayList<>();
	
	
	
	
	
	public ArrayList<Question> getQuestions() {
		return new ArrayList<Question>(questions);
	}
	
	
	
	
	
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
		
	}
	
	
	
	
	
	public ArrayList<String> getAnswers() {
		return new ArrayList<String>(answers);
	}
	
	
	
	
	
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	
	
	
	
	
	public ArrayList<String> takeQuiz() {
		Scanner scan = new Scanner(System.in);
		
		for ( int i = 0 ; i < questions.size() ; i++) {
			System.out.println((i+1) + ". " + questions.get(i));
			String answer = scan.nextLine();
			this.answers.add(answer);
		}
		
		return answers;
	}
	
	
	
	
	
	public void gradeQuiz() {
		int score = 0;
		for ( int i = 0 ; i < questions.size() ; i++) {
			String correct = questions.get(i).getAnswer();
			String submitted = answers.get(i);
			
			if (submitted.equalsIgnoreCase(correct)) {
				score++;
			}			
			
		}
		
		score *= 10;
		
		String message;
		if ( score >=90 ) {
			message = "Excellect!";
		} else if ( score >= 80 ) {
			message = "Pretty good.";
		} else if ( score >= 70 ) {
			message = "Uhh, not bad.";
		} else {
			message = "You fail.";
		}
		
		System.out.println("\n******The Office Trivia Quiz******\n" +
						   "  You scored " + score + "%! " + message + "\n" + 
						   "**********************************\n");
	}
	
}
