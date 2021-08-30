package com.revature.controlflow;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		/*
		 * - if / else statements
		 * - if / else if statements
		 * - ternary operator
		 */
		
		int temp = 31;
		
		if (temp < 32) {
			System.out.println("It's too cold out!");
		} else {
			System.out.println("It's not too cold out...");
		}
		
		// ternary operator
		System.out.println((temp < 32) ? "COLD!" : "NOT COLD!" );
	
		
		// 
		int hungerLevel = 7;
		
		if (hungerLevel > 6) {
				
			System.out.println("Need food now!");
			
		} else if (hungerLevel >= 4 ) {
			System.out.println("I could snack");
		} else {
			System.out.println("Not hungry at all....");
		}
		
		
		do {
			System.out.println("In the do while loop");
		} while (false);
		
		int counter = 10;
		
		while (counter > 0) {
			// check if a condition is a true, THEN execute the code
			System.out.println(counter);
			counter --; // counter = counter -1; or counter -= 1;		
			// remmeber that -- only works for 1.
			// there's also counter++ or counter += 5
			
		}
		
		
		
		// Switch Case:
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of your birthday month");
		
		int monthNum = scan.nextInt();
		
		String month; // here we just declared, but depending on the month Num, we will intialize
		
		// here we begin the switch case statement
		
		switch(monthNum) {
		
		case 6:
			// we execute some code
			month = "June";
			break; // break statements are crucial 
		case 7:
			month = "July";
			break; // ctrl + / to auto comment if you want
		default:
			month = "Sorry lazy dev calendar doesn't include your birthday month";
			break;
		}
		
		System.out.println("You were born in " + month);
	
		
		// one more loop - for loop
		for (int i = 0; i < 10; i++) {
			System.out.println("i is equal to " + i);
		}
		
		System.out.println("Enter a word and I'll spell it out...");
		
		// in collections we'll work with enhanced for loop
		String word = scan.next();
		
		// use a for loop to loop through the word and print every letter on a new line....
		for (int i=0; i < word.length(); i++) {
			System.out.println(word.charAt(i));
		}
		

		
		System.out.println();

	}
	
	/**
	 * Shout out to Teresa
	 * @param monthNum
	 * @return
	 */
	static String bDayMonth(int monthNum) {
		
		switch(monthNum) {
		
		case 6:
			// we execute some code
			return "June";
			// break statements are crucial 
		case 7:
			return "July";
			// ctrl + / to auto comment if you want
		default:
			return "Sorry lazy dev calendar doesn't include your birthday month";
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
