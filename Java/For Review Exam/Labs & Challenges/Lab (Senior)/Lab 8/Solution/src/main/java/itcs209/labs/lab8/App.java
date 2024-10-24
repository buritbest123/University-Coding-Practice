package itcs209.labs.lab8;


import java.util.Scanner;

public class App {
    public static void main (String[] args) {
        int numBoxes =0;
        Floor floor_1 = new Floor();
        while(numBoxes<20*7) {

            Scanner in = new Scanner(System.in);
            System.out.print("Please give this box a label: ");
            char label = in.next().charAt(0);
            System.out.print("Please give this box a X location: ");
            int row = in.nextInt();
            System.out.print("Please give this box a Y location: ");
            int column = in.nextInt();

            if (floor_1.addBox(row, column, label)) {
                // floor_1.addBox(row,column,label);
                floor_1.printArray();
            } else {
                System.out.println("This box cannot be added!");
            }
                numBoxes++;

        }



    }
}
