package d07_facade;

public class BankMortgage { // Bank Facade

	private BankCredits credits = new BankCredits();
	private BankLoans loans = new BankLoans();
	private BankSavings savings = new BankSavings();
	
	public boolean entitledToMortgage(long id) {
		return credits.hasGoodCredit(id) && loans.hasNoMoreLoans(id) && savings.hasLotsOfSavings(id);
	}
	
}
