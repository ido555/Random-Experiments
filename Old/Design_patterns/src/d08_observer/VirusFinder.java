package d08_observer;

public class VirusFinder {

	// 2 declare interface variable (reference)
	private OnVirusFoundListener listener;

	public void setVirusFoundListener(OnVirusFoundListener listener) {
		this.listener = listener;
	}

	public void scanForViruses() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}

			String fileName = "File" + (int) (Math.random() * 100);
			// report virus found in file!
			//System.out.println("Virus found in: " + fileName); // not very flexible
			if(listener!=null)
				listener.virusFound(fileName);
		}
	}

	// 1 declare interface
	public interface OnVirusFoundListener {
		void virusFound(String filename);
	}

}
