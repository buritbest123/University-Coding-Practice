package part0_recall;

public class AnimalTester {
	public static void main(String[] args) {
		Animal myAnimal = new Animal("Unicorn", "White");
		myAnimal.print();
		
		Cat myCat = new Cat("Black");
		myCat.print();
		myCat.chase();
	}
}
