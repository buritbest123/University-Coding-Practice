package part2_casting;

public class Usage {

	public static void main(String[] args) {
		Animal[] pets = new Animal[3];
		pets[0] = new Animal("Olaf");
		pets[1] = new Cat("Elsa");
		pets[2] = new Dog("Pika");
		
		for(Animal p: pets){
			p.greeting();
			if(p instanceof Cat){
				((Cat) p).chasing();
			}
		}
	}

}
