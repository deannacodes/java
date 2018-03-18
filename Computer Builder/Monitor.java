/**
 * Author: Deanna Streffer
 *
 * Description: Monitor class which declares and provides getters for all pieces of a monitor object.
 * 
 */

package hw3;

public class Monitor {
	private String name;
	private double size;
	private double price;
	
	public Monitor(String name, double size, double price) {
		this.name = name;
		this.size = size;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getSize() {
		return size;
	}

	public double getPrice() {
		return price;
	}
	
	public String toString() {
		String monitorInfo = getName() +
							 "\n\tSize: " + getSize() +
							 "\n\tPrice:...................................$" + getPrice() + "\n";
		
		return monitorInfo;
	}
}
