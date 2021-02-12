package exceptions.Ex_1;

import java.util.Scanner;

public class Tv_Test {

	public static void main(String[] args) {
		Tv tv = new Tv("jeff");
		
		System.out.println("enter a number or the letters \"m\"/\"e\"");
		Scanner scan = new Scanner(System.in);

		while(true){
			tv.controlTv(scan.next());
			System.out.println(tv.toString());
		}
		
	}
}
/*
System.out.println(tv.toString());

tv.controlTv("a");
System.out.println(tv.toString());
tv.controlTv("2");

System.out.println(tv.toString());
tv.controlTv("8");
System.out.println(tv.toString());

tv.controlTv("8");
System.out.println(tv.toString());

tv.controlTv("-20");
System.out.println(tv.toString());

tv.controlTv("M");
System.out.println(tv.toString());

tv.controlTv("m");
System.out.println(tv.toString());

tv.controlTv("e");// program ends here

tv.controlTv("m");
System.out.println(tv.toString());
*/