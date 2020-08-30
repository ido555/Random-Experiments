package _Strings_Targil;

public class Targil_2 {
	public static void main(String[] args) {
		String str = "Warp_Drive";
		StringBuilder builder = new StringBuilder();
		
		for (int i = str.length()-1; i >= 0; i--) {
			builder.append(str.charAt(i));
			
		}
		System.out.println(builder);

	}
}
