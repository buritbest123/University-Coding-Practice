import java.util.ArrayList;

class Main {
    public static void main(String[] args) {

        //TestingArray();

        //TestingArrayList();

        Testing2DArrayList();

    }


    public static void TestingArray() {

        // Declaring array of size 4
        // int[] nums = new int[4];
        // or
        // Declaring array with initial values
        int[] nums = {10, 20, 30, 40};
        int x = nums[2];	// x = 30
        nums[0] = 5;
        System.out.println("value of x: " + x);

        // Exercise: print the first element in the array
        // ** YOUR CODE HERE ** //
        System.out.println("First element: "+ nums[0]);

        // Exercise: print the last element in the array
        // without using fixed number 4
        // ** YOUR CODE HERE ** //
        System.out.println("Last element: " +nums[nums.length-1]);

        // Exercise: print the total summation of all numbers in the array
        int total = 0;
        // ** YOUR CODE HERE ** //
        for (int dogs : nums) {
            total += dogs;
        }
        System.out.println("Total number: " + total);


        // Declare an array of an object "Dog"
        Dog[] dogs = new Dog[4];
        // Assign a new object "Dog" at index 0
        dogs[0] = new Dog(12, "black");
        System.out.println(dogs[0]);
        dogs[1] = new Dog(12, "white");
        dogs[2] = new Dog(3, "black");

        // Exercise: assign a new dog at index 3
        // The dog has age=3, and color=white
        // and printout the dog information at index 3
        // expected: Add dog at index 3: DOG[3,white]
        // ** YOUR CODE HERE ** //
        dogs[3] = new Dog(3, "white");
        System.out.println("Add dog at index 3: "+dogs[3]);

        // Exercise: change the color of the dog at index 2 to be blue color
        // ** YOUR CODE HERE ** //
        dogs[2] =  new Dog(3,"blue");

        // print color of a dog at index 2
        System.out.println("Dog at index 2 has color: " + dogs[2].color);


        // Exercise: print total age of all dogs in the array
        int totalAge = 0;
        // ** YOUR CODE HERE ** //
        for (Dog dog: dogs){
            totalAge += dog.getAge();
        }
        System.out.println("Total number of age: " + totalAge);

        // 2D Array
        int[][] nums2 = new int[3][4];
        System.out.println("rows: " + nums2.length);

        // Exercise: print number columns
        // expected: columns: 4
        // ** YOUR CODE HERE ** //
        System.out.print("columns: "+ 4);

    }

    public static void TestingArrayList(){

        // Construct ArrayList of Integer
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(10);
        nums.add(20);

        // Exercise: add two more value 30 and 40 respectively
        // ** YOUR CODE HERE ** //
        nums.add(30);
        nums.add(40);

        int x = -1;
        // Exercise: assign value at index 2 to variable x
        // ** YOUR CODE HERE ** //
        x = nums.get(2);

        // print x
        System.out.println("X = " + x);


        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog(12, "black"));
        dogs.add(new Dog(12, "white"));
        // Exercise: add a new dog with age=3, color =black at index 1
        // ** YOUR CODE HERE ** //
        dogs.add(1,new Dog(3,"black"));

        // Exercise: replace an existing dog at index 2,
        // with a new dog age=3, color=white
        // ** YOUR CODE HERE ** //
        dogs.get(2).setAge(3);
        dogs.get(2).color = "white";

        // change color of dog at index 2
        dogs.get(1).color = "blue";
        // -- or --
        dogs.get(1).setColor("blue");

        // print dog at index 2
        Dog d = dogs.get(2);
        System.out.println(d);

        // Exercise: count dog who are younger than 4 months
        int count = 0;
        // ** YOUR CODE HERE ** //
        for (Dog dog_younger : dogs) {
            if (dog_younger.getAge() < 4){
                count++;
            }
        }

        // print
        System.out.println("#Dog < 4 months: " + count);

        // Exercise: print all dog in the arraylist with index
        // print dog with index
        // Example:
        // index:0, DOG[12,black]
        // index:1, DOG[3,blue]
        // index:2, DOG[3,white]
        // ** YOUR CODE HERE ** //
        for(int i = 0; i < dogs.size(); i++){
            System.out.println("index:" + i + ", " + dogs.get(i));
        }
    }

    public static void Testing2DArrayList() {

        // constructor 2D ArrayList of Integer class
        ArrayList<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();

        // Add new ArrayList
        nums.add(new ArrayList<Integer>());
        nums.add(new ArrayList<Integer>());
        nums.add(new ArrayList<Integer>());

        // Add value into the first row of 2D ArrayList
        nums.get(0).add(100);
        nums.get(0).add(200);

        // Exercise: add value 300 at the first element of row 1
        // ** YOUR CODE HERE ** //
        nums.get(1).add(300);


        // Print output
        System.out.println("#rows: " + nums.size());
        System.out.println("#columns at rows 0: " + nums.get(0).size());

        // Exercise: print number of columns at rows 1
        // ** YOUR CODE HERE ** //
        System.out.println("#columns at rows 1: " + nums.get(1).size());


        // Exercise: print value at row 0, column 1
        // ** YOUR CODE HERE ** //
        System.out.println(nums.get(0).get(1));
    }
}