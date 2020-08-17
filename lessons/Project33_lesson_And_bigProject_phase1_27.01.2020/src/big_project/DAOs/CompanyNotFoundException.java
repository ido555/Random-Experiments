package big_project.DAOs;

@SuppressWarnings("serial")
public class CompanyNotFoundException extends Exception {
	public CompanyNotFoundException() {
		super("company not found");
	}
}
