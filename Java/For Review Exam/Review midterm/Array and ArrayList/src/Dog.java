
public class Dog {

  // instance variables
	private int age;
	public String color;

	public Dog(int age, String color){
		this.age = age;
    this.color = color;
	}

  public void setColor(String newColor){
		color = newColor;
	}
	
	public void setAge(int age){
		this.age = age;
		
	}
  
	public int getAge(){
		return age;
	}
  
	public String toString(){
		return "DOG[" + age + "," + color + "]";
	}

	public void speak() {
		System.out.println("Bark Bark");
	}
	
}
