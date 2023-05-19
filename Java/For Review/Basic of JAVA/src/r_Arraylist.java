import java.util.ArrayList;

public class r_Arraylist {

    public static void main(String[] args) {

        // ArrayList = 	a resizable array.
        //				Elements can be added and removed after compilation phase
        //				store reference data types

        // Syntax
        // ArrayList<WrapperClass> any_name = new ArrayList<WrapperClass>
        ArrayList<String> food = new ArrayList<String>(); // <Only Wrapper Class> Not only "String" xD

        food.add("pizza");
        food.add("hamburger");
        food.add("hotdog");

        food.set(0, "sushi");
        food.remove(2);
        //food.clear();

        for(int i=0; i<food.size(); i++) {   // Array List used ___.size NOT ___.length
            System.out.println(food.get(i)); // is equivalence to for (String s : food) {
        }                                    // System.out.println(s);

        ArrayList<Integer> A_bunch_number = new ArrayList<Integer>();

        A_bunch_number.add(1);
        A_bunch_number.add(2);
        A_bunch_number.add(3);

        A_bunch_number.set(0,4);
        A_bunch_number.remove(2);

        for (int i=0; i< A_bunch_number.size();i++){ // is equivalence for (Integer integer : A_bunch_number) {
            System.out.println(A_bunch_number.get(i)); // System.out.println(integer);}
        }
    }
}