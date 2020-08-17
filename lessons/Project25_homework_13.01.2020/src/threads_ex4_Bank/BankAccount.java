package threads_ex4_Bank;

public class BankAccount {
	private double balance;

	public BankAccount(double balance) throws InitialDepositWrongException{
		if (balance < 0) {
			throw new InitialDepositWrongException();
		}else {
			this.balance = balance;
		}
	}

	public void withdraw(double amount) {
		if (balance - amount >= 0) { // withdraw -500 deposits 500 tho
			balance -= amount;
			System.out.println(amount + " withdrawn");
		}else {
			System.out.println("not enough money in account balance");
		}
	}
	public void deposit(double amount) {
		if (balance + amount >= 0) {
			balance += amount;
			System.out.println(amount + " deposited");
		}else {
			System.out.println("not enough money in account balance");
		}
	}
	public double getBalance() {
		return balance;
	}
}
