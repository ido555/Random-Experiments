package d06_bridge;

public interface Channel {
	void to(String recipient);
	void send(String message);
	String receive();
}
