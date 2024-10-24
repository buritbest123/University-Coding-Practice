public class e_Main_Car_toStringMethod {

    // toString()

    public static void main(String[] args) {

        // toString() = special method that all objects inherit,
        //              that returns a string that "textually represents" an object.
        //              can be used both implicitly and explicitly

        e_Car2 car = new e_Car2();


        System.out.println(car.toString()); // explicitly

        System.out.println();// or

        System.out.println(car); // implicitly


    }
}