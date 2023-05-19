package part0_review;

public class CatTester {
	
	static int SLEEP_TIMES = 10;
	
	public static void main(String[] args){
		// create a Cat object named c1
		Cat c1 = new Cat("Elsa", "white", 15, 10);
		c1.display();
		
		c1.play();
		c1.play();
		System.out.println("------------------------");
		System.out.println("After playing");
		System.out.println("Energy Level: " + c1.getEnergy());	// 8
		System.out.println("Hungry Level: " + c1.getHungry());	// 17
		
		// create a Food object named f1
		Food f1 = new Food("Fish", 5);
		f1.printInfo();
		
		// create an EnergyDrink object named d1
		EnergyDrink d1 = new EnergyDrink("M-100", 1, 10);
		d1.printInfo();
		
		c1.feed(f1);	// Fish
		c1.feed(d1);	// M-100
		System.out.println("------------------------");
		System.out.println("After feeding");
		System.out.println("Energy Level: " + c1.getEnergy());	// expected: 18
		System.out.println("Hungry Level: " + c1.getHungry());	// expected: 11
	}
}






