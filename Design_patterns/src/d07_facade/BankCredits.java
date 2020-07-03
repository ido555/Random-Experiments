package d07_facade;

public class BankCredits {

	public boolean hasGoodCredit(long id) {
		// check DB for client credit...
		return id == 100 || id == 666;
		
	}
	
}
