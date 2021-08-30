package com.revature.util;

import com.revature.exceptions.NotAGradeException;
import com.revature.models.Student;

// all this class is is a place for useful methods
public class UtilityMethods {

	/**
	 * https://stackabuse.com/how-to-make-custom-exceptions-in-java/
	 * 
	 * @param gradeYear
	 * @throws NotAGradeException
	 */
	public static void validateGradeYear(int gradeYear) throws NotAGradeException{
		
		if (gradeYear <= 0 || gradeYear > 4) {
			throw new NotAGradeException("Please enter a valid grade number between 1 and 4");
		}
	}
	
	
	public static void printStudentInfo(Student[] arr) {
		
		for (Student s : arr) {
			s.showStatus();
		}
		
	}
	
}
