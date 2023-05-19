package step1_class;

public class CatTester {
	public static void main(String[] args){
		
		Cat c1 = new Cat();	// Create Cat object via Cat() 
							// default constructor method 
		
		c1.name = "Silver";	// Assign value to its attribute
		c1.color = "gray";	// Assign value to its attribute
		c1.hungry = 10;		// Assign value to its attribute
		
		Cat c2 = new Cat();	// Create another Cat object
		c2.name = "Elsa";	
		c2.color = "White";
		c2.hungry = 5;
		
		c1.greeting();		// call greeting() method by c1
		c2.greeting();		// call greeting() method by c2
	}
}

