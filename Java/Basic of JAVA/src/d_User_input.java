import java.util.Scanner; // !Don't forget to import! but Intellij always import xD

public class d_User_input {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // name for scanner is scanner (XD)

        System.out.println("What is your name? ");
        String name = scanner.nextLine();

        System.out.println("How old are you? ");
        int age = scanner.nextInt();

        scanner.nextLine(); // !Don't forget to use another scanner if you need to scan more.!
        // scanner.nextLine(); is Key to use a new Scanner

        System.out.println("What is your favorite food?");
        String food = scanner.nextLine();

        System.out.println("Hello "+name);
        System.out.println("Now you are "+age+" years old");
        System.out.println("You like "+food+". It seems really good.");

    }
}