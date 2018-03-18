/**
 * Author: Deanna Streffer
 *
 * Description: A class which is used to create and manage an NPC. Includes methods for accessing and setting name, 
 * race, position, dialogue, 
 * 
 */


package hw1_and_hw2;

import java.util.Arrays;
import java.util.ArrayList;

public class NPC {
	private String name;
	private String race;
	private double xPos;
	private double yPos;
	private String[] dialogue;
	private boolean hasSequentialDialogue;
	private int nextDialogue;
	private static int numberOfNPCs = 0;

	public NPC() {		
		//default no arg values
		this.name = "NO NAME";
		this.race = "NO RACE";
		this.xPos = -999.0;
		this.yPos = -999.0;
		this.dialogue = new String[]{"PLACEHOLDER TEXT"};
		this.hasSequentialDialogue = false;
		this.nextDialogue = 0;
		numberOfNPCs++;
		
	}


	public NPC(String name, String race, double xPos, double yPos, String[] dialogue, boolean hasSequentialDialogue) {
		this.name = name;
		this.race = race;
		this.xPos = xPos;
		this.yPos = yPos;
		this.dialogue = dialogue;
		this.hasSequentialDialogue = hasSequentialDialogue;
		this.nextDialogue = 0;
		numberOfNPCs++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getRace() {
		return this.race;
	}
	
	public double getXPos() {
		return this.xPos;
	}
	
	public double getYPos() {
		return this.yPos;
	}
	
	public String[] getDialogue() {
		int size = this.dialogue.length; 
		String[] dialogueCopy = new String[size];
		
		//arraycopy function
		
		for ( int i = 0 ; i < size ; i++ ) {
			dialogueCopy[i] = this.dialogue[i];
		}
		
		return dialogueCopy;
	}
	
	public boolean getSequential() {
		return this.hasSequentialDialogue;
	}
	
	public int getNumberOfNPCs() {
		return this.numberOfNPCs;
	}
	
	public void setName(String name) {
		if (name.length() > 0) {
			this.name = name;
		} 
	}
	
	public void setRace(String race) {
		this.race = race;
	}
	
	public void setXPos(double xPos) {
		if (xPos == -1.0) {
			xPos = 0.0;
			System.out.println("Can't walk that way!");
		} else if (xPos < -1) {
			xPos = 0.0;
			System.out.println("X Position Initialized at 5.0.");
		}
		this.xPos = xPos;
	}
	
	public void setYPos (double yPos) {
		if (yPos == -1.0) {
			yPos = 0.0;
			System.out.println("Can't walk that way!");
		} else if (yPos < -1) {
			yPos = 5.0;
			System.out.println("Y Position Initialized at 5.0.");
		}
		this.yPos = yPos;
	}
	
	public void setDialogue(String[] dialogue) {
		this.dialogue = dialogue;
		this.nextDialogue = 0;
	}
	
	public void setSequential(boolean hasSequentialDialogue) {
		this.hasSequentialDialogue = hasSequentialDialogue;
	}
	
	public void talk() {
		if (this.hasSequentialDialogue == true) {		
			String currentLine = dialogue[this.nextDialogue];
			System.out.println(currentLine + "\n");
			
			if (this.nextDialogue < (this.dialogue.length-1)) {
				this.nextDialogue++;
			} else {
				this.nextDialogue = 0;
			}
		} else {
			//Random class
			//Random r = new Random();
			//return this.dialogue[r.nextInt(this.dialogue.length)];
			
			this.nextDialogue = (int)(Math.random() * (this.dialogue.length)); //user Random object
			String currentLine = dialogue[this.nextDialogue];
			System.out.println(currentLine + "\n");
		}
	}
	
	public void talk(int numOfLines) {
		for(int i=1;i<=numOfLines;i++) {
			this.talk(); //	is this possible? it works, but seems like a bad idea
		}
	}
	
	public void walk(String direction) {
		switch (direction) {
			case "up": 	
				setYPos(this.yPos+1);
				break;
			case "down": 
				setYPos(this.yPos-1);
				break;
			case "left": 
				setXPos(this.xPos-1);
				break;
			case "right": 
				setXPos(this.xPos+1);
				break;
			default: 
				System.out.println("Please enter a valid direction.\n");
		}
		
	}
	
	@Override //don't forget these!! turns runtime errors into logic errors EZ
	public String toString() {
		String npcInfo = "Name: " + name + "\n" + 
				         "Race: " + race +  "\n" + 
				         "Location: (" + xPos + "," + yPos + ")\n" +
				         "Total Number of NPCs: " + numberOfNPCs + "\n" + 
				         "Dialogue: " + Arrays.toString(dialogue) + "\n" +
				         "Sequential?: " + hasSequentialDialogue + "\n";
		return npcInfo;
	}
	
}
