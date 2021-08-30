package com.revature.abstraction;

public interface Ectothermic {
	
	// all attributes (fields) of an interface are by default PUBLIC, STATIC, and FINAL
	public static final int MIN_BODY_TEMP = -40;
	public static final int MAX_BODY_TEMP = 90;
	
	// by default all methods within in an interface are abstract and public
	void heatUp();
	
	void coolDown();
	
	// there are also default methods, which we'll talk about -> in Java 7?
	default void saySomething() {
		
		System.out.println("something is being said from the default method in the interface");
		
	}
	
}
