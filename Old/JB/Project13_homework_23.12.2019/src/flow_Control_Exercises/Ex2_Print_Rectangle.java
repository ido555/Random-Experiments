package flow_Control_Exercises;

public class Ex2_Print_Rectangle {
	public static void main(String[] args) {

		int size = 14, spaces = (size * 2) - 3;
		System.out.println();
		Line(size);
		System.out.println();
		for (int i = 0; i < size - 2; i++) {
			System.out.print("*");
			for (int j = 0; j < spaces; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		Line(size);
	}

	public static void Line(int length) { // 
		for (int i = 0; i < length; i++) {
			System.out.print("* ");
		}
	}
}
