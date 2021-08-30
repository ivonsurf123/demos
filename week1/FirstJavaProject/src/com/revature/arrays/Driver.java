package com.revature.arrays;

import java.util.Arrays;

public class Driver {
	
	/*
	 * Arrays are container objects which contain elements of ONE type
	 * 
	 * Arrays are static collections meaning that they can't change size
	 * 
	 * (1) declare the data type that it can hold
	 * (2) intialize its capacity
	 * 
	 */
	
	public static void main(String[] args) {
	
		int size = 10;
		
		int[] numbers = new int[size]; // default of an int array is 0
		
		String[] words; // step 1
		words = new String[4]; // step 2
		
		byte[] bytes;
		char[] letters;
		Object[] objects;		

		
		System.out.println(numbers);
		
		System.out.println(Arrays.toString(numbers)); // this is how you properly see what's happening
		
		numbers[0] = 10;
		numbers[2] = 30;
		
		// we want to set every value of the numbers array == to 10 * its index + 1
		for (int i=0; i<numbers.length; i++) {
			
			numbers[i] = (i+1) * 10;
			
		}
		
		System.out.println(Arrays.toString(numbers));
		
		// enhanced for-loop
		for (int n : numbers) {
			System.out.println(n);
		}
		
		String[] fruit = {"orange", "apple", "fig"};
		
		System.out.println(Arrays.toString(fruit));
		Arrays.sort(fruit); // sorts in ascending order
		System.out.println(Arrays.toString(fruit));
		
	}
	
	

	
	
	
	
	
}
