package com.solvd.flightreservation.type;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.flightreservation.exceptions.ReservationNotFoundException;
import com.solvd.flightreservation.flight.Flight;
import com.solvd.flightreservation.interfaces.Calculateprice;
import com.solvd.flightreservation.interfaces.FlightReservation;
import com.solvd.flightreservation.interfaces.SeatType;

public class EconomyClassReservation implements FlightReservation, Calculateprice, SeatType {

	private static final Logger LOGGER = LogManager.getLogger(EconomyClassReservation.class);
	private Flight flight;
	private int reservationNumber;

	public EconomyClassReservation(Flight flight) {
		this.flight = flight;
		this.reservationNumber = generateReservationNumber();
	}

	@Override
	public void reserveSeat() {
		if (flight.checkAvailability()) {
			flight.bookSeat();
			LOGGER.info("Seat booked successfully!");
		} else {
			LOGGER.info("Sorry, no seats available on this flight");
			throw new ReservationNotFoundException("Unavailabilty of seat  ");
		}
	}

	@Override
	public void displayReservationDetails() {
		LOGGER.info("Reservation Number: " + reservationNumber);
		flight.displayFlightDetails();
	}

	private int generateReservationNumber() {

		return reservationNumber;
	}

	@Override
	public double calculateTicketPrice() {
		return flight.getFare() * 0.8;
	}

	@Override
	public void showSeatType() {
		LOGGER.info("Aisle");

	}
}
