public class d_Main_Pizza_Overloadconstructors {

    /* overload constructor = multiple constructor within a class with the same name,
                              but have different parameters
                              name + parameters = signature
     */

    public static void main(String[] args) {


        d_Pizza pizza = new d_Pizza("thicc crust","tomato","mozzerella","pepperoni");

        System.out.println("Here are the ingredients of your pizza: ");
        System.out.println(pizza.bread);
        System.out.println(pizza.sauce);
        System.out.println(pizza.cheese);
        System.out.println(pizza.topping);

    }
}