import java.util.Scanner;

public class Part0_Recursion_Palindrome {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string to check palindrome: ");
		String str = scanner.nextLine();
		
		if(palindrome(str)) {
			System.out.println(str + " is a palindrome.");
		} else {
			System.out.println(str + " is not a palindrome.");
		}
		
	}
	
	public static boolean palindrome(String str) {
		if(str.length() == 0 || str.length() == 1) {
			return true;	// base case, 
							// if length is 0 or 1 then the string is palindrome
		} else if(str.charAt(0) != str.charAt(str.length() - 1)) {
			return false;	// base case,
							// check the first and last charactor of string
							// if they are not the same, return false.	
		} else {
			// recursive case, reduce the size of string and continue checking
			// (remove the first and last charactors, and pass as new parameter)
			return palindrome(str.substring(1, str.length() - 1));
		}
	}
}
