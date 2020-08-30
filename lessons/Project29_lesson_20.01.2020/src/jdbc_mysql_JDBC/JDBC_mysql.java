package jdbc_mysql_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_mysql {

	public static void main(String[] args) {
		// load the mysql Driver to memory
		// java doesn't know the Driver yet...
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // path to class
			// Class static method gets full name of class we want to load to memory
			// e.g. know that "class123" in path.desktop.user.class123 exists
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//System.out.println("Did not find class: " + e.getMessage());
		}
		// insertNewEmployee();
		// insertNewEmployee2(15, "donald", "trump");
		// insertNewProduct(16, "rice2", 32, "just like rice1 but better");
		showAllEmployees();
	}

	public static void insertNewEmployee() {
		// add a new Employee to Northwind

		// 1. open a connection
		try { // jdbc = lib, engine = nysql, ip:port = localhost:3306, database = northwind
				// serverTimezone = UTC( UTC is case sensitive)
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC",
					"root", "1234");

			// 2. create an SQL command
			PreparedStatement statement = con
					.prepareStatement("INSERT INTO employees(id, first_name, last_name) values(14,'mook', 'shlook');");

			// 3. execute command
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void insertNewEmployee2(int id, String firstName, String lastName) {
		// add a new Employee to Northwind

		// 1. open a connection
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC",
					"root", "1234");

			// 2. create an SQL command
			PreparedStatement statement = con
					.prepareStatement("INSERT INTO employees(id, first_name, last_name) values(?,?,?)");

			statement.setInt(1, id); // first index
			statement.setString(2, firstName); // second index
			statement.setString(3, lastName); // third index
			// 3. execute command
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	// list_price
	public static void insertNewProduct(int id, String productName, int productPrice, String description) {
		// 1. open a connection
		try {
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC", "root",
					"1234");

			// 2. create an SQL command
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO products(id, product_name, list_price, description) values(?,?,?,?)");
			statement.setInt(1, id); // first index
			statement.setString(2, productName); // second index
			statement.setDouble(3, productPrice); // third index
			statement.setString(4, description);
			// 3. execute command
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void showAllEmployees() {
		try { // 1. open a connection
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC", "root",
					"1234");
			PreparedStatement statement = con.prepareStatement("select id, first_name, last_name from employees");
			// executeQuery returns something from the SQL Database
			ResultSet rs = statement.executeQuery(); // starts at -1 must increment the ResultSet
			while (rs.next()) {
				// can also do 1 since id is the first column (sql count starts from 1 not 0)
				System.out.print(rs.getInt("id")+"\t");
				System.out.print(rs.getString("first_name")+"\t");
				System.out.println(rs.getString("last_name"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
