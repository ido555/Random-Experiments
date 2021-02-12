package garage.beans;

import java.sql.Date;

public class Driver {
	private int driverId, carId;
	private String name;
	private Date birthDate;

	public Driver(int id, String name, Date birthDate, int carId) {
		this.driverId = id;
		this.name = name;
		this.birthDate = birthDate;
		this.carId = carId;
	}

	public Driver(String name, Date birthDate, int carId) {
		this.name = name;
		this.birthDate = birthDate;
		this.carId = carId;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", name=" + name + ", birthDate=" + birthDate + ", carId=" + carId
				+ "]";
	}

	public int getId() {
		return driverId;
	}

	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public int getCarId() {
		return carId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}
}
