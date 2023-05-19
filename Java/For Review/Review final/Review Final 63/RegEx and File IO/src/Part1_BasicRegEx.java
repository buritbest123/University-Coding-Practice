
import java.util.regex.*;

public class Part1_BasicRegEx {

	public static void main(String[] args) {
		
		String sample = "abcdefgabcd";
		
		String regex = "bcd";
		
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(sample);
		
		System.out.println("matches the entire string: " + m.matches());
		
		System.out.println("matches at the beginning of string: " + m.lookingAt());
		
		System.out.println("matches any part of the text string: " + m.find());
		
		
		String text = "1abc234";
		
		String regexNum = "\\d+";
		
		Pattern pNum = Pattern.compile(regexNum);
		
		Matcher mNum = pNum.matcher(text);
		
		System.out.println("\n\nFrist group of text found: " + mNum.find());
		System.out.println("Second group of text found: " + mNum.find());
		System.out.println("Third group of txt found: " + mNum.find());
		
		mNum.reset();	// The matcher's region is set to the default region, which is its entire character sequence. 
		
		System.out.println("\ntext: " + text + ", regex: " + regexNum);
		
		while(mNum.find()) {
			System.out.println("found: " +  mNum.group()) ;
		}
		
		mNum.reset();
		
		while(mNum.find()) {
			String found = text.substring(mNum.start(), mNum.end());
			System.out.println("["+ mNum.start() + "," + mNum.end() + "] -> " + found) ;
		}
			
		
		String newText = "123ABC567XYZ890";
		mNum.reset(newText);
		
		System.out.println("\nNew Text: " + newText);
		while(mNum.find()) {
			String found = newText.substring(mNum.start(), mNum.end());
			System.out.println("["+ mNum.start() + "," + mNum.end() + "] -> " + found) ;
		}
	}

}
