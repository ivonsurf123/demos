package com.revature;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.revature.model.Employee;

public class PredicateDriver {
	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Employee zayn = new Employee("Zayn Smith", 40);
		Employee mary = new Employee("Mary Shelly", 60);
		Employee abby = new Employee("Abby McCormick", 30);
		Employee xavier = new Employee("Xavier Hall", 25);
		
		employees.add(zayn);
		employees.add(mary);
		employees.add(abby);
		employees.add(xavier);
		
		// first with anonymous class
		printEmployeesByAge(employees, "All Employees under 50", new Predicate<Employee>() {

			@Override
			public boolean test(Employee e) {

				return e.getAge() < 50;
			}
		});
		
		System.out.println("==========================================");
		
		// passing a predicate with a lambda
		printEmployeesByAge(employees, "All Employees over 30", e -> e.getAge() > 30);
		
		printEmployeesByAge(employees, "All Employees in 1 year over 30", e -> {
			
			// this is just an example of a multiline lambda
			int extraYear = 1;
			return (e.getAge() + extraYear) > 30;
			
		});
		
		/*
		 * Primitive functional Interfaces. Predefine Predicates for specific data types
		 */
		
		IntPredicate greaterThan15 = (i) -> i > 15; // we don't need parenthesis if there is only 1 parameter, but it's ok if we have them
		System.out.println("Is 10 greater than 15? : " + greaterThan15.test(10));
		// https://www.benchresources.net/java-8-primitive-predicate-functional-interface/
		
		
		System.out.println("======== PREDICATE CHAINING =========");

		
		IntPredicate lessThan100 = i -> i< 100;
		System.out.println(greaterThan15.and(lessThan100).test(78));		
		
		// All sorts of primitive functional interfaces
		DoublePredicate accountOverdrawm = i -> i<0;
		
		/**
		 * Iterable: root interface of the collections hierarchy
		 * 
		 * Iterator is an object we use to iterate over a data structure.
		 */
		
		Iterator<Employee> it = employees.iterator();
		System.out.println(it.next());
	}
	
	
	private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
		
		// This represents the conditions by which we're sorting the employees by their age
		System.out.println(ageText);
		
		
		employees.forEach((e) -> {
			
			if (ageCondition.test(e) ) {
				
				System.out.println(e.getName() + " is " + e.getAge() + " years old.");
			}	
		});
		
		
		// LOOK INTO SUPPLIER INTERFACE 
		// https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html
				
		
	}

}
