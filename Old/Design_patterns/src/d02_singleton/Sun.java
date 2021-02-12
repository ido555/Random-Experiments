package d02_singleton;

public class Sun {

	private long diameter = 139_270_000;
	private long surfaceHeat = 200_000_000;
	private long coreHeat = 900_000_000_000L;
	
	
	//1
	private static Sun instance;// = new Sun();
	//2
	private Sun() {
	}
	//3
	public static Sun getInstance() {
		if(instance == null)
			instance = new Sun();
		
		return instance;
	}

	public long getDiameter() {
		return diameter;
	}

	public long getSurfaceHeat() {
		return surfaceHeat;
	}

	public long getCoreHeat() {
		return coreHeat;
	}
	
	
	/******/
	public void setCoreHeat(long coreHeat) {
		this.coreHeat = coreHeat;
	}
	
	
	
	
	
}
