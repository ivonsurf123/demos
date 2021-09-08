package com.revature.controlflow;

import java.util.Scanner;

public class GradeCalcChallenge {

	public static void main(String[] args) {
		/*
		 * =======================================================
		 * ========= GRADING CALCULATOR CHALLENGE ================
		 * ================== 30 min =============================
		 * =======================================================
		 * 
		 * The GradingCalc does the following: 
		 * 
		 * 1. Prompt the user to enter the total amount of points on the quiz -> save it to a variable.
		 * 
		 * 					====== HINT =======
		 * 					=== USE DOUBLES ===
		 * 					====...but WHY? ===
		 * 		
		 * 2. Prompt the user the enter the amount of points the student got right on the quiz -> save to a variable.
		 * 
		 * 3. Calculate the student's letter grade:
		 * 		
		 * 		-> ((amount of points right) / (total score)) * 100 
		 * 	
		 * 		A 90 -100
		 * 		B 80 -89
		 * 		C 70-79
		 * 		D 60-69
		 * 		F 0-59
		 * 
		 * 4. Return the following message to the user: 
		 * 
		 * 		"The Student's Letter grade is ___. That's ___ % !" 
		 * 	
		 * 		~ For example
		 * 
		 * 		Student scores 15 out of 20 -> 75% -> C
		 * 		"The Student's Letter grade is C. That's 75% !" 
		 */
		
		/*
		 *  Bonus:
		 *  
		 *   + Create a custom method to perform the percent calculation within the GradeCalcChallenge Class, but outside of the main method. 
		 *   	+ It should be public, static, and its return type should be double.  
		 *   	+ It should take in 2 parameters, a maxPoints and score, both of type double.
		 *   
		 *   + Format the double that it returns so that I don't see the trailing 0's.  (You can do this in a lot of ways).
		 *   
		 */
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter percentage marks");
		double percentage = scan.nextDouble();

		if(percentage >= 90){
			System.out.println("Excellent: Grade A");
		}else if(percentage < 90 && percentage >= 80){
			System.out.println("Very Good: Grade B");
		}else if(percentage < 80 && percentage >= 70){
			System.out.println("Good: Grade C");
		}else if(percentage < 70 && percentage >= 60){
			System.out.println("Satisfactory: Grade D");
		}else if(percentage < 60 && percentage >= 50){
			System.out.println("Work Hard: Grade E");
		}else if(percentage < 50 && percentage >= 40){
			System.out.println("Just Passed: Grade F");
		}else {
			System.out.println("Failed!");
		}
	
	   

	}

}

