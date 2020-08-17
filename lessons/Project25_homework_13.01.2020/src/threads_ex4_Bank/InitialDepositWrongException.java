package threads_ex4_Bank;

@SuppressWarnings("serial")
public class InitialDepositWrongException extends Exception {

	public InitialDepositWrongException() {
		super("initial balance must be 0 or higher");
	}
}
