/*
This class creates and manages a Faculty Object which extends the Employee Object.

By: Deanna Streffer
*/

package hw6;

import java.util.ArrayList;

public class Faculty extends Employee {
	private String officeHours;
	private boolean isFullTime;
	
	
	
	
	
	public Faculty(String officeHours, boolean isFullTime, String office, int salary, String firstName, String lastName, String emailAddress, 
			Address address, ArrayList<PhoneNumber> phoneNumbers) {
		super(office, salary, firstName, lastName, emailAddress, address, phoneNumbers);
		this.officeHours = officeHours;
		this.isFullTime = isFullTime;
	}

	
	
	
	
	public String getOfficeHours() {
		return officeHours;
	}

	
	
	
	
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	
	
	
	
	public boolean isFullTime() {
		return isFullTime;
	}

	
	
	
	
	public void setFullTime(boolean isFullTime) {
		this.isFullTime = isFullTime;
	}
	
	
	
	
	
	@Override
	public String toString() {
		String rank = "Part Time";
		if (isFullTime) 
			rank = "Full Time";
		
		
		String out = super.toString();
		   	   out += String.format("%15s", "Office Hours: ");
		   	   out += this.officeHours + "\n";
		   	   out += String.format("%15s", "Rank: ");
		   	   out += rank + "\n";
		
		return out;
	}
	
	
}
