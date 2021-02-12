package io_input_output;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Targil_IO {

	public static void main(String[] args) {
		System.out.println("enter 2 strings");

		try (FileWriter writer = new FileWriter("aa.txt", true); Scanner scan = new Scanner(System.in)) {
			String str = "";
			str += scan.nextLine() + " ";
			str += scan.nextLine();
			writer.write(str);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} // auto closes scanner and file writer

	}

}
