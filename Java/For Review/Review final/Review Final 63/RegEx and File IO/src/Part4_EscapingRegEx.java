
import java.util.regex.*;

public class Part4_EscapingRegEx {

	public static void main(String[] args) {
		
		String  info = "6388999,Siripen,02-441-0909";		
		
		String valid = "(\\d{7}),([A-Z][a-z]+),(\\d{2}-\\d{3}-\\d{4})";
		Pattern p = Pattern.compile(valid);
		Matcher m = p.matcher(info);
		System.out.println(m.matches());
		
		if(m.matches()) {
			System.out.println("ALL MATCH: " + m.group());
			System.out.println("ID: " +  m.group(1));
			System.out.println("NAME: " + m.group(1));
			System.out.println("PHONE:" + m.group(3));
			
		}
		
		String  wrongInfo = "6388999,Siripen,";
		m.reset(wrongInfo);
		System.out.println(m.matches());
	}
		
		/*
		
		
		Matcher mName = Pattern.compile("[A-Z][a-z]+").matcher(info);
		System.out.println("found name " + mName.find());
		
		Matcher mID = Pattern.compile("\\d{7}").matcher(info);
		System.out.println("found id " + mID.find());
		
		Matcher mPhone = Pattern.compile("\\d{2}-\\d{3}-\\d{4}").matcher(info);
		System.out.println("found phone " + mPhone.find());
		*/

}
