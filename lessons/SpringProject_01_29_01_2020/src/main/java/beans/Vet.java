package beans;

import org.springframework.stereotype.Component;

@Component
// scope singleton
public class Vet {
	private String name = "Roni", address = "29 Huma Umigdal st.";
	private double hourlyDate = 500.2;
	@Override
	public String toString() {
		return "Vet [name=" + name + ", address=" + address + ", hourlyDate=" + hourlyDate + "]";
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
	public double getHourlyDate() {
		return hourlyDate;
	}
	public void setHourlyDate(double hourlyDate) {
		this.hourlyDate = hourlyDate;
	}
	
	
}
