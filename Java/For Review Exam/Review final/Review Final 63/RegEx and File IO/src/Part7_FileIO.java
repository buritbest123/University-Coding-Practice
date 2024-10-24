import java.io.*;
import java.nio.file.Paths;

public class Part7_FileIO {
	
	public static void main(String[] args) {
		// what is my current path?
		String currentPath = Paths.get("").toAbsolutePath().toString();
		
		System.out.println(currentPath);	// display current path
		
		System.out.println(File.separator);		// either "/" or "\"
		
		// check existing of the file
		File a = new File("test.txt");
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
		
		// create a new file
		// option 1) BufferedWriter
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(a));
			writer.write("Hello world!\n");	// to write
			writer.append("Hello Mars!");	// to append
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		BufferedReader reader = null;
		
		System.out.println("\n----- read char -----\n");
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(a)));
			int c = -1;	
			while((c = reader.read()) != -1) {	// -1 is then end of file
				char character = (char) c;
				System.out.print(character + ",");
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n\n----- read line -----\n");
		reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(a)));
			String line = "";	
			while((line = reader.readLine()) != null) {	// -1 is then end of file
				System.out.println(line);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
