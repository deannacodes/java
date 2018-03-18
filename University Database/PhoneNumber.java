/*
Creates and manages a PhoneNumber object which contains the different components of a phone number.

By: Deanna Streffer
 */

package hw6;

public class PhoneNumber {
	private String type;
	private String areaCode;
	private String prefix;
	private String suffix;
	
	
	
	
	
	public PhoneNumber(String type, String areaCode, String prefix, String suffix) {
		this.type = type;
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	
	
	
	
	public String getType() {
		return type;
	}

	
	
	
	
	public void setType(String type) {
		this.type = type;
	}

	
	
	
	
	public String getAreaCode() {
		return areaCode;
	}

	
	
	
	
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	
	
	
	
	public String getPrefix() {
		return prefix;
	}

	
	
	
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	
	
	
	
	public String getSuffix() {
		return suffix;
	}

	
	
	
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	
	
	
	
	@Override
	public String toString() {
		String out = this.type + ": (" + this.areaCode + ") " + this.prefix + "-" + this.suffix;
		
		return out;
	}
	
}
