package part2_multiple_interface;

public class Airplane implements Skyability, Fixable{

	@Override
	public void fly() {
		System.out.println("Flying with engines");
	}

	@Override
	public boolean fix() {
		System.out.println("Fixing airplane");
		System.out.println(Fixable.ERROR);
		return false;
	}
}

