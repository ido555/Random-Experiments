package _Strings_Targil;

import java.util.Arrays;

public class Targil {

	public static void main(String[] args) {
		String[] emails = {"jeffbezos1@gmail.com", "ofir5@gmail.com", "ofaa@gmail.com", "nir_sneer5@gmail.com"};
		for (int i = 0; i < emails.length; i++) {
			
			System.out.println(Arrays.toString(emails[i].split("@")));
			System.out.println("aa");
			
		}
	}
}
