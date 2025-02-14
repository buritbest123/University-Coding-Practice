import java.util.Scanner;

public class k_While_loop {

    public static void main(String[] args) {

        // while loop = executes a block of code as long as it is condition remains true

        Scanner scanner = new Scanner(System.in);
        String name = "";

        while(name.isEmpty()) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine();
        }

        System.out.println("Hello "+name);

    }
}