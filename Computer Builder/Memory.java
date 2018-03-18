/**
 * Author: Deanna Streffer
 *
 * Description: Memory class which declares and provides getters for all pieces of a memory object.
 * 
 */

package hw3;

public class Memory {
	private String name;
	private int size;
	private double price;
	
	public Memory(String name, int size, double price) {
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
		String memoryInfo = getName() +
							"\n\tSize: " + getSize() +
							"\n\tPrice:...................................$" + getPrice() + "\n";
		
		return memoryInfo;
	}
}