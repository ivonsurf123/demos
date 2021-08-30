package com.revature.otherpackage;

import com.revature.accessmods.Driver1;

public class Driver3 extends Driver1{ // by extending we are inheriting the properties (fields) & behaviors of the parent Class
	
	Driver1 d1 = new Driver1();
	
	int i = publicField; // this already exists because we're inheriting it from Driver 1
	
	// int j = d3.defaultField; we can't inherit that because it's default
	
	
	Driver3 d3 = new Driver3();
	
 	int k = protectedField; // this field is inherited automatically from Driver1

}
