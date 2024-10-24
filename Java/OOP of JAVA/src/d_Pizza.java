public class d_Pizza {

    String bread;
    String sauce;
    String cheese;
    String topping;

    d_Pizza() { // create the constructor for this pizza
    }

    d_Pizza(String bread) {
        this.bread = bread;
    }

    d_Pizza(String bread, String sauce) {
        this.bread = bread;
        this.sauce = sauce;
    }

    d_Pizza(String bread, String sauce, String cheese) {
        this.bread = bread;
        this.sauce = sauce;
        this.cheese = cheese;
    }

    d_Pizza(String bread, String sauce, String cheese, String topping) {
        this.bread = bread;
        this.sauce = sauce;
        this.cheese = cheese;
        this.topping = topping;
    }
}