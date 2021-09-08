package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.AccountDao;
import com.revature.repositories.IAccountDao;

public class AccountService {
	
	// Inject the dependency that Account Service needs to persist data
	public IAccountDao adao = new AccountDao();
	
	// create an openAccount method that will include a scanner and call  the accDao.insert() method
	
	private static Scanner scan = new Scanner(System.in);
	
	
	public Account openAccount(User u) {
		
		// it prompts the user to enter an initial deposit
		System.out.println("Please enter you intial deposit: \n");
		
		double deposit = scan.nextDouble();
		
		// it reads back to the user the deposit entered
		System.out.println("You deposited $" + deposit);
		
		// it creates a new account with the User's id as the accounts ownerId property....
		// it's totally ok if you create a separate constructor
		Account a  = new Account(0, deposit, u.getId());
		
		// then it calls the adao.insert() method to persist the account to the DB
		// make sure you grab the generated PK from the insert method
		int pk = adao.insert(a);
		
		// return the full account object (with it's generated PK as the id)
		a.setId(pk);
		
		return a;
	}
	
	
	public void viewAllAccountsByOwner(int ownerId) {
		
		for (Account a: adao.findByOwner(ownerId)) {
			
			System.out.println(a);
			
		}
		
	}
	
	public List<Account> findByOwner(int userId) {
		
		return adao.findByOwner(userId);
		
	}
	
	

}
