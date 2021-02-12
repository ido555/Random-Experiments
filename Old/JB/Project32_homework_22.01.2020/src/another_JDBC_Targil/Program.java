package another_JDBC_Targil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
//		Driver driver1 = new Driver(4, 55, "Jorgen", "truck");
//		addDriver(driver1);
		
//		Car car1 = new Car("Suzuki", 2019);
//		addCar(car1);
//		deleteDriver(1005);
//		deleteCar(9);
//		Car car1 = getCarById(5);
//		System.out.println(car1);
//		Driver driver1 = getDriverById(1007);
//		System.out.println(driver1);
		ArrayList<Car> allCars = getAllCars();
		for (Car car : allCars) {
			System.out.println(car);
		}
		System.out.println("=======================");
		ArrayList<Driver> allDrivers = getAllDrivers();
		for (Driver driver : allDrivers) {
			System.out.println(driver);
		}
		System.out.println("=======================");
		ArrayList<Driver> ageDrivers = getDriversByMaxAge(50);
		for (Driver driver : ageDrivers) {
			System.out.println(driver);
		}
	}
	
	
	public static ArrayList<Driver> getDriversByMaxAge(int maxAge){ // drivers with age between -2,147,483,647  and  max (because SQL accepts any age cus i didnt place constraints)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivers_and_cars?serverTimezone=UTC", "root", "1234")){
			PreparedStatement ps = con.prepareStatement("SELECT * FROM drivers_and_cars.drivers WHERE drivers_and_cars.drivers.age <= (?)");
			ps.setInt(1, maxAge);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				drivers.add(new Driver(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drivers;
	}
	
	public static ArrayList<Driver> getAllDrivers(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Driver> drivers = new ArrayList<Driver>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivers_and_cars?serverTimezone=UTC", "root", "1234")){
			PreparedStatement ps = con.prepareStatement("SELECT * FROM drivers_and_cars.drivers");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				drivers.add(new Driver(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drivers;
	}
	
	public static ArrayList<Car> getAllCars() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Car> cars = new ArrayList<Car>();
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivers_and_cars?serverTimezone=UTC", "root", "1234")){
			PreparedStatement ps = con.prepareStatement("SELECT * FROM drivers_and_cars.cars");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cars.add(new Car(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	/**
	 * 
	 * @return Driver object or Null if no matching driver found
	 */
	public static Driver getDriverById(int driverId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Driver driver = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivers_and_cars?serverTimezone=UTC", "root", "1234")){
			PreparedStatement ps = con.prepareStatement("SELECT * FROM drivers_and_cars.drivers WHERE drivers_and_cars.drivers.driver_id = (?)");
			ps.setInt(1, driverId);
			ResultSet rs = ps.executeQuery();
			 
			 while(rs.next()) {
				driver = new Driver(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	/**
	 * 
	 * @return Car object or Null if no matching car found
	 */
	public static Car getCarById(int carId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Car car = null;
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivers_and_cars?serverTimezone=UTC", "root", "1234")){
			PreparedStatement ps = con.prepareStatement("SELECT * FROM drivers_and_cars.cars WHERE drivers_and_cars.cars.car_id = (?)");
			ps.setInt(1, carId);
			ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				car = new Car(rs.getInt(1), rs.getString(2), rs.getInt(3));
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car;
	}
	
	public static void deleteCar(int carId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivers_and_cars?serverTimezone=UTC", "root", "1234")) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM drivers_and_cars.cars WHERE drivers_and_cars.cars.car_id = (?)");
			ps.setInt(1, carId);
			ps.execute();
			System.out.println("if the car existed it is now deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteDriver(int driverId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivers_and_cars?serverTimezone=UTC", "root", "1234")) {
			PreparedStatement ps = con.prepareStatement("DELETE FROM drivers_and_cars.drivers WHERE drivers_and_cars.drivers.driver_id = (?)");
			ps.setInt(1, driverId);
			ps.execute();
			System.out.println("if the driver existed he is now deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addCar(Car car) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivers_and_cars?serverTimezone=UTC", "root", "1234")) {
			PreparedStatement ps = con.prepareStatement("INSERT INTO drivers_and_cars.cars(model, year) values(?,?)");
			ps.setString(1, car.getModel());
			ps.setInt(2, car.getYear());
			ps.execute();
			System.out.println("car added");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addDriver(Driver driver) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/drivers_and_cars?serverTimezone=UTC", "root", "1234")) {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO drivers_and_cars.drivers(name, lic_type, age, car_id) values(?,?,?,?)");

			ps.setString(1, driver.getName());
			ps.setString(2, driver.getLicType());
			ps.setInt(3, driver.getAge());
			ps.setInt(4, driver.getCarId());
			ps.execute();

			System.out.println("driver added");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
