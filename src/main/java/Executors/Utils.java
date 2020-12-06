package Executors;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Utils {

	public void output(String toBePrinted) {
		try {
			String fileName= "../BlueStacks/target/output.txt";
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true)); 
			
			out.write(toBePrinted); 
			out.close(); 
		}catch(Exception e) {
		}
	}

	public void deleteOldOutputFile() {
		File myObj = new File("../BlueStacks/target/output.txt"); 
		if (myObj.delete()) { 
			System.out.println("Deleted the file: " + myObj.getName());
		} else {
			System.out.println("Failed to delete the file or File not present");
		} 
	}

}
