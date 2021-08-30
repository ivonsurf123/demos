package com.revature.serialization;

public class Driver {

	public static void main(String[] args) {
	
		
		// instantiate PetStore objects
		PetStore petco = new PetStore();
		PetStore petsmart = new PetStore();
		
		// 2 ways to add a Pet object to petco's petDB.
		
		// 1) First we instantiate the object, then we add it to the Collection
//		Pet p1 = new Pet("Finn", 1004, "Cat", "Jerry", 4, Color.GREY);
//		
//		petco.petDB.add(p1);
//		
//		
//		// 2) immediately call the collection and add AND instnatitate the object at the same time
//		petco.petDB.add(new Pet("Spot", 3002, "Dog", "Larry", 10, Color.BROWN));
//		
//		System.out.println("Below is our ArrayList of Pets from the petco petDB");
//		
//		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
//		
//		// enhanced for loop
//		for (Pet p : petco.petDB) {
//			
//			System.out.println(p.getName());
//			
//		}
//		
//		// serialize my entire petco 
//		
//		petco.serialize();
		
		petsmart.deserialize();
		
		for (Pet newPet : petsmart.getPetDB()) {
			
			System.out.println("The newly deserialized pet is...");
			System.out.println(newPet);
			
		}

	}

}
