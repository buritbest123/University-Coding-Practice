
import java.util.regex.*;

public class Part3_GroupRegEx {

	public static void main(String[] args) {
		
		String  info = "6388999|Siripen|02-441-0909";		
		
		String valid = "(\\d{7})|([A-Z][a-z]+)|(\\d{2}-\\d{3}-\\d{4})";
		Pattern p = Pattern.compile(valid);
		Matcher m = p.matcher(info);
		System.out.println(m.matches());
		
		if(m.matches()) {
			System.out.println("ALL MATCH: " + m.group());
			System.out.println("ID: " +  m.group(1));
			System.out.println("NAME: " + m.group(1));
			System.out.println("PHONE:" + m.group(3));
			
		}
		
	}

}
