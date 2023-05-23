package com.solvd.flightreservation.flight;

import java.util.HashMap;

public abstract class Pilot {
	private HashMap<String, Flight> flights;
	private String firstName;
	private String lastName;
	private long phone;
	private String ID;

	public Pilot(HashMap<String, Flight> flights, String firstName, String lastName, long phone, String iD) {
		super();
		this.flights = flights;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		ID = iD;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public HashMap<String, Flight> getFlights() {
		return flights;
	}

	public void setFlights(HashMap<String, Flight> flights) {
		this.flights = flights;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Pilot() {
		this.flights = new HashMap<String, Flight>();
	}

	public void addFlight(Flight flight) {
		flights.put(flight.getFlightNumber(), flight);
	}

	public Flight getFlight(String flightNumber) {
		return flights.get(flightNumber);
	}

	public abstract HashMap<String, String> getInfo();
}
