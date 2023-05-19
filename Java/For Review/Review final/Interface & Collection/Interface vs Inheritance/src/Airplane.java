// Exercise:
// Make this Airplane implements another interface class named "Fixable"

public class Airplane implements Skyability, Fixable{

	@Override
	public void fly() {
		System.out.println("Flying with engines");
	}

  // Implement fix(...) method
  // If the damage level is less than 50, returns true
  // Otherwise, print ERROR message from the Fixable interface and returns false
  public boolean fix(int damageLevel){
    if(damageLevel < 50)
      return true;
    else {
      System.out.println(Fixable.ERROR); // print "Cannot fix"
      return false;
    }
  }
}
