package com.solvd.flightreservation.type;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.flightreservation.exceptions.UnavailableSeatException;
import com.solvd.flightreservation.flight.Flight;
import com.solvd.flightreservation.interfaces.Calculateprice;
import com.solvd.flightreservation.interfaces.FlightReservation;
import com.solvd.flightreservation.interfaces.SeatType;

public class BusinessClassReservation implements FlightReservation, Calculateprice, SeatType {

	private static final Logger LOGGER = LogManager.getLogger(BusinessClassReservation.class);
	private Flight flight;
	private int reservationNumber;

	public BusinessClassReservation(Flight flight) {
		this.flight = flight;
		this.reservationNumber = generateReservationNumber();
	}

	@Override
	public void reserveSeat() {
		if (flight.checkAvailability()) {
			flight.bookSeat();
			LOGGER.info("Seat booked successfully!");
		} else {

			LOGGER.error("Sorry, no seats available on this flight.");
			throw new UnavailableSeatException("Unavailabilty of seat  ");
		}
	}

	@Override
	public void displayReservationDetails() {
		LOGGER.info("Reservation Number: " + reservationNumber);
		flight.displayFlightDetails();
	}

	private int generateReservationNumber() {
		return 67890;
	}

	@Override
	public double calculateTicketPrice() {
		return flight.getFare() * 1.2;
	}

	public void showSeatType() {
		LOGGER.info("Business Class is with Window seat");
	}
}
