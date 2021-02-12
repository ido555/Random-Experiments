package another_JDBC_Targil;

public class Driver {
	private int driverId;
	private int carId;
	private int age;
	private String licType; // license type
	private String name;

	/**
	 * used to retrieve driver from DB
	 * (contains Car FK referring to a Car table)
	 **/
	public Driver(int driverId, String name, String licType, int age, int carId) {
		this.driverId = driverId;
		this.carId = carId;
		this.age = age;
		this.licType = licType;
		this.name = name;
	}

	/**
	 * used insert a Driver to the DB
	 * 
	 * @carId is a FK referring to the Car table
	 **/
	public Driver(int carId, int age, String name, String licType) {
		this.carId = carId;
		this.age = age;
		this.name = name;
		this.licType = licType;
	}

	public int getDriverId() {
		return driverId;
	}

	public int getCarId() {
		return carId;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getLicType() {
		return licType;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", carId=" + carId + ", age=" + age + ", licType=" + licType + ", name="
				+ name + "]";
	}
}
