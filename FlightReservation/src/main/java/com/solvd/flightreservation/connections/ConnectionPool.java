package com.solvd.flightreservation.connections;

import java.util.List;
import java.util.ArrayList;

public class ConnectionPool {

	private static ConnectionPool instance;
	private static final int POOL_SIZE = 10;
	private List<Connection> pool;

	public ConnectionPool() {
		pool = new ArrayList<>();
		initializePool();

	}

	public List<Connection> getPool() {
		return pool;
	}

	public void setPool(List<Connection> pool) {
		this.pool = pool;
	}

	public static ConnectionPool getInstance()

	{
		if (instance == null)
			synchronized (ConnectionPool.class) {
				if (instance == null) {
					instance = new ConnectionPool();

				}
			}
		return instance;
	}

	private void initializePool() {
		for (int i = 0; i < POOL_SIZE; i++) {
			Connection connection = new Connection(i, "Connection " + i);
			pool.add(connection);
		}
	}

	public Connection getConnection() {
		Connection connection = null;
		synchronized (pool) {
			if (!pool.isEmpty()) {
				connection = pool.remove(0);
			}
		}
		return connection;
	}

	public void releaseConnection(Connection connection) {
		synchronized (pool) {
			pool.add(connection);
		}
	}

}
