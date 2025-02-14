public class l_For_loop {

    public static void main(String[] args) {

        // for loop = executes a block of code a limited amount of times
        System.out.println("This loop will print 0-10");
        for (int i = 0; i < 10; i++) {
            System.out.print(" "+i);
        }
        System.out.println("\n");
        System.out.println("This loop will print 10-0");
        for(int i=10; i>=0; i--) {
            System.out.print(" " + i);
        }
        System.out.println("\n");
        System.out.println("Happy new year!");
    }
}