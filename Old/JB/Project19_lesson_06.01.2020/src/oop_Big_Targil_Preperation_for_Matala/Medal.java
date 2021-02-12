package oop_Big_Targil_Preperation_for_Matala;

public class Medal {
	private int position;
	private String date;

	public Medal(int position, String date) {
		setPosition(position);
		this.date = date;
	}

	public int getPosition() {
		return position;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Medal [position=" + position + ", date=" + date + "]";
	}

	private void setPosition(int position) {
		if (position > 0 && position < 4) // 1 - 3
			this.position = position;
	}

}
