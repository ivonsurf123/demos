package com.revature.strings;

public class Driver {
	
	public static void main(String[] args) {
		
		/**
		 * Strings are used to store a sequence of characters but they're treated as objects
		 * because they come from the String CLASS!
		 * 
		 * - (1). String Object created with the new keyword -> goes to the general heap
		 * - (2). String Literal created with "some sentance" -> goes to the String Pool INSIDE the heap
		 * 
		 */
		
		String stringObject = new String("straight to the general heap we go");
		System.out.println(stringObject);
		
		String stringLiteral = "straight to the string pool we go...";
		System.out.println(stringLiteral);
		
		String str1 = "Hello"; // JVM creates an object in the string pool
		 
		String str2 = "Hello"; // the JVM is checking does this same String Object already exist in the string pool?
		
		// .equals() checks for value...do they have the saem value
		System.out.println("Does  str1 have the same value as str2? " + str1.equals(str2)); // true
		
		// do they point to the same location in memory?
		System.out.println("Does str1 have the same mem location as str2? " + (str1 == str2));
		
		String strObj2 = new String("Hello"); // this exists OUTSIDE of the string pool! in the gen heap
		
		// does the string object instnaited with new point the same location in memory as str1 & str2?
		
		System.out.println("does the string object instnaited with new point the same location in memory as str1 & str2? " + (strObj2 == str1));
		
		String str3 = "Hello World"; // in the string pool~!!!
		
		String str4 = "Hello " + "World";
		
		System.out.println(str3 == str4); // this is because the + operator is smart...
		
		
		System.out.println("Hashcode of string literal str1: " + str1.hashCode());
		System.out.println("Hashcode of string literal strObj2: " + strObj2.hashCode());
		// even though they have the same object, they DON'T point to the same place in memory
		
		
		String str5 = "Hello ";
		
		String str6 = str5 + "World"; // is this going to gen heap or to string pool? this is equivelent to using the new keyword due to the immutablility of strings
		
		// to send something to the string pool, you call the intern() method
		
		System.out.println(str6 == str3);
		
		String str6inPool = str6.intern();
		
		System.out.println("has str6inPool successfully been sent to the string pool? " + (str6inPool == str3));
		
		
		/**
		 * The String API
		 * 
		 * tons of methods to perform ooperations on Strings
		 */
		
		String newStrObject = str6inPool.concat("something"); // creating a new String object in the general Heap NOT the string pool
		
		System.out.println(newStrObject);
		
		String test = "The brown fox jumped over the lazy dog";
		
		String chopped = test.substring(5);
		
		System.out.println(chopped); // returns that part of the string literal as an object
		
		/*
		 * indexOf()
		 * charAt()
		 * split()
		 * lenght()
		 * isEmpty()
		 */
		
		// StringBuffer and StringBuilder are mutable versions of the String Class
		// StringBuffer is threadsafe and slower than stringbuilder.
		
		StringBuilder sBuild = new StringBuilder("Hello");
		
		sBuild.append(" ");
		sBuild.append("World"); // modifying the same object! Can't do this with regular String objects....
		
		// you can take this StringBuilder object and send it to the String pool!
		System.out.println(sBuild);
		String myString = sBuild.toString(); // now it's sent OUTside of the string pool;
		System.out.println(myString);
		
		String sbInPool = myString.intern();
		
		System.out.println(str6inPool == myString); // false....
		System.out.println(sbInPool == str6inPool); // true because we have interned
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
