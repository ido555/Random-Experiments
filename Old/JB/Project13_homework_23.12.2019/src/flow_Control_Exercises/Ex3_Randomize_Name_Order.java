package flow_Control_Exercises;
import java.util.Arrays;
import java.util.Random;

public class Ex3_Randomize_Name_Order {

	public static void main(String[] args) {
		Random rand = new Random();
		char[] name = { 'N', 'i', 'r', ' ', 'G', 'a', 'l' };
		int index = 0;
		for (int i = 0; i < name.length; i++) {
			index = rand.nextInt(name.length);
			// swap between i and index without losing information
			char t = name[i];
			name[i] = name[index];
			name[index] = t;
		}
		System.out.println(Arrays.toString(name));
	}

}
