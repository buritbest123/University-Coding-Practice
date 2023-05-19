import java.util.Scanner;

0.public class Myprogram{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean status = true;
        do{
            System.out.println("Please select number 1-3 to run the program, or press 0 to quit:");
            int number = in.nextInt();

            if(number == 1) {
                System.out.println("Please insert number to the program and press 0 to to calculate the Max, Min, and Average value:");
                // TODO: Task 1: Write a program to enter the numbers until pressing 0 to stop,
                int min, max = 0; // Set max = 0 and min = input because if set min = 0 it will compute for min
                int input = min = in.nextInt(), elements = 0, sum = 0; // Set elements = 0 and sum = 0
                while (input != 0) { // loop (if input != 0) and ((if input = 0) exit loop)
                    elements++;
                    sum = sum + input;
                    if(input > max){
                        max = input;
                    }
                    if (input < min){
                        min = input;
                    }
                    input = in.nextInt();
                }
                float avg = (float)sum / elements;
                System.out.println("Max="+ max);
                System.out.println("Min="+ min);
                System.out.println("Average="+ avg);
                //then the program should calculate and display the largest (Max), smallest (Min), and Average numbers entered.

            }else if(number == 2) {
                System.out.println("Please insert any number as a high of the triangle:");
                // TODO: Task 2: Write a program to print the following triangle where height h is given by user.
                int input = in.nextInt(); // insert input number as a high of the triangle
                int i, j, num = 0;
                for(i = 0 ; i < input ; i++) {  // Repeat i < input | For example input = 5 mean repeat 5 times
                    for(j = input - i ; j > 0 ; j--) {  // For example first loop is 5 Blank space then repeats until j < 0
                        System.out.print(" "); // Print Blank Space
                    }
                    for(j = 0 ; j <= i + num ; j++) { // Print number from 0 to i < input
                        System.out.print(i);
                    }
                    System.out.println(); // Newline
                    num++;
                }

            }else if(number == 3) {
                // TODO: Task 3: Write a program to print the following Roman 3 number.
                int height = 6; // Height = 7
                for(int i = 0 ; i <= height ; i++) {
                    if(i % 6 == 0) {
                        System.out.print("***  ***  ***");
                    }
                    else {
                        System.out.print(" *    *    * ");
                    }
                    System.out.println(); // Newline
                }
            }else {
                if(number == 0) status = false;
                else System.out.println("invalid number");
            }
        }while(status);

    }

}
