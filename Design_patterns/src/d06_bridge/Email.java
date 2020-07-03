package d06_bridge;

public class Email implements Channel {

	private String recipient;
	
	@Override
	public void to(String recipient) {
		this.recipient = recipient;
	}

	@Override
	public void send(String message) {
		System.out.println("Sending email: " + message + " to: " + recipient);
	}

	@Override
	public String receive() {
		return "Receiving some new email...";
	}

}
