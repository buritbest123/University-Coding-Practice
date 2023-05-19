
import java.util.regex.*;

public class Part2_BasicRegEx2 {

	public static void main(String[] args) {
		
		String  info = "My name is Siripen_Pongpaichet."
				+ "My student ID is 6388999​\n"
				+ "My phone number is 02-441-0909​\n"
				+ "My line contact is @inging99​\n"
				+ "My email is siripen.pon@mahidol.ac.th​";

		String regexName = "[a-zA-Z]+_[a-zA-Z]+";
		String regexID = "[0-9]{7}​";
		String regexPhone = "[0-9]{2}-[0-9]{3}-[0-9]{4}​";
		String regexLine = "@[\\w]+​";
		String regexEmail = "[\\w]+.[a-zA-Z]{3}@[\\w.]+.[th|com]​";

		Pattern p = Pattern.compile(regexName);
		Matcher m = p.matcher(info);
		m.find();
		System.out.println("Name: " + m.group());
		
		m = Pattern.compile(regexID).matcher(info);
		m.find();
		System.out.println("ID: " + m.group());
		
		m = Pattern.compile(regexPhone).matcher(info);
		m.find();
		System.out.println("Phone: " + m.group());
		

		m = Pattern.compile(regexLine).matcher(info);
		m.find();
		System.out.println("Line: " + m.group());
		
		m = Pattern.compile(regexEmail).matcher(info);
		m.find();
		System.out.println("Email: " + m.group());
	}

}
