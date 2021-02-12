package test.exceptions;

@SuppressWarnings("serial")
public class NoSuchId extends Exception {
	public NoSuchId() {
		super("no employee found by that id");
	}
}
