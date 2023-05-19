public class g_Main_Garage_Car_ObjectPassing {

    public static void main(String[] args) {

        g_Garage garage = new g_Garage();

        g_Car3 car1 = new g_Car3("BMW");
        g_Car3 car2 = new g_Car3("Tesla");

        garage.park(car1);
        garage.park(car2);

    }
}