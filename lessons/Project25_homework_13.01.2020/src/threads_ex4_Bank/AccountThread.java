package threads_ex4_Bank;

import java.util.Random;

public class AccountThread extends Thread {
	private BankAccount bnkAct;
	private Random rand;

	public AccountThread(BankAccount bnkAct) {
		this.bnkAct = bnkAct;
		this.rand = new Random();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			if (rand.nextBoolean()) {
				synchronized (bnkAct) { // if a thread is doing anything in this block any other thread wanting to
					//  use this block must wait for the first one to finish
					bnkAct.withdraw(100);
					System.out.println(bnkAct.getBalance());
				}

			} else {
				synchronized (bnkAct) {
					bnkAct.deposit(50);
					System.out.println(bnkAct.getBalance());
				}
			}

		}

	}

}
