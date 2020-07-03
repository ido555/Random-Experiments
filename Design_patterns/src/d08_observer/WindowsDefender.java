package d08_observer;

import d08_observer.VirusFinder.OnVirusFoundListener;

public class WindowsDefender implements OnVirusFoundListener {
	
	public void scanComputer() {
		VirusFinder finder = new VirusFinder();
		
		finder.setVirusFoundListener(this);
		
		finder.scanForViruses();
	}

	@Override
	public void virusFound(String filename) {
		
		System.out.println("Oh shucks, found a virus in file " + filename + " but I don't know what to do...");
		
	}

}
