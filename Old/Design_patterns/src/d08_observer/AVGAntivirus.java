package d08_observer;

import d08_observer.VirusFinder.OnVirusFoundListener;

public class AVGAntivirus implements OnVirusFoundListener {
	
	public void scan() {
		VirusFinder finder = new VirusFinder();
		
		finder.setVirusFoundListener(this);
		
		finder.scanForViruses();
	}

	@Override
	public void virusFound(String filename) {
		
		System.out.println("Oh NO! We found a virus in file: " + filename + "! Moving the file to quarantine");
		// try to erase the virus from the file. if failed -
		// move file to quarantine...
		
	}

	

}
