class Main {
  public static void main(String[] args) {
		Bird bird = new Bird("White");
		Airplane plane = new Airplane();
		
		bird.fly();
		plane.fly();

    // Uncomment below to test your Balloon class
    Balloon ball = new Balloon();
		ball.fly();

    // Uncomment below to test multiple interfaces in Airplane class
    if(plane instanceof Fixable){
      System.out.println("Expect: true, Actual: " + plane.fix(30));
      System.out.println("Expect: false, Actual: " + plane.fix(80));
    }
	}
}