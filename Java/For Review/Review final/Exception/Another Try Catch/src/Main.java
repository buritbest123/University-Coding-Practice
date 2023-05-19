import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 2;
            int c = a / b; // If we change b to 0, it will say Arithmetic Exception
            int[] item = {10, 20, 30};
            System.out.println(c);
            System.out.println(item[0]); // If we change index more than 2, it will say IndexOutOfBoundsException
            Scanner in = new Scanner (System.in);
            int number = in.nextInt();
            System.out.println(number); // If we input not number, it will say InputMismatchException
        }catch (ArithmeticException e){
            System.out.println("NANI DIVIDE ZERO");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("NANI NUMBER EXCEED");
        }catch (InputMismatchException e){
            System.out.println("NANI NUMBER ONLY");
        }
    }
}
