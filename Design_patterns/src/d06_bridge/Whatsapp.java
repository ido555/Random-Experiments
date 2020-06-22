package d06_bridge;

public class Whatsapp implements Channel {

	private String number;
	
	@Override
	public void to(String recipient) {
		this.number = recipient;
	}

	@Override
	public void send(String message) {
		System.out.println("Sending Whatsapp: " + message + " to: " + number);
	}

	@Override
	public String receive() {
		return "You have a new Whatsapp message";
	}

}
