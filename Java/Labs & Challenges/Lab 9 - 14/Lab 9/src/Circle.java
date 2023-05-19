public class Circle extends Shape{
    // Private member variables
    // TODO: CODE HERE
    private double radius;
    public Circle(){
        super();
        radius = 0.0;
    }

    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    @Override
    public String toString() {
        // TODO: CODE HERE
        return "Circle[radius="+radius+", Shape[color="+super.getColor()+"]]";
    }

    // Override the inherited getArea() to provide the proper implementation
    @Override
    public double getArea() {
        // TODO: CODE HERE
        double area = 3.14 * (this.radius * this.radius);
        return area;
    }

    public double getArea(double radius) {
        // TODO: CODE HERE
        this.radius = radius;
        double area = 3.14 * (this.radius * this.radius);
        return area;
    }
}
