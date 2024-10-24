package step5_parameter;

public class CatTester {
	public static void main(String[] args){
		
		Cat c1 = new Cat("Silver", "gray", 10);
		Cat c2 = new Cat("Elsa", "white", 5);

		// to display hungry level
		System.out.println(c1.getHungry());		// OUTPUT: 10
		
		// feed c1 object which only effects its hungry level
		c1.feed(2);
		
		// to display hungry level after feed(x)
		System.out.println(c1.getHungry());		// OUTPUT: 8
		
		// hungry level of c2 is not effected 
		System.out.println(c2.getHungry());		// OUTPUT: 5
	}
}

