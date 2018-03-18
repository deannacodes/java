/*
Main interface class which tests all people and data classes. Reads data from CSV and creates a database
object. Then, allows the user to view all data and add new people to the database.

By: Deanna Streffer
*/

package hw6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import hw1_and_hw2.NPC;

public class Tester {
	
	
	
	
	
	public static void main(String[] args) {
		
		Database db = initFromFile();	
		
		while(true) {
			mainMenu(db);
		}

		
	}
	
	
	
	
	
	public static Database initFromFile() {
		File file = new File("resources/test.txt");
		FileIO readFile = new FileIO(file);
		
		try {
			readFile.readData();
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		}
		
		Database db = new Database(readFile.getPeople());
		return db;
	}
	
	
	

	public static void mainMenu(Database db) {
		Scanner scan = new Scanner(System.in);
			
		System.out.print("******** UNIVERSITY DATABASE ********\n" +
				   		"1. All \n" +
				   		"2. Employees \n" +
				   		"3. Students\n" + 
				   		"4. Add Person\n" +
				   		"5. Quit\n" +
				   		"Select a number 1-5: ");											
			
		int choice = scan.nextInt();
		scan.nextLine();
		System.out.println();
		
		switch (choice) {
			case 1: 
				printAll(db);
				break;
			case 2:
				employeeMenu(db);
				break;
			case 3:
				studentMenu(db);
				break;
			case 4:
				createPerson(db);
				break;
			case 5:
				System.exit(0);
		}
		
	}
	
	
	
	
	public static void printAll(Database db) {
		System.out.println("******** PRINTING DATABASE ********");
		System.out.println("********* TOTAL PEOPLE: " + 
				   db.getNumberOfPeople() + 
				   " *********");
		db.printDatabase();
	}
	
	
	
	
	public static void employeeMenu(Database db) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("******** EMPLOYEE DATABASE ********\n" +
				   		"1. All Employees \n" +
				   		"2. Faculty Only \n" +
				   		"3. Staff Only\n" + 
				   		"4. Salary Checker\n" +
				   		"5. Previous Menu\n" +
				   		"6. Quit\n" +
				   		"Select a number 1-5: ");											
			
		int choice = scan.nextInt();
		scan.nextLine();
		
