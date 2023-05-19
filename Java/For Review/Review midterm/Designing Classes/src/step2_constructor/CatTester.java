package step2_constructor;

public class CatTester {
	public static void main(String[] args){
		
		// Create Cat object via defined constructor method
		Cat c1 = new Cat("Silver", "gray", 10);
		Cat c2 = new Cat("Elsa", "white", 5);
		
		/*
		 * NOTE: If you already define your own constructor, then
		 * the default constructor method is no longer valid.
		 * Cat c = new Cat(); // error!!!
		 */
		
		c1.greeting();
		c2.greeting();
	}
}

