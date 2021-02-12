package d06_bridge;

public class MessageSender { // The Bridge

	private Channel channel;

	public MessageSender(Channel channel) {
		super();
		this.channel = channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public void to(String recipient) {
		channel.to(recipient);
	}

	public void send(String message) {
		channel.send(message);
	}

	public void receive() {
		System.out.println(channel.receive());
	}

}
