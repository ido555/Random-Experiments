package io_input_output;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class IO_Object_Create_and_Write {
	public static void main(String[] args) {
		Car car1 = new Car("Ferrari Spyder 458", "red", 2069, true);
		System.out.println(car1);
		try(FileOutputStream fos = new FileOutputStream("Ferrari.txt");// output byte stream to OS path.file
				ObjectOutputStream oos = new ObjectOutputStream(fos)) { // translate object to byte stream
			oos.writeObject(car1);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} // auto close
	}

}