		switch (choice) {
			case 1: 
				printAllEmployees(db);
				break;
			case 2:
				printAllFaculty(db);
				break;
			case 3: 
				printAllStaff(db);
				break;
			case 4:
				salaryChecker(db);
			case 5: 
				break;
			case 6:
				System.exit(0);
		}
	}
	
	
	
	
	public static void printAllEmployees(Database db) {
		System.out.println("******** PRINTING DATABASE ********");
		System.out.println("********* TOTAL PEOPLE: " + 
				   db.getNumberOfEmployees() + 
				   " *********");
		db.printDatabase("Employee");
	}
	
	
	
	
	public static void printAllFaculty(Database db) {
		System.out.println("******** PRINTING DATABASE ********");
		System.out.println("********* TOTAL PEOPLE: " + 
				   db.getNumberOfFaculty() + 
				   " *********");
		db.printDatabase("Faculty");
	}
	
	
	
	
	public static void printAllStaff(Database db) {
		System.out.println("******** PRINTING DATABASE ********");
		System.out.println("********* TOTAL PEOPLE: " + 
				   db.getNumberOfStaff() + 
				   " *********");
		db.printDatabase("Staff");
	}
	
	
	
	
	public static void salaryChecker(Database db) {
		System.out.println("******** EMPLOYEES WITH SALARY OVER $30,000: ********");
		db.displayEmployeesGreaterThanSalary(30000);
		
		System.out.println("******** EMPLOYEES WITH SALARY EQUAL TO $30,000: ********");
		db.displayEmployeesEqualToSalary(30000);
		
		System.out.println("******** EMPLOYEES WITH SALARY UNDER $30,000: ********");
		db.displayEmployeesLessThanSalary(30000);
	}
	
	
	
	
	public static void studentMenu(Database db) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("******** STUDENT DATABASE ********\n" +
				   		"1. All Students \n" +
				   		"2. Student Statistics \n" +
				   		"3. Previous Menu\n" +
				   		"4. Quit\n" +
				   		"Select a number 1-4: ");											
			
		int choice = scan.nextInt();
		scan.nextLine();
		
		switch (choice) {
			case 1: 
				printAllStudents(db);
				break;
			case 2:
				printStudentStats(db);
				break;
			case 3: 
				break;
			case 4:
				System.exit(0);
		}
	}
	
	
	
	
	public static void printAllStudents(Database db) {
		System.out.println("******** PRINTING DATABASE ********");
		System.out.println("******** TOTAL PEOPLE: " + 
				   db.getNumberOfStudents() + 
				   " ********");
		db.printDatabase("Student");
	}
	
	
	
	
	public static void printStudentStats(Database db) {
		System.out.println("******** TOTAL FRESHMAN: " + 
				   db.getNumberOfStudentsByClassStanding("Freshman") + 
				   " ********");
		
		System.out.println("******** TOTAL SOPHOMORES: " + 
				   db.getNumberOfStudentsByClassStanding("Sophomore") + 
				   " ********");
		
		System.out.println("******** TOTAL JUNIORS: " + 
				   db.getNumberOfStudentsByClassStanding("Junior") + 
				   " ********");
		
		System.out.println("******** TOTAL SENIORS: " + 
				   db.getNumberOfStudentsByClassStanding("Senior") + 
				   " ********");
		
		System.out.println("******** TOTAL GRADUATES: " + 
				   db.getNumberOfStudentsByClassStanding("Graduate") + 
				   " ********");
	}
	
	
	
	
	public static void createPerson(Database db) {
			Scanner scan = new Scanner(System.in);
			
			String type;
			do {
				System.out.print("Person Type: ");
				type = scan.nextLine();
			} while(!type.equalsIgnoreCase("Student") && 
					!type.equalsIgnoreCase("Faculty") && 
					!type.equalsIgnoreCase("Staff") );
			
			System.out.print("First Name: ");
			String fname = scan.nextLine();
			
			System.out.print("Last Name: ");
			String lname = scan.nextLine();
			
			System.out.print("Email: ");
			String email = scan.nextLine();
			
			Address address = createAddress(scan);
			
			ArrayList<PhoneNumber> pns = createPhoneNumbers(scan);
			
			if (type.equalsIgnoreCase("Faculty")) {
				createFaculty(db, scan, fname, lname, email, address, pns);
				
			} else if (type.equalsIgnoreCase("Staff")) {
				createStaff(db, scan, fname, lname, email, address, pns);

				
			} else if (type.equalsIgnoreCase("Student")) {
				createStudent(db, scan, fname, lname, email, address, pns);								
				
				
			} else {
				System.out.println("An error has occured. Try again.");
			}
			

		
	}
	
	
	
	
	public static Address createAddress(Scanner scan) {
		System.out.print("\nAddress \n");
		System.out.print("House Number: ");
		String houseNum = scan.nextLine();
		
		System.out.print("Street: ");
		String street = scan.nextLine();
		
		System.out.print("Apartment Number (Enter N/A if none): ");
		String apt = scan.nextLine();
		
		System.out.print("City: ");
		String city = scan.nextLine();
		
		System.out.print("State: ");
		String state = scan.nextLine();
		
		System.out.print("ZIP Code: ");
		String zip = scan.nextLine();

		Address address = new Address(houseNum, street, city, state,zip);
		if (!apt.equalsIgnoreCase("N/A"))
			address.setApartmentNumber(apt);
		
		return address;
	}
	
	
	
	
	public static ArrayList<PhoneNumber> createPhoneNumbers(Scanner scan) {		
		System.out.print("\nPhone Numbers\n ");
		ArrayList<PhoneNumber> pns = new ArrayList<>();
		boolean another = true;
		while(another) {
			System.out.print("Phone Type: ");
			String pType = scan.nextLine();
			
			
			String pNum;
			do {
				System.out.print("Phone Number ###-###-####: ");
				pNum = scan.nextLine();
			} while (!pNum.matches("\\d{3}-\\d{3}-\\d{4}"));
			
			String[] pNumSplit = pNum.split("-");
			PhoneNumber pn = new PhoneNumber(pType,pNumSplit[0],pNumSplit[1],pNumSplit[2]);
			pns.add(pn);
			
			System.out.print("Add another number? (Y/N): ");
			String yn = scan.nextLine();
			
			if (yn.equalsIgnoreCase("No") || yn.equalsIgnoreCase("N"))
				another = false;
			
		} 
		
		return pns;
	}
	
	
	
	
	public static void createFaculty(Database db, Scanner scan, String fname, String lname, String email, Address address, ArrayList<PhoneNumber> pns) {		
		System.out.print("Office: ");
		String office = scan.nextLine();
		
		System.out.print("Salary: ");
		int salary = scan.nextInt();
		scan.nextInt();
		
		System.out.print("Office Hours: ");
		String hours = scan.nextLine();
		
		System.out.print("Full Time or Part Time: ");
		boolean isFullTime = false;
		if (scan.nextLine().equalsIgnoreCase("Full Time"))
			isFullTime = true;

		Faculty faculty = new Faculty(hours, isFullTime, office, salary, fname, lname, email, address, pns);
					
		db.addPeople(faculty);				
		System.out.print("Staff added.\n" + faculty);
	}
	
	
	
	
	public static void createStaff(Database db, Scanner scan, String fname, String lname, String email, Address address, ArrayList<PhoneNumber> pns) {
		System.out.print("Office: ");
		String office = scan.nextLine();
		
		System.out.print("Salary: ");
		int salary = scan.nextInt();
		scan.nextInt();
		
		System.out.print("Job Title: ");
		String job = scan.nextLine();
						
		Staff staff = new Staff(job, office, salary, fname, lname, email, address, pns);
		db.addPeople(staff);				
		System.out.print("Staff added.\n" + staff);
	}
	
	
	
	
	public static void createStudent(Database db, Scanner scan, String fname, String lname, String email, Address address, ArrayList<PhoneNumber> pns) {
		String standing;
		System.out.print("Class Standing: ");
		standing = scan.nextLine();
		
		Student student;
		boolean error = true;
		while (error) {
			try {
				student = new Student(standing, fname, lname, email, address, pns);
				db.addPeople(student);				
				System.out.print("Student added.\n" + student);
				error = false;
			}
			catch (IllegalArgumentException ex ) {
				System.out.print("Invalid class standing for student " + fname + " " + lname + 
								   ". \nPlease enter a valid class standing (Freshman, Graduate, etc): ");
				standing = scan.nextLine();
			}
		}
	}
	
	
	
	
	
}