// ID: 6388132
// Name: Pawaris Techahongsa
// Section: 3

/**
 * This SaktingRobot class must extend the Robot Class
 *
 */

public class SkatingRobot extends Robot {

	// ----------------------------------
	// Additional instance fields go here
	private char direction;
	// ----------------------------------
	// Facing direction either N, E, S, or W

	public SkatingRobot(String _name, int _x, int _y, char _direction) {
		// Your code goes here
		super(_name, _x, _y);
		this.direction = _direction;
	}

	public SkatingRobot(String _name, char _direction) {
		// Your code goes here
		super(_name);
		this.direction = _direction;
	}

	/**
	 * @return current direction
	 */
	public char getDirection() {
		// Your code goes here
		return this.direction;
	}

	/**
	 * Turns the robot 90 degrees clockwise e.g., the direction 'N' changes to 'E',
	 * 'E' changes to 'S' and so on...
	 * 
	 * @return the new direction
	 */
	public char turnClockWise() {
		// Your code goes here
		if (direction == 'N') {
			direction = 'E';
		} else if (direction == 'E') {
			direction = 'S';
		} else if (direction == 'S') {
			direction = 'W';
		} else {
			direction = 'N';
		}

		return this.direction;
	}

	/**
	 * Turns the robot 90 degrees counterclockwise e.g., the direction 'N' changes
	 * to 'W', 'W' changes to 'S' and so on...
	 * 
	 * @return the new direction
	 */
	public char turnCounterClockWise() {
		// Your code goes here
		if (direction == 'N') {
			direction = 'W';
		} else if (direction == 'W') {
			direction = 'S';
		} else if (direction == 'S') {
			direction = 'E';
		} else {
			direction = 'N';
		}

		return this.direction;
	}

	/**
	 * The robot skates in the direction that it is facing at the given speed. As a
	 * result, the location x or y is changing.
	 * 
	 * For example, if the robot is currently at location (0, 0) facing 'N'
	 * direction and the speed is 5, then the location y is increased by 5.
	 * 
	 * @throws IllegalArgumentException if the speed is less than or equals to 0.
	 *                                  The message is "Invalid speed (must be
	 *                                  positive number)".
	 * 
	 * @return the new location as string -> (location x, location y) e.g., "(0, 5)"
	 */
	public String skate(int speed) throws IllegalArgumentException {
		// Your code goes here
		if (speed <= 0)
			throw new IllegalArgumentException("must be positive number");
		if (direction == 'N') {
			setLocation(getLocX(), getLocY() + speed);
		} else if (direction == 'E') {
			setLocation(getLocX() + speed, getLocY());
		} else if (direction == 'S') {
			setLocation(getLocX(), getLocY() - speed);
		} else {
			setLocation(getLocX() - speed, getLocY());
		}
		return String.format("(%d, %d)", getLocX(), getLocY());
	}

	/**
	 * The robot turns into a given direction and skates in that direction at the
	 * given speed.
	 * 
	 * For example, if the robot is currently at location (0, 0) facing 'N'
	 * direction, and the given direction is 'S' and the speed is 5, then the
	 * location y will be decreased by 5. The new location will be (0, -5)
	 * 
	 * @throws IllegalArgumentException if the given direction is invalid. The
	 *                                  message is "Invalid direction (N, S, E, and
	 *                                  W only)".
	 * 
	 * @return the direction and location as string -> direction (location x,
	 *         location y) e.g., "N (0, 5)"
	 */
	public String skate(char newDirection, int speed) throws IllegalArgumentException {
		// Your code goes here
		if (newDirection != 'N' && newDirection != 'E' && newDirection != 'S' && newDirection != 'W') {
			throw new IllegalArgumentException("Invalid direction (N, S, E, and W only");
		}
		this.direction = newDirection;
		skate(speed);

		return String.format("%c (%d, %d)", newDirection, getLocX(), getLocY());
	}

	/**
	 * @return information of this SkatingRobot (see the expected output)
	 */
	public String toString() {
		// Your code goes here
		return String.format("%s is at location (%d, %d) and facing at direction %c", getName(), getLocX(), getLocY(),
				getDirection());
	}
}