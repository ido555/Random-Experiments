package d03_proxy;


public class Chrome extends Browser {

	@Override
	public void surf(String webpage) {
		System.out.println("Now surfing in: " + webpage);
	}

}
