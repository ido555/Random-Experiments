package io_input_output;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class IO_Object_Read {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("Ferrari.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)){
			Car car = (Car) ois.readObject();
			System.out.println(car);
		}catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
