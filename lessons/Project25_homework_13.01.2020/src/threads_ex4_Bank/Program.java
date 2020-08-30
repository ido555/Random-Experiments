package threads_ex4_Bank;

public class Program {

	public static void main(String[] args) {
		BankAccount bnkAct;
		try {
			bnkAct = new BankAccount(1.101);
			AccountThread t1 = new AccountThread(bnkAct);
			AccountThread t2 = new AccountThread(bnkAct);
			AccountThread t3 = new AccountThread(bnkAct);
			t1.start();
			t2.start();
			t3.start();
		} catch (InitialDepositWrongException e) {
			// 
			System.out.println(e.getMessage());
		}
		
	}

}
