package exceptions;

@SuppressWarnings("serial")
public class InvalidAgeException extends Exception{

	//private static final long serialVersionUID = -6004236625002547446L;

	public InvalidAgeException() {
		super("Invalid age! age must be between 18 and 70"); // super is the Exception
	}
	
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
}
