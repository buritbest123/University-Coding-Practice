// Exercise:
// Make this class implements Skyability
// For the fly() method, print this message on the console "Flying with hot-air"

public class Balloon implements Skyability, Fixable {

  public void fly(){
    System.out.println("Flying with hot-air");
  }

  public boolean fix(int level){
    return true;
  }

}
