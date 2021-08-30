package com.revature.abstraction;

public class Cellphone implements Callable{

	private int myNumber;
	private boolean isRinging;
	private boolean isOn;
	
	public Cellphone(int phoneNumber) {
		this.myNumber = phoneNumber;
		this.isOn = true;
	}

	@Override
	public void powerOn() {
		this.isOn = true;
		System.out.println("Cell phone powered up");
		
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
