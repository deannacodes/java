package hw7;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Money implements Comparable<Money>, Calculable<Money> {
	double dollars;
	
	public Money() {
		dollars = 0.0;
	}
	
	public Money(double dollars) {
		this.dollars = dollars;
	}
	
	public Money(Money m) {
		this.dollars = m.dollars;
	}

	public double getDollars() {
		return dollars;
	}

	public void setDollars(double dollars) {
		this.dollars = dollars;
	}

	@Override
	public int compareTo(Money m) {
		if (this.dollars < m.dollars)
			return -1;
		else if (this.dollars < m.dollars)
			return 1;
		else
			return 0;
	}

	@Override
	public Money add(Money m) {
		double newDollars = this.dollars + m.dollars;
		return new Money(newDollars);
	}

	@Override
	public Money subtract(Money m) {
		double newDollars = this.dollars - m.dollars;
		return new Money(newDollars);
	}

	@Override
	public String toString() {
		NumberFormat nf = new DecimalFormat("#0.00"); 
		
		String out = "$";
			   out += nf.format(this.dollars);
			   
		return out;
		
	}
	
	
}
