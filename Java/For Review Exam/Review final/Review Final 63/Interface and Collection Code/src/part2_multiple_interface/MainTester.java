package part2_multiple_interface;

public class MainTester {
	public static void main(String[] args) {
		Bird bird = new Bird("White");
		Airplane plane = new Airplane();
		Balloon ball = new Balloon();
		
		bird.fly();
		plane.fly();
		ball.fly();
		
		plane.fix();
		ball.fix();
	}
}
