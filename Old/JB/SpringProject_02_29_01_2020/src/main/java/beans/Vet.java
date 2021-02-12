package beans;


// scope singleton
public class Vet {
	private String name = "Roni", address = "29 Huma Umigdal st.";
	private double hourlyRate = 500.2;
	@Override
	public String toString() {
		return "Vet [name=" + name + ", address=" + address + ", hourlyDate=" + hourlyRate + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	
}
