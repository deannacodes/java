/*
This class creates and manages a Staff Object which extends the Employee Object.

By: Deanna Streffer
*/

package hw6;

import java.util.ArrayList;

public class Staff extends Employee {
	private String jobTitle;
	
	
	
	
	
	public Staff(String jobTitle, String office, int salary, String firstName, String lastName, String emailAddress, 
			Address address, ArrayList<PhoneNumber> phoneNumbers) {
		super(office, salary, firstName, lastName, emailAddress, address, phoneNumbers);
		this.jobTitle = jobTitle;
	}

	
	
	
	
	public String getJobTitle() {
		return jobTitle;
	}

	
	
	
	
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	
	
	
	
	@Override
	public String toString() {
		String out = super.toString();
			   out += String.format("%15s", "Job Title: ");
			   out += this.jobTitle + "\n";
		
		return out;
	}

}
