/**
 * Author: Deanna Streffer
 *
 * Description: Main class which is used to test all Computer and Computer part classes. 
 * The user will be able to build their own computer and view an itemized reciept of 
 * all items and the total cost.
 * 
 */

package hw3;
import java.util.ArrayList;
import java.util.Scanner;

public class ComputerMain {
	
	public static void main(String[] args) {
		ArrayList<Case> cases = initializeCases();
		ArrayList<Monitor> monitors = initializeMonitors();
		ArrayList<CPU> cpus = initializeCPUs();
		ArrayList<VideoCard> videoCards = initializeVideoCards();
		ArrayList<HardDrive> hardDrives = initializeHardDrives();
		ArrayList<Memory> memories = initializeMemories();
		
		int[] selections = {0,0,0,0,0,0};
		
		while (true) {
			mainMenu(cases, monitors, cpus, videoCards, hardDrives, memories, selections);
		}
	}

	
	
	
	
	public static ArrayList<Case> initializeCases() {
		Case case0 = new Case("No case selected", 0, 0, 0, "", 0);
		Case case1 = new Case("Antec Twelve Hundred V3", 22.87, 8.39, 20.20, 
							  "ATX Full Tower", 154.99);
		Case case2 = new Case("BitPhenix Phenom M Arctic White", 14.69, 12.95, 9.80,
							  "MicroATX Mini Tower", 89.99);
		Case case3 = new Case("Corsair 250D", 11.4, 10.9, 13.8,
							  "MiniITX Tower", 99.99);
		
		ArrayList<Case> cases = new ArrayList<>();
		cases.add(case0);
		cases.add(case1);
		cases.add(case2);
		cases.add(case3);
	
		return cases;
	}
		
	

	
	
	public static ArrayList<Monitor> initializeMonitors() {
		Monitor monitor0 = new Monitor("No monitor selected", 0, 0);
		Monitor monitor1 = new Monitor("Asus PB278Q", 27, 549.99);
		Monitor monitor2 = new Monitor("Dell U2412M", 24, 263.99);
		Monitor monitor3 = new Monitor("Samsung S22C300H", 21.5, 139.99);
		
		ArrayList<Monitor> monitors = new ArrayList<>();
		monitors.add(monitor0);
		monitors.add(monitor1);
		monitors.add(monitor2);
		monitors.add(monitor3);
		
		return monitors;
	}
		
	
	
	
	
	public static ArrayList<CPU> initializeCPUs() {
		CPU cpu0 = new CPU("No cpu selected", 0, 0);
		CPU cpu1 = new CPU("AMD FX-8350", 4.0, 188.99);
		CPU cpu2 = new CPU("Intel Core i5-3570K", 3.4, 179.99);
		CPU cpu3 = new CPU("Intel Core i7-3770K", 3.5, 249.99);
		
		ArrayList<CPU> cpus = new ArrayList<>();
		cpus.add(cpu0);
		cpus.add(cpu1);
		cpus.add(cpu2);
		cpus.add(cpu3);
		
		return cpus;
	}

	

	
	
	public static ArrayList<VideoCard> initializeVideoCards() {
		VideoCard videoCard0 = new VideoCard("No video card selected", 0, 0);
		VideoCard videoCard1 = new VideoCard("Nvidia GeForce GTX 770", 2, 346.99);
		VideoCard videoCard2 = new VideoCard("Nvidia GeForce GTX 670", 2, 333.99);
		VideoCard videoCard3 = new VideoCard("AMD Radeon HD 7950", 3, 399.99);
		
		ArrayList<VideoCard> videoCards = new ArrayList<>();
		videoCards.add(videoCard0);
		videoCards.add(videoCard1);
		videoCards.add(videoCard2);
		videoCards.add(videoCard3);
		
		return videoCards;
	}
		
	

	
	
	public static ArrayList<HardDrive> initializeHardDrives() {
		HardDrive hardDrive0 = new HardDrive("No Hard Drive Selected", 0, 0);
		HardDrive hardDrive1 = new HardDrive("Samsung MZ-7PD256BW", 256, 199.99);
		HardDrive hardDrive2 = new HardDrive("Corsair CSSD-F240GBGT-BK", 240, 206.99);
		HardDrive hardDrive3 = new HardDrive("Crucial CT128M4SSD1", 128, 199.95);
		
		ArrayList<HardDrive> hardDrives = new ArrayList<>();
		hardDrives.add(hardDrive0);
		hardDrives.add(hardDrive1);
		hardDrives.add(hardDrive2);
		hardDrives.add(hardDrive3);
		
		return hardDrives;
	}
		
	

	
	
	public static ArrayList<Memory> initializeMemories() {
		Memory memory0 = new Memory("No Memory Selected", 0, 0);
		Memory memory1 = new Memory("Corsair Vengeance", 8, 69.99);
		Memory memory2 = new Memory("G.Skill Ares Series", 16, 149.99);
		Memory memory3 = new Memory("Kingston Black Series", 8, 79.99);
		
		ArrayList<Memory> memories = new ArrayList<>();
		memories.add(memory0);
		memories.add(memory1);
		memories.add(memory2);
		memories.add(memory3);
		
		return memories;
	}
	
	
	
	

