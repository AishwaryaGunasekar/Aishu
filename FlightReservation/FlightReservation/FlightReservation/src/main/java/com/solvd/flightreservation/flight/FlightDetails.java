package com.solvd.flightreservation.flight;

import java.util.ArrayList;
import java.util.List;

import com.solvd.flightreservation.interfaces.IFlightSearch;

public  class FlightDetails {

	public static final String CAPACITY = "200";

	private String flightNo;
	private String flightName;
	private String source;
	private String destination;
	private String fare;
	private String duration;
	private String stops;
private int availableseat;
	
	
	public int getAvailableseat() {
	return availableseat;
}

public void setAvailableseat(int availableseat) {
	this.availableseat = availableseat;
}

	public FlightDetails() {

	}

	public FlightDetails(String flightNo, String flightName, String source, String destination, String fare,
			String duration, String stops) {
		super();
		this.flightNo = flightNo;
		this.flightName = flightName;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
		this.duration = duration;
		this.stops = stops;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStops() {
		return stops;
	}

	public void setStops(String stops) {
		this.stops = stops;
	}

	public static String getCapacity() {
		return CAPACITY;
	}

	public final List<StringBuilder> getFlightDetails(SearchFlights flight, List<FlightDetails> fdList) {

		List<StringBuilder> sbList = new ArrayList<>();
		for (FlightDetails fd : fdList) {
			StringBuilder sb = new StringBuilder();
			sb.append("Flight code :" + fd.getFlightNo() + "\n");
			sb.append("Flight Number: " + fd.getFlightName() + "\n");

			sb.append("Source: " + flight.getSource() + "\n");
			sb.append("Destination: " + flight.getDestination() + "\n");
			sb.append("Capacity: " + CAPACITY + "\n");
			sb.append("Booked Seats: " + flight.getBookedSeats() + "\n");
			sb.append("Fare: " + fd.getFare() + "\n");
			sbList.add(sb);

		}
		return sbList;
	}

	
	@Override
	public String toString() {
		return "FlightDetails [flightNo=" + flightNo + ", flightName=" + flightName + ", source=" + source
				+ ", destination=" + destination + ", fare=" + fare + ", duration=" + duration + ", stops=" + stops
				+ "]";
	}

}
