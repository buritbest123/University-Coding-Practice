package part2_casting;

public class Tester {

	public static void main(String[] args) {
		/*************************************************
		 * recall: primitive type
		 */
		/*
		double d; int i;
		d = 5; 	       // Widening type is legal
		i = 3.5;       // Narrowing type is illegal
		i = (int) 3.5; // Narrowing type using cast is legal
		*/
		
		/*************************************************
		 * Apply the same concept with reference type (object)
		 */
		/*
		Animal a = new Animal("AA");	// OKAY: Widening type is legal
		a.greeting(); 		// expected:
		
		Animal c  = new Cat("CC");
		c.greeting(); 		// expected:
		
		Animal d = new Dog("DD");
		d.greeting();  		// expected:
		
		Cat e = new Animal("EE"); // ERROR: Narrowing type is illegal
									// (unless you do cast)
		*/
		
		/*************************************************
		 * Using "instanceof" operator
		 */
		
		/*
		Animal a = new Animal("AA");
		Animal c  = new Cat("CC");
		Animal d = new Dog("DD");
		
		System.out.println(a instanceof Animal);  // true
		System.out.println(c instanceof Animal);  // true
		System.out.println(d instanceof Animal);  // true
		
		System.out.println(a instanceof Cat);  // false
		System.out.println(c instanceof Cat);  // true
		System.out.println(d instanceof Dog);  // true
		*/
		
		/*************************************************
		 * Casting from a generic reference to more specific object. 
		 */
		/*
		Animal c  = new Cat("CC");
		Animal d = new Dog("DD");
		
		Cat x = (Cat) c;
		x.chasing();	// OK
		
		Cat y = (Cat) d; // Run-time ERROR: ClassCastException since d is Dog
		y.chasing();	
		 */
		 
		/*************************************************
		 * To avoid casting error, 
		 * one must check for compatibility (using instanceof)
		 */
		
		/*
		if(d instanceof Cat){
			Cat z = (Cat) d;
			z.chasing();
		} else{
			System.out.println("I'm not a Cat. I cannot chase a mouse.");
		}
		*/
		
		/*************************************************
		 * Casting from a specific object to a generic object,
		 * no need to check for compatibility before casting.
		 */
		/*
		Animal x  = new Cat("CC");
		
		Animal a = (Animal) x;
		a.chasing();	// Compile ERROR: Animal doesn't have chasing method
		*/
		
		/*************************************************
		 * Casting between subclasses --> NOT ALLOW
		 */
		
		/*
		Dog d = new Dog("DDD");
		Cat c = (Cat) d;	   // Compile ERROR
		
		Animal dd = new Dog("DDDD");
		Cat cc = (Cat) dd;   // Runtime ERROR
		*/
	}

}
