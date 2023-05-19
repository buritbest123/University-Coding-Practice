import java.util.ArrayList;

public class Stack<T> extends ArrayList<T>{

    private int maxCapacity; // User will put capacity to set maxCapacity
    private int currentIndex; // declaration "currentIndex"

    public Stack() { // overloaded constructors
        this.maxCapacity = -1; //   Set maxCapacity = -1, it means infinite
        this.currentIndex = -1; // The reason why currentIndex = -1 because when we push 1 time. cI actually = 0
    }

    public Stack(int capacity) { // constructor set a parameters and assign "capacity" to the attributes of class
        this.maxCapacity = capacity;
        this.currentIndex = -1;
    }

    public boolean push(T object) { // add an element to the top
        if((this.currentIndex >= this.maxCapacity - 1) && this.maxCapacity > 0) {
            return false;
        }
        else {
            this.add(object);
            this.currentIndex += 1;
            return true;
        }
    }

    public T pop() { // remove an element from the top
        if(this.currentIndex < 0) {
            return null;
        }
        else {
            T removeTop = this.remove(currentIndex);
            this.currentIndex -= 1;
            return removeTop;
        }
    }

    public T peek() { // get an element from the top, and it doesn't remove
        if(this.currentIndex < 0) {
            return null;
        }
        else {
            return this.get(currentIndex);
        }
    }

    public T[] toArray() { // method of ArrayList is used to return an array containing all the elements
                           // in ArrayList in the correct order.
        if (!isEmpty()) {
            ArrayList array = new ArrayList();
            for (int i=0; i<size(); i++) {
                array.add(get(i));
            }
            return (T[]) array.toArray(); // get an Array
        }
        else {
            return null;
        }
    }


    public String toString() { // special method that all object inherit, that return a string
                               // that "textually represents" an object.
        if(this.currentIndex < 0) {
            return " ";
        }
        else {
            StringBuilder block = new StringBuilder(); // Constructs a string builder with no characters
                                                       // in it and an initial capacity of 16 characters.

            for(int i = this.currentIndex; i >= 0; i--) {
                block.append("|").append(this.get(i)).append("|\n"); // String concatenation
                /*
                first code = rough code
                block += "|" + this.get(i) + "|\n";
                */
            }
            return block.toString();
        }
    }
}