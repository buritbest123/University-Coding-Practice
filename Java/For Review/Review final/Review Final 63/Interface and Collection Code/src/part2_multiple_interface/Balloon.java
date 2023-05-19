package part2_multiple_interface;

public class Balloon implements Skyability, Fixable{

	@Override
	public void fly() {
		System.out.println("Flying with hot-air");
	}

	@Override
	public boolean fix() {
		System.out.println("Fixing hot-air balloon");
		return true;
	}
}


