package beans;

import org.springframework.stereotype.Component;

@Component
public class PhoneStore {
	private String name = "Phones inc", address = "Phone 20 st";

	@Override
	public String toString() {
		return "PhoneStore [name=" + name + ", address=" + address + "]";
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
	
}
