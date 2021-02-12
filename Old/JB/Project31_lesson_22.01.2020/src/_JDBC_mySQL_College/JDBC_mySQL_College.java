package _JDBC_mySQL_College;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_mySQL_College {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
/*
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?serverTimezone=UTC",
				"root", "1234"); Scanner scan = new Scanner(System.in)) {
			System.out.println("first name");
			String name = scan.next();
			System.out.println("last name");
			String lastname = scan.next();
			System.out.println("email");
			String email = scan.next();
			System.out.println("grade");
			int grade = scan.nextInt();

			PreparedStatement ps = con
					.prepareStatement("INSERT INTO students(first_name, last_name, email, grade) " + "values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setInt(4, grade);

			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
*/
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?serverTimezone=UTC",
				"root", "1234")) {
			PreparedStatement ps = con.prepareStatement("SELECT grade, first_name FROM students WHERE grade >= 60");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
				System.out.println(rs.getString(2));
			System.out.println("===========================");
			
			 ps = con.prepareStatement("SELECT grade, first_name "
			 		+ "FROM students "
			 		+ "WHERE grade between 80 AND 100 "
			 		+ "AND first_name like 'm%'");
			 rs = ps.executeQuery();
			 while (rs.next()) 
					System.out.println(rs.getString(2) + " = first name starts with m and grades are good");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
