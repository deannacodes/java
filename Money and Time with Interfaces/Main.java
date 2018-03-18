package hw7;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
	
	
	
	
	
	public static void main(String[] args) {
		ArrayList<Money> money1 = generateMoney();
		ArrayList<Money> money2 = generateMoney();
		
		ArrayList<Time> time1 = generateTime();
		ArrayList<Time> time2 = generateTime();
		
		sortMoney(money1);
		sortMoney(money2);
		
		sortTime(time1);
		sortTime(time2);	
		
		addMoney(money1, money2);
		addTime(time1, time2);
		
		subtractMoney(money1, money2);
		subtractTime(time1, time2);
	}
	
	
	
	
	
	public static ArrayList<Money> generateMoney() {
		ArrayList<Money> money = new ArrayList<>();
		
		for ( int i = 0 ; i < 5 ; i++ ) {
			Random r = new Random();
			double randomMoney = Math.abs(r.nextInt(1000) + r.nextDouble());			
			NumberFormat nf = new DecimalFormat("#0.00"); 
			String randomMoneyFormat = nf.format(randomMoney);			
			double finalMoney = Double.parseDouble(randomMoneyFormat);
			
			Money m = new Money(finalMoney);
			
			money.add(m);
		}
		
		return money;
	}
	
	
	
	
	
	public static ArrayList<Time> generateTime() {
		ArrayList<Time> time = new ArrayList<>();
		
		for ( int i = 0 ; i < 5 ; i++ ) {
			Random r = new Random();
			int hours = r.nextInt(12);
			int minutes = r.nextInt(59);
			int seconds = r.nextInt(59);
			boolean am = r.nextBoolean();
			
			Time t = new Time(hours,minutes,seconds,am);
			time.add(t);
		}
		
		return time;
	}
	
	
	
	

	public static void sortMoney(ArrayList<Money> money) {
		System.out.println("********** ORIGINAL LIST **********");
		
		for ( int i = 0 ; i < money.size() ; i++ ) {
			System.out.println(money.get(i));
		}
		
		Collections.sort(money);
		
		System.out.println("*********** SORTED LIST ***********");
		
		for ( int i = 0 ; i < money.size() ; i++ ) {
			System.out.println(money.get(i));
		}
		
		System.out.println();
	}
	
	
	
	
	
	public static void sortTime(ArrayList<Time> time) {
		System.out.println("********** ORIGINAL LIST **********");
		
		for ( int i = 0 ; i < time.size() ; i++ ) {
			System.out.println(time.get(i));
		}
		
		Collections.sort(time);
		
		System.out.println("*********** SORTED LIST ***********");
		
		for ( int i = 0 ; i < time.size() ; i++ ) {
			System.out.println(time.get(i));
		}
		
		System.out.println();
	}

	
	
	
	public static void addMoney(ArrayList<Money> m1, ArrayList<Money> m2) {
		System.out.println("********** ADDING MONEY **********");
		int size = m1.size();
		if (m1.size() > m2.size())
			size = m2.size();
		
		for ( int i = 0 ; i < size ; i++ ) {
			Money m = m1.get(i).add(m2.get(i));
			System.out.println(m1.get(i) + " + " + m2.get(i) + " = " + m);
		}
		
		System.out.println();
	}
	
	
	
	
	public static void addTime(ArrayList<Time> t1, ArrayList<Time> t2) {
		System.out.println("********** ADDING TIME **********");
		int size = t1.size();
		if (t1.size() > t2.size())
			size = t2.size();
		
		for ( int i = 0 ; i < size ; i++ ) {
			Time t = t1.get(i).add(t2.get(i));
			System.out.println(t1.get(i) + " + " + t2.get(i) + " = " + t);
		}
		
		System.out.println();
	}
	
	
	
	
	public static void subtractMoney(ArrayList<Money> m1, ArrayList<Money> m2) {
		System.out.println("********* SUBTRACTING MONEY *********");
		int size = m1.size();
		if (m1.size() > m2.size())
			size = m2.size();
		
		for ( int i = 0 ; i < size ; i++ ) {
			Money m = m1.get(i).subtract(m2.get(i));
			System.out.println(m1.get(i) + " - " + m2.get(i) + " = " + m);
		}
		
		System.out.println();
	}
	
	
	
	
	public static void subtractTime(ArrayList<Time> t1, ArrayList<Time> t2) {
		System.out.println("********* SUBTRACTING TIME *********");
		int size = t1.size();
		if (t1.size() > t2.size())
			size = t2.size();
		
		for ( int i = 0 ; i < size ; i++ ) {
			Time t = t1.get(i).subtract(t2.get(i));
			System.out.println(t1.get(i) + " - " + t2.get(i) + " = " + t);
		}
		
		System.out.println();
	}
	
}
