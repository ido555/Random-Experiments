package test.exceptions;

@SuppressWarnings("serial")
public class NoMatchingName extends Exception {
	public NoMatchingName() {
		super("no matching employee(s) found by that name");
	}
}
