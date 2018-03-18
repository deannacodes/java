/**
 * Author: Deanna Streffer
 *
 * Description: CPU class which declares and provides getters for all pieces of a CPU object.
 * 
 */

package hw3;

public class CPU {
	private String name;
	private double speed;
	private double price;
	
	public CPU(String name, double speed, double price) {
		this.name = name;
		this.speed = speed;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getSpeed() {
		return speed;
	}

	public double getPrice() {
		return price;
	}
	
	public String toString() {
		String CPUInfo = getName() +
						 "\n\tSpeed: " + getSpeed() +
						 "\n\tPrice:...................................$" + getPrice() + "\n";
		
		return CPUInfo;
	}

}
