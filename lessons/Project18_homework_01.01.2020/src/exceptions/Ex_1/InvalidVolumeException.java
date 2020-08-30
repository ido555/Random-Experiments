package exceptions.Ex_1;

public class InvalidVolumeException extends Exception {
	private int volume;

	public InvalidVolumeException(int volume) {
		super("invalid volume: " + volume);
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}
}
