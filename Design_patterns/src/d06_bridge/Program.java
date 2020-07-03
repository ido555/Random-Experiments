package d06_bridge;

public class Program {

	public static void main(String[] args) {
		MessageSender sender = new MessageSender(new Email());
		sender.to("nirg@jbh.co.il");
		sender.send("Don't forget to send homework!");
		//sender.receive();
		
		sender.setChannel(new SMS());
		sender.to("052-8571084");
		sender.send("Hi Nir, ma nishma?");
		
		sender.setChannel(new Whatsapp());
		sender.to("052-8571084");
		sender.send("whats up???");
		
	}

}
