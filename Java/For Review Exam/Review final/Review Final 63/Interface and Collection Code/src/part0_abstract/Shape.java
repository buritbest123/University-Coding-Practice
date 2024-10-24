package part0_abstract;

public abstract class Shape {
	String type;
	String color;
	
	Shape(String type, String color){
		this.type = type;
		this.color = color;
	}
	
	public abstract double getArea();
}
