package garage.DBDAOs;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import garage.DAOs.DriverDAO;
import garage.beans.Driver;

@Component

public class DriverDBDAO implements DriverDAO {

	@Override
	public Driver getDriver(int driverId) {
		return null;
	}

	@Override
	public ArrayList<Driver> getAllDrivers() {
		return null;
	}

	@Override
	public void addDriver(Driver driver) {

	}

	@Override
	public void updateDriver(int driverId) {

	}

	@Override
	public void deleteDriver(int driverId) {

	}

}
