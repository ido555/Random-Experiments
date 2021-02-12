package another_JDBC_Targil;

public class Car {
	private int carId;
	private int year;
	private String model;

	/**
	 * Used to retrieve car from DB
	 */
	public Car(int carId, String model, int year) {
		this.carId = carId;
		this.model = model;
		this.year = year;
	}

	/**
	 * Used to create car to insert into DB
	 */
	public Car(String model, int year) { // create car
		this.model = model;
		this.year = year;
	}

	public int getCarId() {
		return carId;
	}

	public int getYear() {
		return year;
	}

	public String getModel() {
		return model;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", year=" + year + ", model=" + model + "]";
	}

}