	public static void mainMenu(ArrayList<Case> cases, ArrayList<Monitor> monitors, ArrayList<CPU> cpus, ArrayList<VideoCard> videoCards,  
								ArrayList<HardDrive> hardDrives, ArrayList<Memory> memories, int[] selections) {
		
		Scanner scan = new Scanner(System.in); 
		System.out.print("***********Main Menu************\n" +
						 "1. Choose a Case\n" +
						 "2. Choose a Monitor\n" +
						 "3. Choose a CPU\n" +
						 "4. Choose a Video Card\n" +
						 "5. Choose a Hard Drive\n" +
						 "6. Choose a Memory\n" +
						 "7. Delete Current Computer\n" + 
						 "8. Display Receipt\n" + 
						 "9. Exit Program\n" + 
						 "********************************\n" + 
						 "Please choose an option to build your computer: ");
			
		int mainSelect = scan.nextInt();
		System.out.println();
		
		
		switch (mainSelect) {
			case 1:
				caseMenu(cases, selections);
				break;
			case 2:
				monitorMenu(monitors, selections);
				break;
			case 3:
				cpuMenu(cpus, selections);
				break;
			case 4:
				videoCardMenu(videoCards, selections);
				break;
			case 5:
				hardDriveMenu(hardDrives, selections);
				break;
			case 6:
				memoryMenu(memories, selections);
				break;
			case 7: 
				deleteComputer(selections);
				break;
			case 8:
				printReceipt(cases, monitors, cpus, videoCards, hardDrives, memories, selections);
				break;
			case 9:
				System.exit(0);
			default:
				System.out.println("Please enter a valid command.");	
		
		}
		
	}
	
	public static void caseMenu(ArrayList<Case> cases, int[] selections) {
		System.out.println("**********************Case Menu***********************");
		for (int i = 1; i < cases.size() ; i++) {
			System.out.println(i + ". " + cases.get(i));
		}
		System.out.print("Please choose a Case: ");
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		
		selections[0] = selection;
	}
	
	
	
	
	
	public static void monitorMenu(ArrayList<Monitor> monitors, int[] selections) {
		System.out.println("**********************Monitor Menu***********************");
		for (int i = 1; i < monitors.size() ; i++) {
			System.out.println(i + ". " + monitors.get(i));
		}
		System.out.print("Please choose a Monitor: ");
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		
		selections[1] = selection;
	}
	
	
	
	
	public static void cpuMenu(ArrayList<CPU> cpus, int[] selections) {
		System.out.println("**********************CPU Menu***********************");
		for (int i = 1; i < cpus.size() ; i++) {
			System.out.println(i + ". " + cpus.get(i));
		}
		System.out.print("Please choose a CPU: ");
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		
		selections[2] = selection;
	}
	
	
	
	
	public static void videoCardMenu(ArrayList<VideoCard> videoCards, int[] selections) {
		System.out.println("**********************Video Card Menu***********************");
		for (int i = 1; i < videoCards.size() ; i++) {
			System.out.println(i + ". " + videoCards.get(i));
		}
		System.out.print("Please choose a Video Card: ");
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		
		selections[3] = selection;
	}
	
	
	
	
	public static void hardDriveMenu(ArrayList<HardDrive> hardDrives, int[] selections) {
		System.out.println("**********************Hard Drive Menu***********************");
		for (int i = 1; i < hardDrives.size() ; i++) {
			System.out.println(i + ". " + hardDrives.get(i));
		}
		System.out.print("Please choose a Hard Drive: ");
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		
		selections[4] = selection;
	}
	
	
	
	
	public static void memoryMenu(ArrayList<Memory> memories, int[] selections) {
		System.out.println("**********************Memory Menu***********************");
		for (int i = 1; i < memories.size() ; i++) {
			System.out.println(i + ". " + memories.get(i));
		}
		System.out.print("Please choose Memory: ");
		Scanner scan = new Scanner(System.in);
		int selection = scan.nextInt();
		
		selections[5] = selection;
	}
	
	
	public static void deleteComputer(int[] selections) {
		for (int i = 0; i < selections.length; i++) {
			selections[i] = 0;
		}
		System.out.println("All selections have been deleted. ");
	}
	
	
	public static void printReceipt(ArrayList<Case> cases, ArrayList<Monitor> monitors, ArrayList<CPU> cpus, ArrayList<VideoCard> videoCards,  
									ArrayList<HardDrive> hardDrives, ArrayList<Memory> memories, int[] selections) {
		Computer comp = new Computer(cases.get(selections[0]), monitors.get(selections[1]), cpus.get(selections[2]), videoCards.get(selections[3]),
									 hardDrives.get(selections[4]), memories.get(selections[5]));
		comp.displayReceipt();
	}
	
}
