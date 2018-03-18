/*
This class creates and manages a FileIO object. This reads in data from a .csv file and parses it 
into an array of Person Objects to be managed with. Contains exception handling for reading Students 
with invalid class standings.

By: Deanna Streffer
*/

package hw6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIO {
	ArrayList<Person> people;
	File file;
	
	
	
	

	public FileIO(File file) {
		people = new ArrayList<>();
		this.file = file;
	}
	
	
	
	
	public ArrayList<Person> getPeople() {
		return new ArrayList<Person>(this.people);
	}

	
	
	
	
	public void readData() throws FileNotFoundException {
		Scanner read = new Scanner(file);
		ArrayList<String> data = new ArrayList<>();

		while (read.hasNextLine()) {
			data.add(read.nextLine());
		}

		parseData(data);

		read.close();

	}

	
	
	
	
	private void parseData(ArrayList<String> data) {

		for ( int i = 0 ; i < data.size() ; i++ ) {
			String dataLine = data.get(i);
			String[] dataSplit = dataLine.split(",");
			
			
			if (dataLine.startsWith("Student")) {
				ArrayList<PhoneNumber> phoneNumbers = parsePhoneNumbers(data,i);				
				Address address = parseAddress(dataSplit);
				
				boolean error = true;
				while (error) {
					try {
						Student student = new Student(dataSplit[10], dataSplit[1], dataSplit[2], dataSplit[9], address, phoneNumbers);
						people.add(student);
						error = false;
					}
					catch (IllegalArgumentException ex ) {
						System.out.print("Invalid class standing for student " + dataSplit[1] + " " + dataSplit[2] + 
										   ". \nPlease enter a valid class standing (Freshman, Graduate, etc): ");
						Scanner scan = new Scanner(System.in);
						dataSplit[10] = scan.nextLine();
					}
				}
				
				
			} 
			else if (dataLine.startsWith("Faculty")) {
				ArrayList<PhoneNumber> phoneNumbers = parsePhoneNumbers(data,i);
				Address address = parseAddress(dataSplit);
				
				boolean isFullTime = false;
				if (dataSplit[13].equals("Full Time"))
					isFullTime = true;

				Faculty faculty = new Faculty(dataSplit[12], isFullTime, dataSplit[10], Integer.parseInt(dataSplit[11]), 
						dataSplit[1], dataSplit[2],dataSplit[8],address,phoneNumbers);
				
				people.add(faculty);
			} 
			else if (dataLine.startsWith("Staff")) {
				ArrayList<PhoneNumber> phoneNumbers = parsePhoneNumbers(data,i);
				Address address = parseAddress(dataSplit);
				
				Staff staff = new Staff(dataSplit[12], dataSplit[10], Integer.parseInt(dataSplit[11]), dataSplit[1], 
						dataSplit[2],dataSplit[9],address,phoneNumbers);

				people.add(staff);
			} 



		}

	}
	
	
	
	
	
	private ArrayList<PhoneNumber> parsePhoneNumbers(ArrayList<String> data, int i) {
		ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
		int count = 1;
		
		while (data.get(i+count).startsWith("Phone")) {
			String[] phoneDataSplit = data.get(i+count).split(",");
			PhoneNumber phoneNumber = new PhoneNumber(phoneDataSplit[1],phoneDataSplit[2],phoneDataSplit[3],phoneDataSplit[4]);
			phoneNumbers.add(phoneNumber);	
			
			if ( ( i + count + 1 ) >= (data.size())) {
				break;
			}

			count++;
		}
		
		return phoneNumbers;
	}
	
	
	
	
	
	
	private Address parseAddress(String[] dataSplit) {
		Address address = new Address(dataSplit[3], dataSplit[5], dataSplit[6], dataSplit[7], dataSplit[8]);			
		if (!dataSplit[4].equals("-1")) {
			address.setApartmentNumber(dataSplit[4]);
		}
		
		return address;
	}
	

}
