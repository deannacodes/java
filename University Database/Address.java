/*
This class creates and manages an Address Object.

By: Deanna Streffer
*/

package hw6;

public class Address {
	private String streetNumber;
	private String apartmentNumber;
	private String streetName;
	private String city;
	private String state;
	private String zipCode;
	
	
	
	
	
	public Address(String streetNumber, String apartmentNumber, String streetName, String city, String state, String zipCode) {
		this.streetNumber = streetNumber;
		this.apartmentNumber = apartmentNumber;
		this.streetName = streetName; 
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		
	}
	
	
	
	
	
	public Address(String streetNumber, String streetName, String city, String state, String zipCode) {
		this.streetNumber = streetNumber;
		this.streetName = streetName; 
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		
	}
	
	
	
	

	public String getStreetNumber() {
		return streetNumber;
	}
	
	
	
	

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	
	
	

	public String getApartmentNumber() {
		return apartmentNumber;
	}
	
	
	
	

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	
	
	
	

	public String getStreetName() {
		return streetName;
	}

	
	
	
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	
	
	
	
	public String getCity() {
		return city;
	}

	
	
	
	
	public void setCity(String city) {
		this.city = city;
	}

	
	
	
	
	public String getState() {
		return state;
	}

	
	
	
	
	public void setState(String state) {
		this.state = state;
	}

	
	
	
	
	public String getZipCode() {
		return zipCode;
	}

	
	
	
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
	
	
	@Override
	public String toString() {
		String out = this.streetNumber + " " + this.streetName + "\n";
		
				if ( this.apartmentNumber != null ) {
					out += String.format("%-15s", "");
			   		out += "Apt " + this.apartmentNumber + "\n";
				}
				
			   out += String.format("%-15s", "");
			   out += this.city + ", " + this.state + " " + this.zipCode;
		
		return out;
	}
	
}
