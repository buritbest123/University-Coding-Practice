package step4_static;

public class CatTester {
	public static void main(String[] args){
		
		// Access static variable using Cat class 
		System.out.println(Cat.objCounter);		// OUTPUT: 0
		
		Cat c1 = new Cat("Silver", "gray", 10);	
				// this constructor will increase objCounter
		System.out.println(Cat.objCounter);		// OUTPUT: 1
		
		Cat c2 = new Cat("Elsa", "white", 5);
		System.out.println(Cat.objCounter);		// OUTPUT: 2
		
		// Call static method using Cat class
		Cat.begin();		// OUTPUT: Let's start
		
		// Call instance method using specific object 
		c1.greeting();		// OUTPUT: Meow! Silver
		c2.greeting();		// OUTPUT: Meow! Elsa
		
		// Access final variable
		System.out.println(c1.TYPE);	// OUTPUT: cat
		
		// Access static final variable
		System.out.println(Cat.LIVE);	// OUTPUT: 9
				
	}
}
