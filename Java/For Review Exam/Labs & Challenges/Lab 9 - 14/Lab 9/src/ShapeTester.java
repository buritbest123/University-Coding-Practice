public class ShapeTester {
	public static void main(String[] args) {
		Shape s1 = new Rectangle("red", 4, 5);
		System.out.println(s1);  							// Run Rectangle's toString()
		System.out.println("Area is " + s1.getArea());  	// Run Rectangle's getArea()

		 // Uncomment this section when you finish the class Triangle for testing
	      Shape s2 = new Triangle("blue", 4, 5);
	      System.out.println(s2);  							// Run Triangle's toString()
	      System.out.println("Area is " + s2.getArea());  	// Run Triangle's getArea()


		Shape s3 = new Shape("blue");
		System.out.println("--Test superclass method--");
		System.out.println(s3);  							// Run Triangle's toString()
		System.out.println("Area is " + s3.getArea());  	// Run Triangle's getArea()

		Rectangle s4 = new Rectangle();
		s4.setColor("green");
		System.out.println("--Test overload method--");
		System.out.println("Area is " + s4.getArea(5.0, 10.0));  	// Run Rectangle's getArea()
		System.out.println(s4);	  												// Run Rectangle's toString()

		// Uncomment this section when you finish the class Triangle for testing
		Triangle s5 = new Triangle();
		s5.setColor("yellow");
		System.out.println("--Test overload method--");
		System.out.println("Area is " + s5.getArea(5.0, 10.0));  	// Run Triangle's getArea()
		System.out.println(s5);  												// Run Triangle's toString()

		Square s6 = new Square("black", 2);
		System.out.println(s6);
		System.out.println("Area is "+s6.getArea());

		Square s7 = new Square();
		s7.setColor("white");
		System.out.println("--Test overload method--");
		System.out.println("Area is " + s7.getArea(2.0));  	// Run Square's getArea()
		System.out.println(s7);
	}
}
