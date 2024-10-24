import java.util.Random;

public class c_DiceRoller {

    Random random; // random class as global | These are declared outside a method
    int number; // our integer number variable as global | These are declared outside a method

    c_DiceRoller(){ // create a constructor it's the same name as the class name

        random = new Random();
        roll(); // call method roll
    }

    void roll() {
        number = random.nextInt(6)+1;
        System.out.println(number);
    }
}