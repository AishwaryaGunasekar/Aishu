package com.solvd.flightreservation.interfaces;

import com.solvd.flightreservation.enums.CabinClass;
import com.solvd.flightreservation.flight.IFlight;

@FunctionalInterface
public interface IFareCalculator {
    int calculateFare(IFlight flight, CabinClass cabinClass, int numPassengers);
}
