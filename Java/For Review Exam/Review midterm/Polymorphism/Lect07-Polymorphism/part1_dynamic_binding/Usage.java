package part1_dynamic_binding;

public class Usage {

	public static void main(String[] args) {
		/*
		Animal a = new Animal("Olaf");
		a.greeting();
		
		Cat c = new Cat("Elsa");
		c.greeting();
		
		Dog d = new Dog("Pika");
		d.greeting();
		*/
		
		/*
		System.out.println("--------------------------");
		Animal a1 = new Animal("Olaf");
		a1.greeting();
		
		Animal a2 = new Cat("Elsa");
		a2.greeting();
		
		Animal a3 = new Dog("Pika");
		a3.greeting();
		
		
		System.out.println("--------------------------");
		Animal[] pets = new Animal[3];
		pets[0] = new Animal("Olaf");
		pets[1] = new Cat("Elsa");
		pets[2] = new Dog("Pika");
		
		for(Animal p: pets){
			p.greeting();
		}
		
		*/
		System.out.println("--------------------------");
		Animal a1 = new Animal("Olaf");
		a1.greeting();
		
		Animal a2 = new Cat("Elsa");
		((Cat) a2).chasing();
		
		Animal a3 = new Dog("Pika");
		((Dog) a3).catching();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
