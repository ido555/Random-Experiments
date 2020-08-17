package sql_targil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex_1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC", "root", "1234")) {
			// 1.
			PreparedStatement ps = con.prepareStatement("SELECT company, state_province FROM customers " + "WHERE company LIKE '%a'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				System.out.println(rs.getString(1) + " from the state of " + rs.getString(2) + " in the USA");
			System.out.println("====================================================================================");
			// 2.
			ps = con.prepareStatement("SELECT product_name, list_price, supplier_ids FROM products "
					+ "WHERE supplier_ids IN (1,3) AND list_price > 30");
			rs = ps.executeQuery();
			while (rs.next()) 
				System.out.println(rs.getString(1).split("Northwind Traders ")[1] + ", cost: " + rs.getInt(2) + ", supplier id: " + rs.getInt(3));
			System.out.println("====================================================================================");
			// 3.
			ps = con.prepareStatement("SELECT product_name, list_price, category FROM products WHERE list_price > 50");
			rs = ps.executeQuery();
			while (rs.next())
				System.out.println(rs.getString(1).split("Northwind Traders ")[1] + ", cost: " + rs.getInt(2) + ",  category: " + rs.getString(3));
			System.out.println("====================================================================================");
			// 4.
			ps = con.prepareStatement("SELECT count(id) FROM orders");
			rs = ps.executeQuery();
			rs.first();
			System.out.println("Number of orders: " + rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
