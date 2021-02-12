
@SuppressWarnings("serial")
public class InvalidAmountOfPointException extends Exception {
	public InvalidAmountOfPointException(String str,int num) {
		super("expected " + str + " points but got " + num);
	}
}
