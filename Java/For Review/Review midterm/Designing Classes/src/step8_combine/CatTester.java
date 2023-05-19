package step8_combine;

public class CatTester {
	
	static int SLEEP_TIMES = 10;
	
	public static void main(String[] args){
		
		Cat.begin();	// call static method
		
		// create a Cat object named c1
		Cat c1 = new Cat("Silver", "gray", 15, 20);
		
		// create a Cat object named c2
		Cat c2 = new Cat("Elsa", "white", 5, 10);
		
		// create a Food object named f1
		Food f1 = new Food("Fish", 10);
		f1.printInfo();
		
		// create a Food object named f2
		Food f2 = new Food("Cookie", 5);
		f2.printInfo();
		
		/*
		 * Start playing with c1 Cat 
		 */
		c1.displayCat();
		while(c1.isAlive()){	// keep playing until energy = 0
			c1.play();
		}
		System.out.println("------------------------");
		System.out.println("After playing");
		System.out.println("Energy Level: " + c1.getEnergy());	// 0
		System.out.println("Hungry Level: " + c1.getHungry());	// 35
		
								// sleep for SLEEP_TIMES times
		for(int i = 0; i < SLEEP_TIMES; i++){
			c1.sleep();
		}
		System.out.println("------------------------");
		System.out.println("After sleeping");
		System.out.println("Energy Level: " + c1.getEnergy());	// 10
		System.out.println("Hungry Level: " + c1.getHungry());	// 45
		
		c1.feedFood(f1);	// 10
		c1.feedFood(f2);	// 5
		c1.feedFood(f1);	// 10
		System.out.println("------------------------");
		System.out.println("After feeding");
		System.out.println("Energy Level: " + c1.getEnergy());	// 10
		System.out.println("Hungry Level: " + c1.getHungry());	// 20
		c1.printFoods();
		
		/*
		 * Start playing with c2 Cat 
		 */
		c2.displayCat();
		c2.feedFood(f1);	// 10
		c2.feedFood(f2);	// 5
		System.out.println("------------------------");
		System.out.println("After feeding");
		System.out.println("Energy Level: " + c2.getEnergy());	// 10
		System.out.println("Hungry Level: " + c2.getHungry());	// 0
		c2.printFoods();
	}
}






