package step7_arraylist;

public class CatTester {
	public static void main(String[] args){
		
		Cat c2 = new Cat("Elsa", "white", 5);
		
		System.out.println(c2.getHungry());	// OUTPUT: 5
		
		// create a Food object named f1
		Food f1 = new Food("Fish", 2);
		// pass f1 as parameter
		c2.feedFood(f1);
		
		// create a Food object and pass as parameter 
		// in a single statement (no variable name for Food)
		c2.feedFood(new Food("Cookie", 1));
		
		System.out.println(c2.getHungry());	// OUTPUT: 2
		
		// print all foods that c2 already ate.
		c2.printFoods();
	}
}






