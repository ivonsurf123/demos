package com.revature.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.exceptions.NotAGradeException;
import com.revature.models.Course;
import com.revature.models.Student;
import com.revature.util.UtilityMethods;

public class StudentTests {
	
	
	// declare some reference variables to point to soon to be instantiated objects
	static Student dummyStudent;
	static Course c1;
	static Course c2;
	static ArrayList<Course> courses;
	
	@Before
	public void setUp() {
		
		courses = new ArrayList<Course>();
		
		c1 = new Course("Math 101");
		c2 = new Course("History 400");
		
		courses.add(c1);
		courses.add(c2);
		
	}
	
	@After
	public void tearDown() {
		
		// make previously instantiated objects null so that they're garbage collected
		c1 = null;
		c2 = null;
		courses = null;
		
		dummyStudent = null;
		
	}
	
	@Test
	public void whenInstantiateStudent_thenIncrementStaticId() {
		
		dummyStudent = new Student("John", "Doe", 4);
		
		// here we see that we need to create a getter for this student's ID.
		String actualId = dummyStudent.getStudentId();
		
		String expectedId = "41001";
	
		// use assert equals
		assertEquals(expectedId, actualId);
	}
	
	
	// we need to test custom exceptions as well!
	@Test(expected=NotAGradeException.class)
	public void badGradeYearThrowsANotAGradeException() {
		
		int badGradeYear = 7;
		
		UtilityMethods.validateGradeYear(badGradeYear);
	}
	
	/*
	 * Test Driven Development is when we write a test after writing the method
	 * 
	 * 1 assertion per test
	 */
	
	// Create a test that checks that a NEGATIVE grade throws the NotAGrade Exception
	
	// Create a test that checks that InputMismatchException is thrown for a particular method.
	
	
	
	
	
	
	

}
