public class Square extends Shape{
    // Private member variables
    // TODO: CODE HERE
    private double length;
    public Square(){
        super();
        length = 0.0;
    }

    public Square(String color, double length){
        super(color);
        this.length = length;
    }

    @Override
    public String toString() {
        // TODO: CODE HERE
        return "Square[radius="+length+", Shape[color="+super.getColor()+"]]";
    }

    // Override the inherited getArea() to provide the proper implementation
    @Override
    public double getArea() {
        // TODO: CODE HERE
        double area = Math.pow(length, 2);
        return area;
    }

    public double getArea(double length) {
        // TODO: CODE HERE
        this.length = length;
        double area = Math.pow(length, 2);
        return area;
    }
}
