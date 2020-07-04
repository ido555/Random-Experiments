package main;

public class Icecream {
	int hey = 5;
	private static final Icecream instance = new Icecream();
	
	private Icecream() {}
	
	public static Icecream getInstance() {
		return instance;
	}
}
