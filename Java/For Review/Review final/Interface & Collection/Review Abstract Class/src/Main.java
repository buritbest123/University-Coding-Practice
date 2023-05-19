class Main {
  public static void main(String[] args) {
      /* Animal myAnimal = new Animal("Unicorn", "White"); // ! Abstract class cannot be instantiated !
                       ERROR!!! You cannot construct an abstract class                            */

		Cat myCat = new Cat("Black");
		myCat.print();
        myCat.speak();
		myCat.chase();

        Dog myDog = new Dog("Brown");
        myDog.print();
        myDog.speak();
        myDog.catching();

        Bird myBird= new Bird("White");
        myBird.print();
        myBird.speak();
        myBird.fly();

    // Uncomment these statements below to test your Square class
    Square myBox = new Square("White", 5);
    System.out.print("myBox area is " + myBox.getArea());
	}
}