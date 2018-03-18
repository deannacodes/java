/**
 * Author: Deanna Streffer
 *
 * Description: Case class which declares and provides getters for all pieces of a case object.
 * 
 */

package hw3;

public class Case {
	private String name;
	private double height;
	private double width;
	private double depth;
	private String type;
	private double price;
	
	public Case(String name, double height, double width, double depth, String type, double price) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.type = type;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public double getHeight() {
		return height;
	}
	public double getWidth() {
		return width;
	}
	public double getDepth() {
		return depth;
	}
	public String getType() {
		return type;
	}
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		
		String caseInfo = getName() + "\n" +
						  "\tDimensions: " + getDepth() + "\" x " + getWidth() + "\" x " + getHeight() + "\"\n" +
						  "\tType: " + getType() + "\n" +
						  "\tPrice:...................................$" + getPrice() + "\n";
		return caseInfo;
		
	}
	
}
