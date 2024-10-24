public class b_Variables {

    public static void main(String[] args){

        // data types |  size  | primitive / reference | value
        /*  *boolean  |1 bit   |     primitive         | true or false
             byte     |1 bytes |     primitive         | -128 to 127
             short    |2 bytes |     primitive         | -32,768 to 32,767
            *int      |4 bytes |     primitive         | -2 billion to 2 billion
             long     |8 bytes |     primitive         | -9 quintillion to 9 quintillion

             float    |4 bytes |     primitive         | fractional number up to 6-7 digits
            *double   |8 bytes |     primitive         | fractional number up to 15 digits

            *char     |2 bytes |     primitive         | single character/letter/ASCII value
            *String   |2 bytes |     reference         | single character/letter/ASCII value
         */
        int c; // declaration
        c = 123; // assignment

        // declaration + assignment = initialization

        int x = 123; // initialization with int
        double y = 3.14; // initialization with double
        boolean z = true; // initialization with boolean
        char symbol = '@'; // initialization with char
        String name = "Bro"; // initialization with String

        System.out.println("This is a easy number "+x); // String concatenation
        System.out.println("This is a decimal number "+y); // String concatenation
        System.out.println("If this is "+ z + " another one is false"); // String concatenation
        System.out.printf("%c\n", symbol); // printf like C Language
        System.out.println("Hello "+name); // String concatenation
    }
}