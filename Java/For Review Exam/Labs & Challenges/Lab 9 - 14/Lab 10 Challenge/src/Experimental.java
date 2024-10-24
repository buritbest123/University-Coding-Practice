public class Experimental {
    public static void testTask1()
    {
        class Best extends Beverages
        {
            public Best(String _name, Beverages.drink _drink) { super(_name, _drink); }
            public double makeItNeutral() {return 0;}
        }
        Best First = new Best("Pepsi#1", Beverages.drink.Pepsi);
        Best Second = new Best("Cola#1", Beverages.drink.Cola);
        System.out.println("Day 1 "+First);
        System.out.println("Day 2 "+Second);
    }

    public static void testTask2() {
        FirstAttempt bell = new FirstAttempt("Sprite#1", Beverages.drink.Sprite, 3.09);
        FirstAttempt bell2 = new FirstAttempt("Mirinda#1", Beverages.drink.Mirinda, 2.53);
        System.out.println(bell);
        System.out.println(bell2);
    }

    public static void testTask3() {
        OtherAttempt ben = new OtherAttempt("Milk#1", Beverages.drink.Milk, 7.05);
        OtherAttempt ben2 = new OtherAttempt("Water#1", Beverages.drink.Water, 7.00);
        System.out.println(ben);
        System.out.println(ben2);
    }

    public static void main(String[] args)
    {
        //Uncomment test case that you want to try for each task
        //testTask1();
        System.out.println("===================================");
        //testTask2();
        System.out.println("===================================");
        //testTask3();
    }
}
