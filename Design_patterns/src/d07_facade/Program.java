package d07_facade;

public class Program {

	public static void main(String[] args) {
		
		BankMortgage mortageFacade = new BankMortgage();
		long id1 = 200;
		long id2 = 666;
		long id3 = 404;
		
		if(mortageFacade.entitledToMortgage(id1))
			System.out.println("Client " + id1 + " is entitled to mortgage!");
		else
			System.out.println("Client " + id1 + " is NOT entitled to mortgage!");
		
		
		if(mortageFacade.entitledToMortgage(id2))
			System.out.println("Client " + id2 + " is entitled to mortgage!");
		else
			System.out.println("Client " + id2 + " is NOT entitled to mortgage!");
		
		
		if(mortageFacade.entitledToMortgage(id3))
			System.out.println("Client " + id3 + " is entitled to mortgage!");
		else
			System.out.println("Client " + id3 + " is NOT entitled to mortgage!");

	}

}
