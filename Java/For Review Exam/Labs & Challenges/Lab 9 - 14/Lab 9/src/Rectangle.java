/*
 * The Rectangle class, subclass of Shape
 */
public class Rectangle extends Shape {
	// Private member variables
	// TODO: CODE HERE
	private double length;
	private double width;

	// Constructors
	public Rectangle() { // Default Constructor
		// TODO: CODE HERE
		super();
		this.length = 0.0; // Initialization length = 0.0
		this.width = 0.0; // Initialization width = 0.0
	}

	public Rectangle(String color, double length, double width) { // Constructor
		// TODO: CODE HERE
		super(color); // Throw value "color" to constructor
		this.length = length;
		this.width = width;
	}

	@Override
	public String toString() {
		// TODO: CODE HERE
		return "Rectangle[length="+this.length+", width="+this.width+", Shape[color="+super.getColor()+"]]";
	}

	// Override the inherited getArea() to provide the proper implementation
	@Override
	public double getArea() {
		// TODO: CODE HERE
		return this.width * this.length;
	}

	// Overload method
	public double getArea(double length, double width) {
		// TODO: CODE HERE
		this.length = length;
		this.width = width;
		return width * length;
	}
}
