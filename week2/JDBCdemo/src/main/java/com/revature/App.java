package com.revature;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;

public class App {


	public static void main(String[] args) {
		
		menu();
		
	}
	
	public static void menu() {
		
		UserService userv = new UserService();
		AccountService aserv = new AccountService();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome! If you are a Customer please press 1. \n If you would like to login please press 2.");
		
		// in your application think about the things that can go wrong here! 
		// for example, what if a user puts in abc instead of a number?
		int input = scan.nextInt();
		
		
		if (input == 1) {
			
			// create a new User....
			System.out.println("Enter your username");
			String username = scan.next();
			
			System.out.println("Enter your password");
			String password = scan.next();
			
			// We're going to pretend that ALL users created are customers...
			User u = new User(username, password, Role.CUSTOMER, new ArrayList<Account>()); // add a Constructor to User.java
			
			// our register method returns a User with a generated primary key as its ID
			u = userv.register(u);
			
			System.out.println("Would you like to open an account? Y/N");
			
			String yesOrNo = scan.next();
			
			if (yesOrNo.equalsIgnoreCase("y")) {
				
				
				for (int i=0; i<2; i++) {
					// this whole chunk of code will run 2 times
					System.out.println("Opening account #" + i+1);
					aserv.openAccount(u); // The User I pas through represent the user whose userId will be the ownerId of the accounts created
					
				}	
				
				aserv.viewAllAccountsByOwner(u.getId());
			}
			


		} else {
			System.out.println("Goodbye!");
			System.exit(0);
			// call some method like userv.login()
			
			// whatever functionality that login() method provides...
			
		}

	}

}
