package part3_collection;

import java.util.HashSet;

public class DogSetTester {

	public static void main(String[] args) {
		HashSet<Dog> dogs = new HashSet<Dog>();
		Dog myDog = new Dog(12, "black");
		dogs.add(myDog);
		dogs.add(new Dog(10, "white"));
		
		System.out.println("Size: " + dogs.size());
		System.out.println("Contains myDog:" + dogs.contains(myDog));
		
		System.out.println("\nShow color of all dogs");
		for(Dog d: dogs) {
			System.out.println(d.getColor());
		}
		
		System.out.println("\n-- Remove myDog --");
		dogs.remove(myDog);	// unlike, ArrayList, you cannot use index
		System.out.println("Size: " + dogs.size());
		System.out.println("Contains myDog:" + dogs.contains(myDog));
	}
}

