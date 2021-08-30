package com.revature.abstraction;

public interface Callable {
	
	
	// all methods are inherently public and abstract
	void powerOn();
	void dial(int phoneNumber);
	boolean callPhone(int phoneNumber);
	boolean isRinging();
	
}
