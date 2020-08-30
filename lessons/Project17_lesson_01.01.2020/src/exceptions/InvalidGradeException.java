package exceptions;

@SuppressWarnings("serial")
public class InvalidGradeException extends Exception {
	private int invalidGrade;
	public InvalidGradeException(int invalidGrade) {
		super("invalid grade. a valid one is between 0 and 100"); // super is the Exception
		this.invalidGrade = invalidGrade;
	}
	
	public int getGrade() {
		return invalidGrade;
	}
}
