public class i_Main_Vehicle_Car_Bicycle_Inheritance {

    public static void main(String[] args) {

        // inheritance = 	the process where one class acquires,
        //					the attributes and methods of another.

        i_Car4 car = new i_Car4();

        car.go();

        i_Bicycle bike = new i_Bicycle();

        car.go();
        bike.stop();

        System.out.println(car.doors);
        System.out.println(bike.pedals);

    }
}