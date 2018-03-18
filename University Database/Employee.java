/*
This class creates and manages an Employee Object, which extends the Person Object.

By: Deanna Streffer
*/

package hw6;

import java.util.ArrayList;

public class Employee extends Person { 	
	private String office;
	private int salary;
	
	
	
	
	
	public Employee(String office, int salary, String firstName, String lastName, String emailAddress, 
					Address address, ArrayList<PhoneNumber> phoneNumbers) {
		super(firstName, lastName, emailAddress, address, phoneNumbers);
		this.office = office;
		this.salary = salary;
	}

	
	
	
	
	public String getOffice() {
		return office;
	}

	
	
	
	
	public void setOffice(String office) {
		this.office = office;
	}

	
	
	
	
	public int getSalary() {
		return salary;
	}

	
	
	
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
	
	@Override
	public String toString() {
		String out = super.toString();
			   out += String.format("%15s", "Office: ");
			   out += this.office + "\n";
			   out += String.format("%15s", "Salary: ");
			   out += this.salary + "\n";
			   
		return out; 					
	}

}
