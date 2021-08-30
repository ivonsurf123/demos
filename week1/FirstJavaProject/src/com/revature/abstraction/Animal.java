package com.revature.abstraction;

public abstract class Animal {
	
	/*
	 * An abstract class canNOT be instantiated
	 */
	
	private int legs;
	private String color;
	
	public Animal() {
		
		System.out.println("Animal constructor is called!");
		
	}
	
	
	// abstract methods are methods that have no body and  are meant to be inherited and implemented
	public abstract void makeSound();
	
	public void exist() {
		
		System.out.println("The animal is existing");
		
	}

}
