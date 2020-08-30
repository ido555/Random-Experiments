package oop_Big_Targil_Preperation_for_Matala;

import java.util.ArrayList;

public class Driver {
	private String name;
	private int age; // 
	private ArrayList<Medal> medals = new ArrayList<Medal>();

	public Driver(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public ArrayList<Medal> getMedals() {
		return medals;
	}

	public void addMedals(Medal medal) {
		if (!(medals.size() > 4))
			medals.add(medal);
	}

	
	@Override
	public String toString() {
		return "Driver [name=" + name + ", age=" + age + ", medals=" + medals + "]";
	}
	
}
