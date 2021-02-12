package io_input_output;

import java.io.FileWriter;
import java.io.IOException;

public class IO_Filewriter_Finally_Clause {

	public static void main(String[] args) {
		//FileWriter writer// gives the ability to write
		/*try {
			FileWriter writer = new FileWriter("c:\\jeff\\test.txt");
			//writer = new FileWriter("c:\\jeffa\\test.txt"); // non existent // (The system cannot find the path specified)
			writer.write("Shalom Olam\n");
			writer.write("Goodbye world...\n");
			//writer.close(); // have to close to allow the OS to understand no one is writing to this file anymore
			// then once the writer is finished with the file the OS allows the user to see the the updated file
			// this is completely an OS thing we have to work around
			// also if the path is invalid  this wont work
			// but if the file doesn't exist it will create a new one
			
		} catch (IOException e) {
			// 
			System.out.println(e.getMessage());
		} finally { // basiclly like another try// for when you want the try catch to always end with this
			try { // another try catch is needed
				writer.close();
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}
		*/
		
		// the better way to do this                               //append? true false
		try(FileWriter writer = new FileWriter("c:\\jeff\\test.txt", true))/* automatically makes a finally clause*/ {
			writer.write("aaaaaaaaaa\n");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} // auto closes anything scanner io whatever is closeable
	}

}
