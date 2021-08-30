package com.revature.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		int x = 10;
//		int y = 0;
		
		
		int result = divideTryCatch(); // this is our new method
		
		System.out.println(result);

		System.out.println("I finally reached this line  code!");
		
	}
	
	
	// Polymorphism! Using the same method but OVERLOADING it --> you change the amount of its arguments or the type of its arguments
	static int divideTryCatch() { // not taking in ANY arguments 
		
		try {
			// prompt the user to enter a number
			System.out.println("Please enter a number:");
			int x = scan.nextInt(); // go above and instantiate a scanner obj make it private and static
			
			System.out.println("Enter a number to divide by...");
			int y = scan.nextInt();
			
			return x/y;
		} catch (ArithmeticException e) {
			System.out.println("You can't divide by zero!!!");
			return 0;
		} catch (InputMismatchException ex) {
			System.out.println("Please enter a valid number.");
			return 0;
			
		} finally {
			// whether we run into issues or not, we still want to close our scanner.
			scan.close();
		}
		
		
		
		
		
	}
	
	
	
	static int divide(int x, int y) {
		
		return (x / y);
		
	}

	
	// I want to safe-guard my code so that it doesn't crash! To handle exceptions you use try/catch blocks
	static int divideTryCatch(int x, int y) {
		
		try {
			return x/y;
		} catch (ArithmeticException e) {
			// this block of code with run if we encounter an arithmetic exception!!!
			System.out.println("You can't divide by zero!!!!");
			System.out.println(e.getStackTrace());
			return 0;
		} finally {
			// this block of code will ALWAYS execute no matter what -- typically we use this if we want to close resource
			System.out.println("In the finally block ");
		}
		
	}
	
	static void createFileCheckedExceptionDemo(String path, String text) {
		
		
		// Checked Exceptions always force you to handle the possible issue at compile time
		FileWriter writer;
		
		try {
			writer = new FileWriter(path, true); // this is where the code could be intercepted.
			writer.write(text);
			writer.close();
		} catch (IOException e) { // this is a CHECKED exception. Our compiler detects that something COULD go wrong at compile time, so it
			// forces us to handle it.
			e.printStackTrace();
		} 
		
		// Try With Resources
//		try (/**The object you're using to access a resource*/) { 
//			
//			// run some code here
//			
//		} catch (IOException e) {
//			// code to execute when you recover
//		}
		
	}
	
	
	
	
	
	
	
}
