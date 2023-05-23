package com.solvd.flightreservation.user;

import java.util.HashMap;
import com.solvd.flightreservation.flight.Pilot;

public class PilotDetails extends Pilot {

	@Override
	public HashMap<String, String> getInfo()
	{
		HashMap<String, String> info = new HashMap<>();
		info.put("fist name", getFirstName());
		info.put("last name", getLastName());
		info.put("phone", Long.toString(getPhone()));
		info.put("id", getID());
		return info;
	}

}
