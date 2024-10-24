/*  The structure of Triangle class is similar to Rectangle */
public class Triangle extends Shape {

	//TODO: Code Here
    private double base;
    private double height;

    // Constructors
    public Triangle() {
        // TODO: CODE HERE
        super();
        base = 0.0; // Initialization base = 0.0
        height = 0.0; // Initialization width = 0.0
    }

    public Triangle(String color, double base, double height) {
        // TODO: CODE HERE
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    public String toString() {
        // TODO: CODE HERE
        return "Triangle[base="+this.base+", height="+this.height+", Shape[color="+super.getColor()+"]]";
    }

    // Override the inherited getArea() to provide the proper implementation
    @Override
    public double getArea() {
        // TODO: CODE HERE
        return 0.5 * this.base * this.height;
    }
    // Overload method
    public double getArea(double base, double height) {
        // TODO: CODE HERE
        this.base = base;
        this.height = height;
        return 0.5 * base * height;
    }
}
