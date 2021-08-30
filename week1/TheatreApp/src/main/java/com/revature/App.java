package com.revature;

public class App {

	public static void main(String[] args) {
		
		Theatre theatre = new Theatre("Ford's Theatre", 8, 12);
		
		theatre.getSeats();
		
		if (theatre.reserveSeatBinary("G11")) { // O(log n) -- logarithmic time because of Binary Search
			System.out.println("Please pay to reserve this free seat");
			
		} else {
			System.out.println("the seat is reserved, sorry");
		}
		
		
	}

}
