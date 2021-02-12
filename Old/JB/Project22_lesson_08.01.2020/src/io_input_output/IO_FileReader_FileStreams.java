package io_input_output;

import java.io.FileReader;
import java.io.IOException;
public class IO_FileReader_FileStreams {

	public static void main(String[] args) {
		try (FileReader reader = new FileReader("c:\\jeff\\test.txt")) {
			int letter = reader.read(); // return letter ascii value
			while(letter != -1) { // as long as char has a valid ascii value
				System.out.print((char)letter);
				letter = reader.read();
			}
		} catch (IOException e) { // FileNotFoundException extends IOException so no need to add
			System.out.println(e.getMessage());
		}// finally .close
		// io stream is binary code
		// file reader and writer , write and read binary code streams from files
		// FileInputStream
		// FileOutputStream
		

	}
}
