import java.util.Scanner;

public class Main {

    public static int approximation (int n) {
        if (n == 1) {
            return 0;
        } else {
            return 1+ approximation(n/2);
        }
    }
    public static void main(String[] args) {
	// write your code here
        int output, output2;
        Scanner input = new Scanner(System.in);
        int user = input.nextInt();
        if (0 < user && user <= 1000000000) {
            output = approximation(user);
            output2 = approximation(user) + 1;
            System.out.printf("%d %d",output2, output);
        } else {
            System.out.println("ERROR T-T");
        }
    }
}