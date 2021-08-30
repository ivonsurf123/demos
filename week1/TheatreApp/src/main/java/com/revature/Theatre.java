package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

	private final String theatreName; // we will initialize it inside of the constructor
	private List<Seat> seats = new ArrayList<>();


	/**
	 * ArrayList: Best for SEARCHING: takes O(1) and adding
	 * Worst for inserting elements: takes O(n) time [worst case]
	 * 
	 * Never used Arraylist when you have to do lot of insertion and deletion as
	 * this will force arraylist to adjust the elements.
	 * 
	 * ==========================================================================
	 * 
	 * LinkedList: data structure made of a chain of nodes in which each node
	 * contains a value and a pointer to the next node in the chain.
	 * 
	 * Best for: INSERTION O(1) time 
	 * Worst for: SEARCHING Accessing an element also
	 * takes O(1) time, but LinkedList uses more memory than ArrayList.
	 * 
	 * Insertion and deletion of nodes are really easier. Unlike array here we don’t
	 * have to shift elements after insertion or deletion of an element. In linked
	 * list we just have to update the address present in next pointer of a node.
	 * 
	 */

	public Theatre(String theatreName, int numRows, int seatsPerRow) {

		this.theatreName = theatreName;

		int lastRow = 'A' + (numRows - 1);

		for (char row = 'A'; row <= lastRow; row++) {

			// nested for loop for each row, to make seats for each row
			for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {

				Seat seat = new Seat(row + String.format("%02d", seatNum));

				seats.add(seat);
			}
		}
	}

	public String getTheatreName() {
		return theatreName;

	}

	public void getSeats() {

		for (Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}

	// BRUTE FORCE ALGORITHM - I will check every single seat to check if it's the
	// one that I want to reserve --> This is O(n) time.
	public boolean reserveSeat(String seatNumber) { // someone could enter in Z119

		Seat requestedSeat = null;

		for (Seat seat : seats) {

			System.out.println(".");

			if (seat.getSeatNumber().equals(seatNumber)) {
				requestedSeat = seat;
				break;
			}

		}

		if (requestedSeat == null) {
			System.out.println("There is no seat " + seatNumber);
			return false;
		}

		return requestedSeat.reserve(); // we will build this particular method on the Seat class! to r

	}

	// Be sure to add comparable interface to Seat class...
	public boolean reserveSeatBinary(String seatNumber) {

		int low = 0;
		int high = seats.size() - 1;

		while (low <= high) {

			System.out.print(".");

			// select the MIDDLE num!
			int mid = (low + high) / 2;

			// Use that middle number to get the middle seat of that row
			Seat midVal = seats.get(mid);

			// returns 0 if equal, returns -1 if less than, returns 1 if greater than
			int cmp = midVal.getSeatNumber().compareTo(seatNumber);

			// here we discard an entire half of the row

			// _0_ _1_ _2_ _3_ _4_ _5_ _6_ _7_ _8_ _9_ _10_
			if (cmp < 0) {
				low = mid + 1;
			} else if (cmp > 0) {
				high = mid - 1;
			} else {
				return seats.get(mid).reserve();
			}
		}

		// in the case that the seat doesn't exist
		System.out.println("There is no seat " + seatNumber);
		return false;
	}

	/*
	 * Java Comparable interface is used to order the objects of the user-defined
	 * class. This interface is found in java. lang package and contains only one
	 * method named compareTo(Object).
	 * 
	 * It provides a single sorting sequence only, // if we want to add more sorting
	 * sequences, we use Comparator i.e., you can sort the elements on the basis of
	 * single data member only.
	 */

	private class Seat implements Comparable<Seat> {
		/**
		 * Nesting classes ... is a way of logically grouping classes that are only used in one place: If
		 * a class is useful to only one other class, then it is logical to embed it in
		 * that class and keep the two together. Nesting such "helper classes" makes
		 * their package more streamlined.
		 * 
		 * It increases encapsulation: Consider two top-level classes, A and B, where B
		 * needs access to members of A that would otherwise be declared private. By
		 * hiding class B within class A, A's members can be declared private and B can
		 * access them. In addition, B itself can be hidden from the outside world.
		 * 
		 * It can lead to more readable and maintainable code: Nesting small classes
		 * within top-level classes places the code closer to where it is used.
		 */

		private final String seatNumber; // A11 - G11, etc..
		private boolean reserved = false;

		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public boolean reserve() {

			if (!this.reserved) {

				this.reserved = true;

				System.out.println("Reservation of seat " + seatNumber + " reserved.");

				return true;
			} else {
				return false;
			}
		}

		// This is how we define if a seat is greater than or less than another
		@Override
		public int compareTo(Seat seat) {

			// We're using the seatNumber field as what we use to classify a greater or
			// lesser seat
			return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		}

	}

}