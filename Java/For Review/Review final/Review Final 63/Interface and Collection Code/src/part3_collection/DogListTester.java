package part3_collection;

import java.util.ArrayList;

public class DogListTester {

	public static void main(String[] args) {
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		Dog myDog = new Dog(12, "black");
		dogs.add(myDog);
		dogs.add(new Dog(10, "white"));
		
		System.out.println("Size: " + dogs.size());
		Dog dog0 = dogs.get(0);	// get dog at specific index
		System.out.println("Dog'color at index 0: " + dog0.getColor());
		System.out.println("Contains myDog:" + dogs.contains(myDog));
		
		System.out.println("\nShow color of all dogs");
		for(Dog d: dogs) {
			System.out.println(d.getColor());
		}
		
		System.out.println("\n-- Remove dog at index 0 --");
		dogs.remove(0);		// remove at specific index
		System.out.println("Size: " + dogs.size());
		System.out.println("Contains myDog:" + dogs.contains(myDog));
	}

}

class Dog {
	int age;
	String color;
	
	Dog(int age, String color){
		this.age = age;
		this.color = color;
	}
	
	String getColor() { 
		return this.color;
	}
	
}

/*
void setColor(String newColor) {
	this.color = newColor;
}*/
