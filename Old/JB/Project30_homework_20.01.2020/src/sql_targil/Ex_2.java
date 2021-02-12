package sql_targil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex_2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?serverTimezone=UTC","root", "1234");
				Scanner scan = new Scanner(System.in)) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO employees(id, first_name, last_name, company, job_title, email_address, business_phone)"
					+ " values(?,?,?,?,?,?,?)");
			System.out.print("id =");
			ps.setInt(1, scan.nextInt());
			System.out.print("\nfirst name = ");
			ps.setString(2, scan.next());
			System.out.print("\nlast name = ");
			ps.setString(3, scan.next());
			System.out.print("\ncompany = ");
			ps.setString(4, scan.next());
			System.out.print("\njob title = ");
			ps.setString(5, scan.next());
			System.out.print("\nemail = ");
			ps.setString(6, scan.next());
			System.out.print("\nbusiness phone = ");
			ps.setInt(7, scan.nextInt());
			ps.execute();
			System.out.println("New employee added sucessfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}