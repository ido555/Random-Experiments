package d06_bridge;

public class SMS implements Channel {

	private String contact;
	
	@Override
	public void to(String recipient) {
		this.contact = recipient;				
	}

	@Override
	public void send(String message) {
		System.out.println("Sending SMS: " + message + " to: " + contact);
	}

	@Override
	public String receive() {
		return "Got a new SMS!";
	}

}
