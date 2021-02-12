
@SuppressWarnings("serial")
public class NegativeNumberException extends Exception {
	public NegativeNumberException() {
		super("a point X or Y value was set below 0");
	}
}
