
public class Dog extends Animal {

	public Dog(int age) {
		super(age);
	}
	
	public Dog(int age, String color){
		super(age, color);
	}
	
	public void uniqueDog(){
		System.out.println("fewwwwwwww");
	}

	public String toString(){
		
		return "DOG" + super.toString();
	}

	@Override
	public void speak() {
		System.out.println("Bark Bark");
	}
	
}
