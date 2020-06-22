package d03_proxy;

public class Program {

	public static void main(String[] args) {
		Chrome chrome = new Chrome();
		chrome.surf("www.johnbryce.co.il");
		chrome.surf("www.facebook.com");
		chrome.surf("web.whatsapp.com");
		
		System.out.println("======================");
		
		ChromeProxy chrome2 = new ChromeProxy();
		chrome2.surf("www.johnbryce.co.il");
		chrome2.surf("www.facebook.com");
		chrome2.surf("www.nirtech.co.il");
	}

}
