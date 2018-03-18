/*
This class creates and manages a Database object, which holds an arraylist of People objects. 

By: Deanna Streffer
*/

package hw6;

import java.util.ArrayList;

public class Database {
	private ArrayList<Person> people;
	
	
	
	
	
	public Database(ArrayList<Person> people) {
		this.people = people;
	}
	
	
	
	

	public ArrayList<Person> getPeople() {
		return new ArrayList<Person>(people);
	}
	
	
	
	

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}
	
	
	
	
	public void addPeople(Person person) {
		this.people.add(person);
	}
	
	
	
	

	public void printDatabase() {
		for ( int i = 0 ; i < this.people.size() ; i++ ) {
			System.out.println(this.people.get(i));
		}
	}
	
	
	
	
	
	public void printDatabase(String personType) {
			
		if (personType.equalsIgnoreCase("Employee")) {
			for ( int i = 0 ; i < this.people.size() ; i++ ) {
				if (this.people.get(i) instanceof Employee)
					System.out.println(this.people.get(i));
			}
		} else if (personType.equalsIgnoreCase("Faculty")) {
			for ( int i = 0 ; i < this.people.size() ; i++ ) {
				if (this.people.get(i) instanceof Faculty)
					System.out.println(this.people.get(i));
			}
		} else if (personType.equalsIgnoreCase("Staff")) {
			for ( int i = 0 ; i < this.people.size() ; i++ ) {
				if (this.people.get(i) instanceof Staff)
					System.out.println(this.people.get(i));
			}
		} else if (personType.equalsIgnoreCase("Student")) {
			for ( int i = 0 ; i < this.people.size() ; i++ ) {
				if (this.people.get(i) instanceof Student) 
					System.out.println(this.people.get(i));
			}
		} else {
			System.out.println("No records were found.");
		}
	
	}
	
	
	
	
	
	public int getNumberOfPeople() {
		return this.people.size();
	}
	
	
	
	
	
	public int getNumberOfStudents() {
		int count = 0;
		for ( int i = 0 ; i < this.people.size() ; i++ ) {
			if (this.people.get(i) instanceof Student) 
				count++;
		}
		return count;
	}
	
	
	
	
	
	public int getNumberOfEmployees() {
		int count = 0;
		for ( int i = 0 ; i < this.people.size() ; i++ ) {
			if (this.people.get(i) instanceof Employee) 
				count++;
		}
		return count;
	}
	
	
	
	
	

	public int getNumberOfStaff() {
		int count = 0;
		for ( int i = 0 ; i < this.people.size() ; i++ ) {
			if (this.people.get(i) instanceof Staff) 
				count++;
		}
		return count;
	}

	
	
	
	

	public int getNumberOfFaculty() {
		int count = 0;
		for ( int i = 0 ; i < this.people.size() ; i++ ) {
			if (this.people.get(i) instanceof Faculty) 
				count++;
		}
		return count;
	}
	
	
	
	
	
	public int getNumberOfStudentsByClassStanding(String classStanding) {
		int count = 0;
		for ( int i = 0 ; i < this.people.size() ; i++ ) {
			if (this.people.get(i) instanceof Student) {
				Student loopStudent = ((Student)this.people.get(i));
				if (loopStudent.getClassStanding().equalsIgnoreCase(classStanding)) {
					count++;
				}
			}
		}
		return count;
	}
	
	
	
	
	
	public void displayEmployeesGreaterThanSalary(int salary) {
		int count = 0;
		
		for ( int i = 0 ; i < this.people.size() ; i++ ) {
			if (this.people.get(i) instanceof Employee) {				
				Employee loopEmployee = ((Employee)this.people.get(i));
				if (loopEmployee.getSalary() > salary) {
					System.out.println(loopEmployee);
					count++;
				}
			}
		}
		
		if (count == 0) {
			System.out.println("No employees found.\n");
		}
	}
	
	
	
	
	
	public void displayEmployeesEqualToSalary(int salary) {
		int count = 0;
		
		for ( int i = 0 ; i < this.people.size() ; i++ ) {
			if (this.people.get(i) instanceof Employee) {				
				Employee loopEmployee = ((Employee)this.people.get(i));
				if (loopEmployee.getSalary() == salary) {
					System.out.println(loopEmployee);
					count++;
				}
			}
		}
		
		if (count == 0) {
			System.out.println("No employees found.\n");
		}
	}
	
	
	
	
	
	public void displayEmployeesLessThanSalary(int salary) {
		int count = 0;
		
		for ( int i = 0 ; i < this.people.size() ; i++ ) {
			if (this.people.get(i) instanceof Employee) {				
				Employee loopEmployee = ((Employee)this.people.get(i));
				if (loopEmployee.getSalary() < salary) {
					System.out.println(loopEmployee);
					count++;
				}
			}
		}
		
		if (count == 0) {
			System.out.println("No employees found.\n");
		}
	}
}
