package com.revature.abstraction;

public class Cat extends Animal{

	// thanks to abstraction, all # of legss, and color props are abstracted 
	private String breed;
	private boolean hasFur;
	
	
	@Override // Polymorphism!
	public void makeSound() {
		System.out.println("MEOW!");
	}

	public Cat() {
		super();
		System.out.println("Cat has been created!");
		this.hasFur = true;
	}

	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public boolean isHasFur() {
		return hasFur;
	}


	public void setHasFur(boolean hasFur) {
		this.hasFur = hasFur;
	}

	@Override
	public String toString() {
		return "Cat [breed=" + breed + ", hasFur=" + hasFur + "]";
	}
	
	// getters and setters
	
	
	

}
