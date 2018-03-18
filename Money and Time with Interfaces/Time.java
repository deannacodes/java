package hw7;

public class Time implements Comparable<Time>, Calculable<Time>{
	int hours;
	int minutes;
	int seconds;
	boolean am;
	
	public Time() {
		hours = 0;
		minutes = 0;
		seconds = 0;
		am = true;
	}
	
	public Time(int hours, int minutes, int seconds, boolean am) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.am = am;
	}
	
	public Time(Time t) {
		this.hours = t.hours;
		this.minutes = t.minutes;
		this.seconds = t.seconds;
		this.am = t.am;
	}
	
	private int getSeconds(Time t) {
		int seconds = (t.hours * 3600) + (t.minutes * 60) + t.seconds;
		return seconds;
	}
	
	private Time formatTime(int seconds) {
		boolean newAm = this.am;

		if (seconds < 0) {
			seconds *= -1;
			if (newAm)
				newAm = false;
			else
				newAm = true;
		}
		
		int newSeconds = seconds % 60;
		seconds -= newSeconds;
		double totalMinutes = ((double)seconds) / 60.0;	
		
		int newMinutes = (int)totalMinutes % 60;
		totalMinutes -= newMinutes;
		double totalHours = ((double)totalMinutes) / 60.0;
		
		while (totalHours > 12) {
			totalHours -= 12;
			if (newAm)
				newAm = false;
			else
				newAm = true;
		}
		
		return new Time((int)totalHours, (int)newMinutes, newSeconds, newAm);
	}

	@Override
	public Time add(Time t) {
		int totalSeconds = getSeconds(this);
		int addSeconds = getSeconds(t);
		
		totalSeconds += addSeconds;
		
		Time addition = formatTime(totalSeconds);		
		
		return addition;
	}


	@Override
	public Time subtract(Time t) {
		int totalSeconds = getSeconds(this);
		int addSeconds = getSeconds(t);
		
		totalSeconds = totalSeconds - addSeconds;
		
		
		Time subtraction = formatTime(totalSeconds);		
		
		return subtraction;
	}

	@Override
	public int compareTo(Time t) {
		int leftSeconds = getSeconds(this);
		int rightSeconds = getSeconds(t);
		
		if (this.am && !t.am)
			return -1;
		else if (!this.am && t.am)
			return 1;
		else {
			if (leftSeconds < rightSeconds)
				return -1;
			else if (leftSeconds > rightSeconds)
				return 1;
			else
				return 0;
		}
	}

	@Override
	public String toString() {
		String ampm = "AM";
		if (!this.am)
			ampm = "PM";
		
		String out = String.format("%02d", this.hours);
			   out += ":";
			   out += String.format("%02d", this.minutes);
			   out += ":";
			   out += String.format("%02d", this.seconds);
			   out += " " + ampm;
		return out;
	}
	
}
