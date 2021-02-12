package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ConnectionPool {
	// static - only one
	private ArrayList<Connection> connections = new ArrayList<Connection>();
//	private static final int MAX_CONNECTIONS = 10;
	// final - unchangeable
	@Autowired // creates instance of env if it doesn't exist .... ctx.getbean()
	private Environment env; // reads file creates hashmap - key-value
	public ConnectionPool() {// singleton class
		// init the ConnectionPool
		try {// getRequiredProperty - throw exception if not found 
			// instead of getProperty that just returns null or default value
			Class.forName(env.getProperty("db1_driver"));
			// Integer.class to interpet value as integer
			for (int i = 0; i < env.getRequiredProperty("db1_max_connections",Integer.class); i++) {
				connections.add(DriverManager.getConnection("jdbc:mysql://localhost:3306/project?serverTimezone=UTC",
						env.getProperty("db1_user"), env.getProperty("db1_pass")));
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

	public void closeAllConnections() {
		for (Connection connection : connections) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
}
