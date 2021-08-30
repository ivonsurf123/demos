package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.exceptions.NotAGradeException;
import com.revature.models.Student;
import com.revature.util.UtilityMethods;

public class Driver {

	// ctrl + shift + o is short cut to import!
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		run();

	}

	public static void run() {

		// Step 1. prompt the user how many students to enter
		System.out.println("Enter the number of students you want to enroll: ");

		// get the capacity for an array of Student objects
		int numOfStudents = scan.nextInt();

		Student[] students = new Student[numOfStudents];

		// iterate over the array and for each object, we prompt the user for all object
		// details
		for (int i = 0; i < numOfStudents; i++) {

			// Step 2. as we create those students, the user is prompted
			// to enter the properties of the student

			System.out.println("Enter the student's first name");
			String firstName = scan.next();

			System.out.println("Enter the student's last name");
			String lastName = scan.next();

			System.out.println("Enter the student's grade year:\n1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior");

			int gradeYear = 0;
			boolean isValidInput = false;
			
			while (!isValidInput) {

				try {
					gradeYear = scan.nextInt();
					UtilityMethods.validateGradeYear(gradeYear);
					
					// anything right here WON'T be hit if I encounter any of these exceptions...
					isValidInput = true;
				} catch (NotAGradeException e) {
					System.out.println(e.getMessage());
				} catch (InputMismatchException ex) {
					System.out.println("Just encountered a " + ex + ". Please enter a valid number between 1 - 4.");
				} finally {
					scan.nextLine();
				}
				
			}

			students[i] = new Student(firstName, lastName, gradeYear);
			
			students[i].enroll();


		}

		// ctrl + forward slash to comment over all of it

		UtilityMethods.printStudentInfo(students);

	}

}
