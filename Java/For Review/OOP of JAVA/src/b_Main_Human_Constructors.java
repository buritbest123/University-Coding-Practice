import java.util.Scanner;

public class b_Main_Human_Constructors {

    // constructor = special method that is called when an object is instantiated (created)

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in); // Scanner two times

        String name = in.nextLine();
        int age = in.nextInt();
        in.nextLine();
        double weight = in.nextDouble();
        in.nextLine();

        String name2 = in.nextLine();
        int age2 = in.nextInt();
        in.nextLine();
        double weight2 = in.nextDouble();

        b_Human human1 = new b_Human(name,age,weight); // sending our constructor to Special Method
        b_Human human2 = new b_Human(name2,age2,weight2);

        human1.drink();
        human2.eat();

    }
}