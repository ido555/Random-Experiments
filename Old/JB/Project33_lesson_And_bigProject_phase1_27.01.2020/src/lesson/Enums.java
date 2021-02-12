package lesson;

import big_project.beans.CategoryType;

public class Enums {
	public static void main(String[] args) {
		CategoryType myType = CategoryType.Food;
		// enum = String with Int index?
		System.out.println(myType);
		System.out.println(myType.ordinal()); // food index
		
		CategoryType myType2 = CategoryType.valueOf("Electronics");
		System.out.println(myType2);
		
	}
}
