/**
 * Author: Deanna Streffer
 *
 * Description: Multiple Choice question class. Extends the base Question class by adding an ArrayList
 * of all possible choices.
 * 
 */


package hw4;

import java.util.ArrayList;

public class MCQuestion extends Question {
	
	private ArrayList<String> choices;
	
	public MCQuestion() {
		choices = new ArrayList<>();
	}
	
	public MCQuestion(String question) {
		choices = new ArrayList<>();
		super.setQuestion(question);
	}
	
	public void addChoice(String choice, boolean correct) {
		if (correct == true) {
			String finalAnswer = String.valueOf((char) (choices.size() + 65));
			super.setAnswer(finalAnswer);
		}
		
		choices.add(choice);
		
	}
	
	public String toString() {
		String output = super.getQuestion() + "\n";
		
		for (int i = 0; i < choices.size(); i++) {
			char letter = (char) (i + 65);
			String choiceNum = "\t" + letter + ". " + choices.get(i) + "\n";
			output += choiceNum;
		}
		
		return output;
	}
	
}
