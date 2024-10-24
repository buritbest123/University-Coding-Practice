import java.util.Scanner;

public class f_Math_class {

    public static void main(String[] args) {

        double x; // declaration
        double y; // declaration
        double z; // declaration

        Scanner scanner = new Scanner(System.in); // name for scanner is scanner (XD)

        System.out.println("Enter side x: ");
        x = scanner.nextDouble();
        System.out.println("Enter side y: ");
        y = scanner.nextDouble();

        z = Math.sqrt((x*x)+(y*y)); // or Math.sqrt((Math.pow(x,2))+(Math.pow(y,2))

        System.out.println("The hypotenuse is : "+z);

        scanner.close(); // unnecessary xD
    }
}