/*
This class creates and manages a Student Object which extends the Person Object. Throws 
exception when an invalid class standing is submitted.

By: Deanna Streffer
*/

package hw6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Student extends Person {
	private String classStanding;
	Set<String> classes;
	
	
	
	
	public Student(String classStanding, String firstName, String lastName, String emailAddress, Address address, 
				   ArrayList<PhoneNumber> phoneNumbers) {
		super(firstName, lastName, emailAddress, address, phoneNumbers);
		
		classes = new HashSet<>();
		classes.add("freshman");
		classes.add("sophomore");
		classes.add("junior");
		classes.add("senior");
		classes.add("graduate");		
		
		if(!classes.contains(classStanding.toLowerCase()))
        {
           throw new IllegalArgumentException("Invalid class standing");
        }
		
		this.classStanding = classStanding;
	}
	
	
	
	

	public String getClassStanding() {
		return classStanding;
	}

	
	
	
	
	public void setClassStanding(String classStanding) {
		this.classStanding = classStanding;
	}
	
	
	
	
	

	@Override
	public String toString() {
		String out = super.toString();
			   out += String.format("%15s", "Class Standing: ");
			   out += this.classStanding + "\n";
			   
		return out; 					
	}
	
}
