public class Main {

    public static void myMethod_Up() {
        System.out.println("  ______ ");
        System.out.println(" /      \\ ");
        System.out.println("/        \\");
    }

    public static void myMethod_Down() {
        System.out.println("\\        /");
        System.out.println(" \\______/");
    }

    public static void myMethod_Under() {
        System.out.println("+--------+");
    }

    public static void myMethod_Middle() {
        System.out.println("|  STOP  |");
    }

    public static void main(String[] args) {
        myMethod_Up();
        myMethod_Down();

        myMethod_Up();
        myMethod_Down();
        myMethod_Under();

        myMethod_Up();
        myMethod_Middle();
        myMethod_Down();
        myMethod_Under();
    }
}