package com.revature.abstraction;

public class Deskphone implements Callable{
	
	// it would be a good design deciusion to delegate these shared fields to an abstract class...NOT an interface because
	// all fields within an interface are public static and final.
	private int myNumber;
	private boolean isRinging;
	
	/**
	 * CHALLENGE: take the above properties of both this class and the Cellphone class
	 * and create an ABSTRACT class
	 * 
	 * @param myNumber
	 */
	
	public Deskphone (int myNumber) {
		super();
		this.myNumber = myNumber;
		
	}

	@Override
	public void powerOn() {
		System.out.println("No action taken, already plugged in");
		
	}

	@Override
	public void dial(int phoneNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean callPhone(int phoneNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRinging() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
