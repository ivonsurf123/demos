package com.revature.scopes;


/*
 * In Java there are 4 scopes
 * 
 * 1. Class Scope (Static/Global scope)
 * 2. Instance Scope (these are variables that belong to an object only)
 * 3. Method Scope
 * 4. Block Scope (You can nest these as much as you want)
 * 
 * The term "Field" refers to a static or instance scoped variable
 * The "Local Variable" referring to a method or block scope
 */
public class Driver {
	
	// String str = methodVar; // I can't access method scope from outside the method
	

	public static void main(String[] args) {
		
		
		// where we will instantiate MyClass objects
		
		MyClass mcObj = new MyClass();
		
		int x = MyClass.myStaticVar;
		
		double z = mcObj.myInstanceVar; // here we can access the field declared in the instance scope
		
		//static int j = 8; // you CANNOT declare static variables inside of a method
		
		
		// declare a variable on the method scope 
		int b = 5;
		
		while(b > 0) {
			
			// here we're declaring a variable within a block scope....(int result)
			int result = b * b;
			
				for (int i=result; i<100; i++) {
					// I can still access this
					int test = i * 9000;
					
				}
			System.out.println(result);
			//System.out.println(test); // you can't reach the nested block variable 
			
			b--;
		}
		
		// you CAN'T access a block scoped variable from outside of the block
		// System.out.println(result);
		

	}
	
	public void anotherMethod() {
		
		int y = MyClass.myStaticVar;
		
		MyClass mcObj = new MyClass();
		
		// you can't access another method's variable's within ANOTHER method
//		double w = mcObj.myInstanceVar; you can't do this
		
		String methodVar = "Hello";
		
	}

	
	
	
	
}
