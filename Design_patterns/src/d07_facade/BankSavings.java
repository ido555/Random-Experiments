package d07_facade;

public class BankSavings {

	public boolean hasLotsOfSavings(long id) {
		// check if client has lots of savings in DB
		return id == 200 || id == 666;
	}
}
