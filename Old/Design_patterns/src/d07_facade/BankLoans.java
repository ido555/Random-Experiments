package d07_facade;

public class BankLoans {

	public boolean hasNoMoreLoans(long id) {
		// check DB for more loans
		return id == 666 || id == 777;
	}
	
}
