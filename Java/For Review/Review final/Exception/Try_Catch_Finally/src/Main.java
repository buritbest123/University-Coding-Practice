import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;

class Main {
  public static void main(String[] args) {
    // -----------------------------------------------------
    // Try/Catch/Finally
    // -----------------------------------------------------
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter number: ");
    try{
      System.out.print("Enter any number: ");
      int numSure = scan.nextInt(); // Scan number
      System.out.println("Your number is " + numSure);
      System.out.print("Enter any number again: ");
      String stringSure = scan.next(); // Scan string
      double num2 = Double.parseDouble(stringSure); // Convert String to double
      System.out.println("Your number is " + num2);
      System.out.println("Good job. Bye!");

    } catch (InputMismatchException e){ // First condition if not number said "Your input is not a number"
      System.out.println("Your input is not a number");
      System.out.println(e.getMessage());
    } catch (NumberFormatException e){ // Second condition if String already has number said "Cannot convert your input to number"
      System.out.println("Cannot convert your input to number");
      System.out.println("getMessage():" + e.getMessage() + "\n\n");
      e.printStackTrace();
    } finally {
      System.out.println("Here in finally block");
      scan.close(); // close then Scanner
    }

   }
}