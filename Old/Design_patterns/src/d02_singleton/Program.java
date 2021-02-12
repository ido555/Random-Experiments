package d02_singleton;

public class Program {

	public static void main(String[] args) {

		
		Sun s1 = Sun.getInstance();
		
		System.out.println(s1.getCoreHeat());
		
		s1.setCoreHeat(10000);
		
		Sun s2 = Sun.getInstance();
		System.out.println(s2.getCoreHeat());
		
	}

}
