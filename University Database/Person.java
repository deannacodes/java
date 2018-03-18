/*
Base person class which contains basic person information.

By: Deanna Streffer
 */

package hw6;

import java.util.ArrayList;

public class Person {
	private String firstName;
	private String lastName;
	private String emailAddress;
	private Address address;
	private ArrayList<PhoneNumber> phoneNumbers;
	
	
	
	
	
	public Person(String firstName, String lastName, String emailAddress, Address address, ArrayList<PhoneNumber> phoneNumbers) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
	}
	
	
	
	
	
	public String getFirstName() {
		return firstName;
	}
	
	
	
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	
	
	public String getLastName() {
		return lastName;
	}
	
	
	
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
	
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	
	
	
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	
	
	
	public Address getAddress() {
		return address;
	}
	
	
	
	
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
	
	public ArrayList<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	
	
	
	
	public void setPhoneNumbers(ArrayList<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	
	
	
	
	@Override
	public String toString() {
		String out = String.format("%15s", "Name: " );
			   out += this.firstName + " " + this.lastName + "\n";
			   out += String.format("%15s", "Email: " );
			   out += this.emailAddress + "\n";
			   out += String.format("%15s", "Address: ");
			   out += this.address + "\n";
			   out += String.format("%15s", "Phone Numbers: ");
			   
			   for ( int i = 0 ; i < this.phoneNumbers.size() ; i++) {
				   if (i > 0)
					   out += String.format("%-15s", "");
				   out += this.phoneNumbers.get(i) + "\n";
			   }
					 
		
		return out;
	}
}
