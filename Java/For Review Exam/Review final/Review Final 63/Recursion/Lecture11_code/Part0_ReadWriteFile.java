

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Part0_ReadWriteFile {

	public static void main(String[] args) {
		
		// what is my current path?
		String currentPath = Paths.get("").toAbsolutePath().toString();
		System.out.println(currentPath);
		
		String filename = currentPath + File.separator + "test.txt";
		
		// create a File to store and retrieve data
		File aFile = new File(filename);
		
		// write text to file
		try {
		
			// write 
			FileUtils.write(aFile, "Hello World!\n", "utf-8");
			
			// append
			FileUtils.write(aFile, "I love Java.\n", "utf-8", true);
			
			System.out.println("Done write to file " + filename);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// read text from file
		try {
			
			// read all lines from the text file
			List<String> lines = FileUtils.readLines(aFile, "utf-8");
			int count = 0;
			
			// for each line in the string list, print on the screen
			for(String line: lines) {
				System.out.println("[" + count + "] " + line);
				count++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
