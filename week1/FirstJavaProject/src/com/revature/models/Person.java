package com.revature.models;

import java.io.Serializable;

// Our custom class inherits from the java.lang.Object
/*
 * 
 * This is a class! It is a template for an object!
 * You can only declare ONE public class per file
 * 
 
 */
public class Person {
	
	// STATIC means that this variable is accessible on a Class level...Person.MAX_AGE to call it
	public static final int MAX_AGE = 115;
	
	// Instance variables (notice that they are NOT static)
	private String name;
	private int age;
	private double height;
	private double weight;

	public Person() {
		// this is a no-args constructor (which the dev has made explicitly)
		
	}
	
	public Person(String name) {
		super(); // super() calls the parent constructor.  (In this case it's object, which is ALWAYS called whether we state it or not)
		this.name = name;
	}
	
	public Person(String name, int age, double height, double weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}


	public double calculateBMI() {
		
		return (this.weight/this.height/this.height)*703 ;
		
	}
	


	// getters & setters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}


	// Here we are overriding a method that we inherit from the Object class
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}
	
	
	

}

// you can have another class in the same file as long as its not public!
class House {

	
}
