package _JDBC_mySQL_College_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Program {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college?serverTimezone=UTC", "root",
				"1234")) {
			PreparedStatement ps = con.prepareStatement("select * from students where id = 14");
			
			ResultSet rs =  ps.executeQuery();
			
			
			if (rs.next()) { // check if the student exists
				int id = rs.getInt(1);
				int grade = rs.getInt(5);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				int course_id = rs.getInt(6);
				SQL_Student student1 = new SQL_Student(id, grade, course_id, firstName, lastName, email);
				System.out.println(student1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
