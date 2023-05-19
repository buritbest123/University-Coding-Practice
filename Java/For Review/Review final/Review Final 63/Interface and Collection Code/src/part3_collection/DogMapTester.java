package part3_collection;

import java.util.HashMap;
import java.util.Set;

public class DogMapTester {

	public static void main(String[] args) {
		HashMap<String, Dog> dogs = new HashMap<String,Dog>();
		Dog myDog = new Dog(12, "black");
		dogs.put("Foo", myDog);
		dogs.put("Bar", new Dog(10, "white"));
		
		System.out.println("Size: " + dogs.size());
		System.out.println("Contains dog's name Foo:" 
							+ dogs.containsKey("Foo"));

		System.out.println("\nShow all keys in dogs map");
		Set<String> keys = dogs.keySet();
		for(String k: keys) {
			System.out.println("Key in dogs.keySet() " + k);
		}
		
		System.out.println("\nShow color of all dogs");
		for(String key: dogs.keySet()) {
			Dog d = dogs.get(key);
			System.out.println(d.getColor());
		}
		
		System.out.println("\n-- Remove myDog --");
		dogs.remove("Foo");	// remove with specific key
		System.out.println("Size: " + dogs.size());
		System.out.println("Contains myDog:" + dogs.containsKey("Foo"));
	}
}




