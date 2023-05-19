public class a_Main_Car_OOP {

    // object is an instance of a class that may contain attributes and methods
    // example: (phone, desk, computer, coffee cup)

    public static void main(String[] args) {

        a_Car myCar1 = new a_Car(); // constructing the Car object and instance
        a_Car myCar2 = new a_Car(); // the other class named "Main_Car_OOP"

        System.out.println("This is use Car class named myCar1 : make " +myCar1.make);
        System.out.println("This is use Car class named myCar1 : model " +myCar1.model);

        System.out.println("This is use Car class named myCar2 : price " +myCar2.price);
        System.out.println("This is use Car class named myCar2 : color " +myCar2.color);
        System.out.println("This is use Car class named myCar2 : year " +myCar2.year);

        myCar1.drive(); // use method named "drive" on the other class
        myCar1.brake(); // use method named  on the other class
    }
}