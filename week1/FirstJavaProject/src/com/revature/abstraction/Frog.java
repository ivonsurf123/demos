package com.revature.abstraction;

// concrete classes
// Java does NOT support multiinheritance, meaning I can only extend ONE class
public class Frog extends Animal implements Ectothermic, Amphibious{

	@Override
	public void makeSound() {
		System.out.println("ribbit ribbit");
		
	}
	
	// polymorphism - overloading the above method
	public void makeSound(int times) {
		
		for (int i = 0; i<=times; i++) {
			System.out.println("ribbit..");
		}
		
	}

	@Override
	public void heatUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coolDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}
	

}
