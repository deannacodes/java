/**
 * Author: Deanna Streffer
 *
 * Description: Fill-in-the-Blank question class extends the base Question class. Looks for the 
 * correct answer which is marked with surrounding underscores, and saves it as the correct answer.
 * 
 */

package hw4;

public class FiBQuestion extends Question {

	public FiBQuestion(String question) {		
		
		String answer = parseAnswer(question);
		
		question = question.replace(answer, "______________");
		
		super.setQuestion(question);
		
	}
	
	private String parseAnswer(String question) {
		int firstUnderscore = question.indexOf("_");
		int lastUnderscore = question.indexOf("_", (firstUnderscore + 1));
		
		String answer = question.substring((firstUnderscore+1),lastUnderscore);
		super.setAnswer(answer);
		
		return answer;
	}
	
	public String toString() {
		String output = this.getQuestion();
		
		return output;
	}
}
