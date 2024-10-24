import java.util.Scanner;

public class Trailingzero {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int input = in.nextInt(); // ex. input = 5
        if(input > 0 && input < 1024) { // where 0 < n < 1024
            String binary = "";
            while (input / 2 != 0) { // ex. 5 / 2 != 0
                binary = input % 2 + binary; // ex. 1st. binary = 5 % 2 + 0 = 1  |2nd. ex. binary = 2 % 2 + 0 = 0 binary = 10
                input = input / 2; // ex. 1st. input = 5 / 2 = 2 |2nd. input = 2 / 2 = 1
            }
            binary = input + binary; // binary = "1 + 10" = "110"
            System.out.println(binary);
            int n = Integer.parseInt(binary); // converting to int format for count 0
            int count = 0;
            for (int i = 10; n % i == 0; i *= 10) { // ex. 110 % 10 == 0 (run this loop 1 time)
                count ++;
            }
            System.out.println(count);
        }
        if (input >= 1024){
            System.out.println("The input should lower than 1024");
        }
    }
}