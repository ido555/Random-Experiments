package garage.DBDAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import garage.DAOs.CarDAO;
import garage.beans.Car;

@Component
public class CarDBDAO implements CarDAO, RowMapper<Car> {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public Car getCar(int carId) {
		// this magically (using Reflection) refers to rowMap correctly;
		String sql = "SELECT * FROM garage.cars WHERE cars.car_id = " + carId;
		// 
		return jt.queryForObject(sql, this);
	}

	@Override
	public List<Car> getAllCars() {
		// List is static in size but its fine for this. ArrayList implements List
		return jt.query("SELECT * FROM garage.cars", this);

	}

	@Override
	public void addCar(Car car) {
		String sql = "INSERT INTO garage.cars (model, color, year) values(?,?,?)";
		jt.update(sql, car.getModel(), car.getColor(), car.getYear());
	}

	@Override
	public void updateCar(Car car) {
		String sql = "UPDATE garage.cars SET model = ?, color = ?, year = ? WHERE car_id = ?";
		jt.update(sql, car.getModel(), car.getColor(), car.getYear(), car.getCarId());
	}

	@Override
	public void deleteCar(int carId) {
		String sql = "DELETE FROM garage.cars WHERE id = ?";
		jt.update(sql, carId);
	}

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		int carId = rs.getInt(1);
		String model = rs.getString(2);
		String color = rs.getString(3);
		int year = rs.getInt(4);
		return new Car(carId, year, model, color);
	}

}
