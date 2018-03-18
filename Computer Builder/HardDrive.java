/**
 * Author: Deanna Streffer
 *
 * Description: HardDrive class which declares and provides getters for all pieces of a hard drive object.
 * 
 */

package hw3;

public class HardDrive {
	private String name;
	private int size;
	private double price;
	
	public HardDrive(String name, int size, double price) {
		this.name = name;
		this.size = size;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public double getPrice() {
		return price;
	}
	
	public String toString() {
		String hardDriveInfo = getName() +
							   "\n\tSize: " + getSize() +
							   "\n\tPrice:...................................$" + getPrice() + "\n";
		
		return hardDriveInfo;
	}
}
