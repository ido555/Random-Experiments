package garage.DAOs;

import java.util.List;

import garage.beans.Car;

public interface CarDAO {
	Car getCar(int carId);
	List<Car> getAllCars();
	void addCar(Car car);
	void updateCar(Car car);
	void deleteCar(int carId);
}
