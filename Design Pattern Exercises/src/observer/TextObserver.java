package observer;

public class TextObserver {
	private OnTextReceivedListener listener;

	public void setListener(OnTextReceivedListener listener) {
		this.listener = listener;
	}

	public void getText() {
		// text received from where ever
		String text = "hello world";
		if (listener != null)
			listener.textReceived(text);
	}

	public interface OnTextReceivedListener {
		void textReceived(String text);
	}
}
