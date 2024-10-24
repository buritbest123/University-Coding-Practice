//Name: Burit Sihabut
//ID: 6488079
//Section: 1

import java.util.ArrayList;
import java.util.List;

public class Customer {

	//*********************** DO NOT MODIFY ****************************//
	public static enum CustomerType{DEFAULT, STUDENT, PROFESSOR, ATHLETE, ICTSTUDENT};	//Different types of customers
	private static int customerRunningNumber = 1;	//static variable for assigning a unique ID to a customer
	private CanteenICT canteen = null;	//reference to the CanteenICT object
	private int customerID = -1;		//this customer's ID
	protected CustomerType customerType = CustomerType.DEFAULT;	//the type of this customer, initialized with a DEFAULT customer.
	protected List<FoodStall.Menu> requiredDishes = new ArrayList<FoodStall.Menu> ();	//List of required dishes
	//*****************************************************************//
	// Precomputed
	public static List<List<FoodStall.Menu>> customerTypeRequirement = new ArrayList<List<FoodStall.Menu>>();
	private int state;			 // Declaration (int) "state"
	protected int eating_time;     // Declaration (int) "eating_time"
	FoodStall myFS;              // New FoodStall named "myFS"
	Table myTB;                  // New Table named "myTB"

	Customer(CanteenICT _canteen)
	{
		//******************* YOUR CODE HERE **********************
		state = 1;											  // Customer go in waitToEnterQueue
		this.canteen = _canteen;                              // Initialize canteen
		this.customerID = customerRunningNumber;              // Initialize customer ID
		customerRunningNumber++;                              // Unique customer ID
		this.requiredDishes.add(FoodStall.Menu.NOODLES); 	  // Add menu "NOODLES" to requireDishes
		this.requiredDishes.add(FoodStall.Menu.DESSERT);	  // Add menu "DESSERT" to requireDishes
		this.requiredDishes.add(FoodStall.Menu.MEAT);		  // Add menu "MEAT" to requireDishes
		this.requiredDishes.add(FoodStall.Menu.SALAD);		  // Add menu "SALAD" to requireDishes
		this.requiredDishes.add(FoodStall.Menu.BEVERAGE);	  // Add menu "BEVERAGE" to requireDishes
		myFS = null;                                           // Set FoodStall named "myFS" = null
		myTB = null;                                           // Set Table named "myTB" = null
		for (FoodStall.Menu dish : this.requiredDishes){       // Use this loop
			eating_time += FoodStall.EAT_TIME[dish.ordinal()]; // To look in eating_time
		}
		//*****************************************************
	}

	public void takeAction()
	{
		//************************** YOUR CODE HERE **********************//

		if (this.state == 1) { // Currently, in wait to enter queue
			// Check if I am the first customer or not, but before go that
			if (canteen.getWaitToEnterQueue() != null &&              // Check WaitToEnterQueue != null and WaitToEnterQueue != empty
					!canteen.getWaitToEnterQueue().isEmpty() &&
					canteen.getWaitToEnterQueue().get(0).equals(this)) {
				FoodStall SL = this.canteen.getFoodlist().get(0);     // Set the shortest line (SL) in FoodStall
				for (FoodStall find_shortest : canteen.getFoodlist()) {
					if (find_shortest.getCustomerQueue().size() < SL.getCustomerQueue().size()) {
						SL = find_shortest; // If it has any stalls that shorter than the first one, It will set to the shortest line
					}
				}
				// If all menus are available and CustomerQueue is less than FoodStall.MaxQueue
				// then set this FoodStall to the shortest line , and it's ready to sell.
				if (SL.getMenu().containsAll(this.requiredDishes) && SL.getCustomerQueue().size() < FoodStall.MAX_QUEUE){
					myFS = SL;
				}
				else { // If myFS is not ready to sale
					myFS = null;
				}
				if (this.myFS != null) { // Customer found the Stall this means if myFS is empty add this customer to queue
					this.myFS.customerQueueNext.add(this);
					state = 2; // move to state 2
				}
				else { // If customer can't find Stall because it's full (unavailable).
					this.canteen.waitToEnterQueueNext.add(this);  // So, go to waitToEnterQueueNext
				}
			} else { // Not the first queue customer so, go to waitToEnterQueueNext
				this.canteen.waitToEnterQueueNext.add(this);
			}
		}
		else if (this.state == 2) { // Currently, in wait to order
			if (myFS.getCustomerQueue().get(0).equals(this) && myFS.isWaitingForOrder()) { // For the first customer and if the customer wait for order
				// (For each loop, when the first customer goes to the state 3,
				// the second customer will be the first customer for every state).
					myFS.takeOrder(this.requiredDishes);       // take order
					state = 3; // move to state 3
			}
		}
		else if (this.state == 3) { // Currently, in ordering
			if (myFS.getCustomerQueue().get(0).equals(this) && myFS.isReadyToServe()) { // First customer and if meal ready to serve
					myFS.serve();                              // serve
					myFS.customerQueueNext.remove(this);    // remove the customerQueue
					canteen.waitToSeatQueueNext.add(this);     // go to waitToSeatQueue
					state = 4; // move to state 4
			}
		}
		else if (this.state == 4) { // Currently, in wait to set
			if (canteen.getWaitToSeatQueue().get(0).equals(this)) {
				for (Table full_table : canteen.getTables()) {  // Find every table
					if (!full_table.isFull()) {                 // If table is not full
						myTB = full_table; 					    // This table is available to seat
						break;
					}
				}
				if (myTB != null) {                              // In the table it has at least one people
					myTB.seatedCustomersNext.add(this);          // Go seated
					canteen.waitToSeatQueueNext.remove(this); // Remove the waitToSeatQueue
					state = 5; // move to state 5
				}
			}
		}
		else if (this.state == 5) { // Currently, in eating and it's going to done
			eating_time -= 1; 							  // every customer come at state (5) eating time repeats minus 1 (-1)
			if (eating_time == 0) {                       // Eat everything until finished
				myTB.seatedCustomersNext.remove(this); // Get out of seated
				canteen.getDoneQueue().add(this);         // Finished
				state = 6; // move to state 6 (Done)
			}
		}
		//**************************************************************//

	}

	//***************For hashing, equality checking, and general purposes. DO NOT MODIFY **************************//

	public CustomerType getCustomerType()
	{
		return this.customerType;
	}

	public int getCustomerID()
	{
		return this.customerID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerID != other.customerID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerType=" + customerType +"]";
	}

	public String getCode()
	{
		return this.customerType.toString().charAt(0)+""+this.customerID;
	}

	/**
	 * print something out if VERBOSE is true
	 * @param str
	 */
	public void jot(String str)
	{
		if(CanteenICT.VERBOSE) System.out.println(str);

		if(CanteenICT.WRITELOG) CanteenICT.append(str, canteen.name+"_state.log");
	}

	//*************************************************************************************************//

}
