package big_project.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

// data access object
public class ConnectionPool {
	private static ConnectionPool instance = new ConnectionPool();
	// static - only one
	private ArrayList<Connection> connections = new ArrayList<Connection>();
	private static final int MAX_CONNECTIONS = 10;
	// final - unchangeable

	private ConnectionPool() {// singleton class
		// init the ConnectionPool
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			for (int i = 0; i < MAX_CONNECTIONS; i++) {
				connections.add(DriverManager.getConnection("jdbc:mysql://localhost:3306/project?serverTimezone=UTC",
						"root", "1234"));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("cannot find class: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("error connecting to DB: " + e.getMessage());
		}
	}

	public synchronized Connection getConnection() {
		while (connections.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection con = connections.get(0);
		connections.remove(0);
		return con;
	}

	public synchronized void restoreConnection(Connection connection) {
		connections.add(connection);
		notify(); // wake up the waiting thread// from wait();
	}

	public static ConnectionPool getInstance() {
		return instance;
	}
	public void closeAllConnections() {
		for (Connection connection : connections) {
			try {
				connection.close();
			} catch (SQLException e) {}
		}
	}
}
