/**
 * Author: Deanna Streffer
 *
 * Description: Main class which is used to test NPC class. Allows the user to view information, talk to the NPCs, 
 * make them walk in one of 4 directions, or create a new NPC. 
 * 
 */

package hw1_and_hw2;
import java.util.Scanner;
import java.util.ArrayList;

public class NPCMain {
	
	public static void main(String[] args) {
		
		ArrayList<NPC> npcs = initializeNPCs();
		
		boolean repeatMenu = false;
		while (repeatMenu == false) {
			NPC level1 = mainMenu(npcs);
			repeatMenu = secondaryMenu(level1, repeatMenu);
		}
		
		
	}
	
	public static ArrayList<NPC> initializeNPCs() {
		String[] npc2Dialogue = new String[] {"The Khajiit hail from a distant land called Elsweyr, \nbordered on the north by Cyrodiil and the south by the glistening blue waters of the sea.",
				  "Elsweyr is an arid land of deserts and rocky canyons, \nwhere the sun shines warmly, always.",
				  "There are cities so ancient, the sands have swallowed them whole.",
				  "But now I will say no more, for I miss my home greatly.",
				  "May your road lead you to warm sands."};
		String[] npc3Dialogue = new String[] {"Citizen", 
				  "Disrespect the law and you disrespect me.", 
				  "What do you need?", 
				  "Let me guess... someone stole your sweetroll.",
				  "What is it?", 
				  "I'd be a lot warmer and a lot happier with a bellyful of mead...",
				  "Watch the skies, traveller.",
				  "I used to be an adventurer like you. Then I took an arrow in the knee...",
				  "Stormcloaks, Imperials, dragons. Ain't no matter to me what I kill. Let them come."};

		NPC npc1 = new NPC();
		NPC npc2 = new NPC("Ri'saad","Khajiit", 5, 1, npc2Dialogue, true);
		NPC npc3 = new NPC("Whiterun Guard","Nord", 2, 10, npc3Dialogue, false);
		
		ArrayList<NPC> npcs = new ArrayList<>();
		
		npcs.add(npc1);
		npcs.add(npc2);
		npcs.add(npc3);
		
		return npcs;
	}

	public static void createNPC(ArrayList<NPC> npcs) {
		NPC customNPC = new NPC();		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Name: ");
		customNPC.setName(scan.nextLine());
		
		System.out.print("Race: ");
		customNPC.setRace(scan.nextLine());
		
		System.out.print("X Pos: ");
		customNPC.setXPos(scan.nextDouble());
		
		System.out.print("Y Pos: ");
		customNPC.setYPos(scan.nextDouble());
		
		System.out.print("How many lines of dialogue will you enter?: ");
		int numDialogue = scan.nextInt();
		String[] newDialogue = new String[numDialogue];
		
		scan.nextLine();
		
		for (int i = 0; i < numDialogue; i++) {
			System.out.print("Enter Line #" + (i+1) + ": ");
			newDialogue[i] = scan.nextLine();
		}
		
		customNPC.setDialogue(newDialogue);
		
		System.out.print("Is dialogue sequential? Y/N: ");
		String sequential = scan.next();
		boolean isSequential = false;
		if (sequential.equals("Y") || sequential.equals("y")) 
			isSequential = true;		
		
		customNPC.setSequential(isSequential);
		
		npcs.add(customNPC);
		
	}
	
 	public static NPC mainMenu(ArrayList<NPC> npcs) { 
 		Scanner scan = new Scanner(System.in);
		NPC returnedNPC = npcs.get(0);
		boolean repeatMenu;
		
 		do {
 			//maybe a mainMenuText method to display the text
			System.out.println("Choose an NPC:");
			
			int size = npcs.size();
			for (int i = 0; i<size ; i++) {
				System.out.println((i+1) + ". " + npcs.get(i).getName());
			}
			
			System.out.print( (size+1) + ". Create NPC\n" + 
							  (size+2) + ". Quit Program\n" + 
					 		  "Enter the number choice (1-" + (size+2) + "): ");									
			
			int mainSelect = scan.nextInt();
			System.out.println();
			repeatMenu = false;	
		
			if (mainSelect == (size+1)) {
				createNPC(npcs);
				repeatMenu = true;
			} else if (mainSelect == (size+2)) {
				System.exit(0);
			} else if (mainSelect <= size ) {
				returnedNPC = npcs.get(mainSelect - 1);
			} else {
				System.out.println("Please enter a valid command.");
			}
			
		} while (repeatMenu == true);
		
		return returnedNPC;
		
	}
	
	public static boolean secondaryMenu(NPC selectedNPC, boolean repeatMenu) {
		Scanner scan2 = new Scanner(System.in);
		
		do {
			System.out.print("Test Menu for " + selectedNPC.getName() + "\n" +
							   "1. Display NPC Information\n" +
							   "2. Talk to NPC\n" +
							   "3. Make NPC walk up\n" +
							   "4. Make NPC walk down\n" +
							   "5. Make NPC walk left\n" +
							   "6. Make NPC walk right\n" +
							   "7. Go back to previous menu\n" +
							   "8. Quit Program\n" + 
							   "Enter the number choice (1-8):");
			
			int secondarySelect = scan2.nextInt();
			System.out.println();
			repeatMenu = true;
			
			switch (secondarySelect) {
				case 1:
					System.out.println(selectedNPC);
					break;
				case 2: 
					selectedNPC.talk();
					break;
				case 3:
					selectedNPC.walk("up");
					System.out.println("New Y Position: " + selectedNPC.getYPos());
					break;
				case 4:
					selectedNPC.walk("down");
					System.out.println("New Y Position: " + selectedNPC.getYPos());
					break;
				case 5:
					selectedNPC.walk("left");
					System.out.println("New X Position: " + selectedNPC.getXPos());
					break;
				case 6:
					selectedNPC.walk("right");
					System.out.println("New X Position: " + selectedNPC.getXPos());
					break;
				case 7:
					repeatMenu = false;
					//can do a simple return call to end the method to simplify the while loop
					break;
				case 8:
					System.exit(0);
				default:
					System.out.println("Please enter a valid command.");	
				
			}
			
		} while (repeatMenu == true);
		
		return repeatMenu;
		
	} 
	
}

