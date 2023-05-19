// Exercise: 
// Make this class extends Shape superclass and resolve any error

public class Square extends Shape {
  // subclass instance variables
  double width;
  
  public Square(String color, double width){
    // YOUR CODE GOES HERE
    super("Square",color);
    this.width = width;
  }

  // YOUR CODE GOES HERE
  @Override
  public double getArea() {
    return width * width;
  }
}