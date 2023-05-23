package com.solvd.flightreservation.connections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
	
	private static final Logger LOGGER = LogManager.getLogger(Connection.class);


	private int connectionId;
	private String name;
	

	public Connection(int connectionId, String name) {
		super();
		this.connectionId = connectionId;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void executeQuery(String query)
	{
		LOGGER.info("Executing query "+ query +" on connection "+ connectionId);
	}
}
