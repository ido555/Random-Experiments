package d03_proxy;

import java.util.ArrayList;

public class ChromeProxy extends Browser {

	private ArrayList<String> blacklist = new ArrayList<String>();
	private Chrome chrome = new Chrome();
	
	public ChromeProxy() {
		blacklist.add("www.facebook.com");
		blacklist.add("web.whatsapp.com");
		blacklist.add("www.ynet.co.il");
	}
	
	
	@Override
	public void surf(String webpage) {
		
		for (String siteAddress : blacklist) {
			if(webpage.equals(siteAddress)) {
				System.out.println(webpage + " webpage is not allowed!");
				return;
			}
		}

		chrome.surf(webpage);
		
	}

}
