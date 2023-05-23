package com.solvd.flightreservation.connections;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {
	
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		ConnectionPool connectionPool = ConnectionPool.getInstance();

		Runnable executeQueryTask = () -> {
			Connection connection = connectionPool.getConnection();
			if (connection != null) {
				connection.executeQuery("SELECT * FROM flight");
				connectionPool.releaseConnection(connection);
			}
		};

		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(executeQueryTask);
			threads.add(thread);
			thread.start();
		}

		
		threads.stream().forEach(thread ->{
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		
		// Print names of connections stored in the connection pool
		
		for (Connection connection : connectionPool.getPool()) {
			LOGGER.info(connection.getName());
		}
	}
}



