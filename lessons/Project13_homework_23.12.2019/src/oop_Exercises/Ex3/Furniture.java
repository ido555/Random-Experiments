package oop_Exercises.Ex3;

public abstract class Furniture {
	private int length;
	private int width;
	private int height;
	private String color;

	public Furniture(int length, int width, int height, String color) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	void draw() {
		
	}
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
