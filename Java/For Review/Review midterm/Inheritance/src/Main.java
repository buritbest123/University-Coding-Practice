import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ArrayList<Animal> lists = new ArrayList<Animal>();
		lists.add(new Dog(2, "black"));
		lists.add(new Cat(3));
		lists.add(new Dog(4, "black"));
		lists.add(new Cat(5));
    lists.add(new Rabbit(5, "brown","carrot"));
		
		for(Animal a: lists){
			if(a instanceof Dog)
				((Dog)a).uniqueDog();
		}
		
		System.exit(0);	// to exit
		
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		
		// create a dog object 
		Dog dd = new Dog(2, "brown");
		dogs.add(dd);
		
		dogs.add(new Dog(2, "brown"));
		
		Dog b = dogs.get(2);
		
		// replace dog at index 2 with a new dog
		dogs.set(2, dd);
		
		// increase dogs' age by 1 month
		for(Dog d: dogs){
			//d.age = d.age + 1;
      		String x = d.color;
      		String y = Dog.color;
      
			if(d.color == "blue"){
				d.setAge(d.getAge() + 1);
			}
		}
  }
}