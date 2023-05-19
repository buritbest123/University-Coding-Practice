import java.util.Random;

public class g_Random_numbers {

    public static void main(String[] args) {

        Random random = new Random();

        int x = random.nextInt(6)+1; // if we don't +1 it will print 0 between 5 / 0-5
        // double y = random.nextDouble();
        // boolean z = random.nextBoolean();

        System.out.println(x); // It will print 1-6

    }
}