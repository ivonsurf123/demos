package com.revature.abstraction;

/**
 * Abstraction is the process of hiding certain details and showing only essential information to the user.
 * 
 * This is achieved with interfaces and abstract classes in Java. You can't instantiate either an abstract class OR an interface.
 *
 */

public class Driver {
	
	public static void main(String[] args) {
		
		// Animal is my reference type...
		Animal a1 = new Cat(); 
		
		// I can now reassign this variable to any other object whose class extends Animal
		
		a1 = new Frog();
		
		
		
	}

}
