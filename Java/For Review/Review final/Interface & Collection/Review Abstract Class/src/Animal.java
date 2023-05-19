// Since this class contains an abstract method,
// this class has to be declared as abstract class as well.

public abstract class Animal {
	public String type;
	public String color;
	
	public Animal(String type, String color){
		this.type = type;
		this.color = color;
	}
		
	public void print() {
		System.out.println(color + " " + type);
	}

  // abstract method
	public abstract void speak();
}

