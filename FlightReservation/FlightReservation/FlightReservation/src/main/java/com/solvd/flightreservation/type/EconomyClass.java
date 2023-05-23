
package com.solvd.flightreservation.type;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.flightreservation.flight.Flight;
import com.solvd.flightreservation.utilities.MyLinkedList;

public class EconomyClass extends Flight {
	private static final Logger LOGGER = LogManager.getLogger(EconomyClass.class);
	private double baseFare;

	
	public EconomyClass() {
	}
	public EconomyClass(String flightNumber, String airline, String source, String destination, int capacity,
			double baseFare, int bookedSeats) {
		super(flightNumber, airline, source, destination, capacity, bookedSeats);
		this.baseFare = baseFare;

	}

	@Override
	public double getFare() {
		return baseFare;
	}

	@Override
	public void displayFlightDetails() {
		LOGGER.info("Flight Number: " + getFlightNumber());
		LOGGER.info("Airline: " + getAirline());
		LOGGER.info("Source: " + getSource());
		LOGGER.info("Destination: " + getDestination());
		LOGGER.info("Capacity: " + getCapacity());
		LOGGER.info("Booked Seats: " + getBookedSeats());
		LOGGER.info("Fare: " + getFare());
	}

	@Override
	public MyLinkedList<String> getFullMealDetails() {
		MyLinkedList<String> mealdetails = new MyLinkedList<String>();
		mealdetails.add(getMeal());
		return mealdetails;
	}

}