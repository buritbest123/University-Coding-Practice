import java.io.*;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Part8_CommonIO {
	
	public static void main(String[] args) {
		// what is my current path?
		String currentPath = Paths.get("").toAbsolutePath().toString();
		
		System.out.println(currentPath);	// display current path
		
		File a = new File("test2.txt");
		System.out.println("Is the file exist? " + a.exists());
		
		try {
			if(a.createNewFile()) {
				System.out.println("File has been created.");
			} else {
				System.out.println("File already exists.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//To write
		try {
			FileUtils.write(a, "Hello World.\n");
			// The encoding includes US-ASCII, ISO-8859-1, UTF-8, and UTF-16 to name a few. 
			FileUtils.write(a, "Hello World.\n", "UTF-8");
			
		} catch (IOException e) {e.printStackTrace();}
		
		//To append
		try {
			FileUtils.write(a, "Hello Mars.\n", true);
		} catch (IOException e) {e.printStackTrace();}
		
		//To read
		try {
			List<String> lines = FileUtils.readLines(a);
			for(String line: lines){ 
				System.out.println(line);
			}
		} catch (IOException e) {e.printStackTrace();}
		
	}
}
