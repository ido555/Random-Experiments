package garage.beans;

public class Car {
	private int carId, year;
	private String model, color;

	public Car(int carId, int year, String model, String color) {
		this.carId = carId;
		this.year = year;
		this.model = model;
		this.color = color;
	}

	public Car(int year, String model, String color) {
		this.year = year;
		this.model = model;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [carId=" + carId + ", year=" + year + ", model=" + model + ", color=" + color + "]";
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

	public String getColor() {
		return color;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
