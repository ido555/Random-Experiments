package exceptions.Ex_1;

public class Tv {
	private String title; // default = null
	private int volume; // default = 0
	private boolean mute; // default = false

	public Tv(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isMute() {
		return mute;
	}

	// Integer.valueOf() returns object
	// Integer.parseInt() returns primitive
	// i will use parseInt
	
	public void controlTv(String controlInput) {
		try { 
			// handle number String
			if (this.volume + Integer.parseInt(controlInput) >= 0 && this.volume + Integer.parseInt(controlInput) <= 10) { // check if end value would be out of range
				this.volume +=  Integer.parseInt(controlInput); // not out of range? set as new volume
				
			} else {
				throw new InvalidVolumeException(this.volume + Integer.parseInt(controlInput));
			}
			
		} catch (InvalidVolumeException e) {
			System.out.println(e.getMessage());
			
		} catch (NumberFormatException e) { // handle non number String
			if (controlInput.equalsIgnoreCase("m")) { // M or m
				this.mute = !this.mute; // flip mute boolean value

			} else if (controlInput.equalsIgnoreCase("e")) { // Exit
				System.out.println("Bye");
				System.exit(0); //static method

			} else { // reject input
				System.out.println(
						e.getMessage() + " : a number or the letters \"m\"/\"e\" were expected. input ignored");
			}
		}
	}

	@Override
	public String toString() {
		return "Tv [title=" + title + ", volume=" + volume + ", mute=" + mute + "]";
	}

}
