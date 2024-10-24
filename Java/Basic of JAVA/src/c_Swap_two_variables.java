public class c_Swap_two_variables { // Like C language

    public static void main(String[] args) {

        String x = "water"; // It can use either 8 primitive or reference (String) to swap
        String y = "Kool-Aid"; // It can use either 8 primitive or reference (String) to swap
        String temp;

        temp = x;
        x = y;
        y = temp;

        System.out.println("x: " + x);
        System.out.println("y: " + y);
    }

}