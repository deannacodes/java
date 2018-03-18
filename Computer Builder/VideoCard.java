/**
 * Author: Deanna Streffer
 *
 * Description: VideoCard class which declares and provides getters for all pieces of a video card object.
 * 
 */

package hw3;

public class VideoCard {
	private String name;
	private int memorySize;
	private double price;
	
	public VideoCard(String name, int memorySize, double price) {
		this.name = name;
		this.memorySize = memorySize;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getMemorySize() {
		return memorySize;
	}

	public double getPrice() {
		return price;
	}
	
	public String toString() {
		String videoCardInfo = getName() +
							   "\n\tMemory Size: " + getMemorySize() +
							   "\n\tPrice:...................................$" + getPrice() + "\n";
		
		return videoCardInfo;
	}
}
