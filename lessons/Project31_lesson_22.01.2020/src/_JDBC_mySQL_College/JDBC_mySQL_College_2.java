package _JDBC_mySQL_College;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_mySQL_College_2 {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?serverTimezone=UTC",
				"root", "1234")) {
			/*
			PreparedStatement ps = con.prepareStatement("INSERT INTO students "
					+ "(first_name, last_name, email, grade, course_id) values(?,?,?,?,?)");
			
			ps.setString(1, "someStudent");
			ps.setString(2, "someLastName");
			ps.setString(3, "someStudent@mail.some");
			ps.setInt(4, 53);
			ps.setInt(5, 1);
			ps.execute();
			*/
			PreparedStatement ps = con.prepareStatement("SELECT first_name, last_name, grade, course_name "
					+ "FROM students "
					+ "JOIN students.course.name on courses.course_name");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4)  + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
