package com.revature.garbagecollection;

import com.revature.models.Employee;

public final class GarbageDriver {
	
	/**
	 *  Final:
	 *  
	 *  variable: never change the variable
	 *  method: never override the method
	 *  class: never extend the class
	 */
	
	
	final static int neverChange = 9000;


	public static void main(String[] args) {
		
		// You cannot reassign b to any other object because it's decalred with final
		final Employee b = new Employee("Bob", 50, 94, 180, "Finance");
		
		// we can't change what object b refers to... can't do this!
//		b = new Employee(null, 54, 34 , 34, null);
		
		
		b.setAge(51);

		// can't do this!
//		neverChange = 10_000;
		
		
		
		
		
		System.out.println("Instantiating GarbageDriver object....");
		
		GarbageDriver gd = new GarbageDriver();
		// Currently the "gd" ref variable exists in the stack, and the object  exists in the heap
		
		System.out.println("GarbageDriver object successfully created");
				
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
	
				e.printStackTrace();
			} finally {
				System.out.println("Finally block is running!");
			}
		
		gd = null;
		
		/**
		 * Garbage Collection is nondeterministic meaning that we can encourgae it, but never fully guarantee it memory cleaning
		 */
		
		
		/**
		 * Every object that extends the java.lang.Object class has a special method called finalize()
		 * 
		 * when a object's finalize method is called, the object is removed from the heap....
		 */
		
		System.gc();

		for(;;) { 
			System.out.println("...");
		}
		
	}
	
	// What is the difference between final, finally and finalize()?
	
	@Override
	protected void finalize() {
		
		System.out.println("GarabageDriver's finalize method has been called!!!!!!!!");
		
		System.out.println("***********************************************");
		System.out.println("***********************************************");
		System.out.println("***********************************************");
		System.out.println("***********************************************");
		System.out.println("***********************************************");
		System.out.println("***********************************************");
		System.out.println("***********************************************");
		
		System.out.println("Goodbye!");
		
		System.exit(0);
		
		
	}
	

}
