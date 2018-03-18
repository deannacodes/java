/**
 * Author: Deanna Streffer
 *
 * Description: Base question class. Creates a question object with a data fields for the 
 * question itself and the correct answer.
 * 
 */

package hw4;

public class Question {
	
	private String question;
	private String answer;
	
	
	
	public Question() {
		question = "Default question";
		answer = "Default answer";
	}
	
	
	
	
	public Question(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}

	
	
	
	public String getQuestion() {
		return question;
	}

	
	
	
	
	public void setQuestion(String question) {
		this.question = question;
	}

	
	
	
	
	public String getAnswer() {
		return answer;
	}

	
	
	
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
	
	public boolean gradeQuestion(String input) {
		return this.answer.equalsIgnoreCase(input);
	}
	
	
	
	
	public String toString() {
		
		return this.question;
		
	}
}
