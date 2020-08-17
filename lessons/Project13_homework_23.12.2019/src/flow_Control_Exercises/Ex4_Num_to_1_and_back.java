package flow_Control_Exercises;

public class Ex4_Num_to_1_and_back {
	public static void main(String[] args) {
		int num = 10, t = num;
		for (int i = 0; i < num; i++) {
			for (int j = 1; j <= t; j++) {
				System.out.print(j + " ");
			}
			t--;
			System.out.println();
		}
		for (int i = 0; i < num; i++) {
			for (int j = 1; j <= t + 1; j++) {
				System.out.print(j + " ");
			}
			t++;
			System.out.println();
		}

	}
}
