package garage.DAOs;

import java.util.ArrayList;

import garage.beans.Driver;

public interface DriverDAO {
	// get one
	// get all
	// add
	// update
	// delete
	Driver getDriver(int driverId);
	ArrayList<Driver> getAllDrivers();
	void addDriver(Driver driver);
	void updateDriver(int driverId);
	void deleteDriver(int driverId);
}
