package com.revature.abstraction;

// this is bad practice don't do this.  I'm showing you why we need interfaces
public class GearBox {

	private boolean clutchIsIn;

	
	
	// An dinterface is a contract specifying that the method signatures will not change!
	public void operateClutch(boolean inOrOut) {
		this.clutchIsIn = inOrOut;
	}
	
	
	// in or they pass in out
//	public void operateClutch(String inOrOut) {
//		
//		this.clutchIsIn = inOrOut.equalsIgnoreCase("in");
//		
//	}
	
	
	
	
}
