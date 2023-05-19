package step6_object_parameter;

public class CatTester {
	public static void main(String[] args){
		
		Cat c1 = new Cat("Silver", "gray", 10);
		
		System.out.println(c1.getHungry());	// OUTPUT: 10	
		c1.feed(2);
		System.out.println(c1.getHungry());	// OUTPUT: 8
		
		// Create Food object whose name is fish
		// and level is 3
		Food f1 = new Food("Fish", 5);
		System.out.println(f1.getLevel());	// OUTPUT: 5
		
		c1.feed(f1.getLevel());	
			// since f1.getLevel() is equal to 5
			// so this code is similar to c1.feed(5);
		System.out.println(c1.getHungry());	// OUTPUT: 3

		// Let's work with another object c2
		Cat c2 = new Cat("Elsa", "white", 5);
		
		System.out.println(c2.getHungry());	// OUTPUT: 5
		c2.feedFood(f1);
			// Food object f1 is passed as parameter
		System.out.println(c2.getHungry());	// OUTPUT: 0
	}
}






