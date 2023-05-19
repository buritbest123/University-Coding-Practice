package app;
/**
 * Name: Burit Sihabut
 * Student ID: 6488079
 * Section: 1
 */


public class Customer implements Loggable {
	
    // ============ Instance Variables ============
    private static int runningID = 0;

    private int customerID;
    private String name;
    // ============================================

    
    // =============== Constructors ===============
    /**
	 * Constructor initializes the customer's name.
	 * The customer's ID will be automatically assigned according to the running ID.
	 * The first customer will have ID as 1, and the second customer will have ID as 2, and so on
	 * @param name
	 */
	public Customer(String name) { // Constructor "Customer" Parameters are (String name)
		// TODO 01: Implement constructor method for Customer class according to the document.
		this.name = name; // Initializes the customer's name.
		this.customerID = Customer.runningID; // The first customer always have ID as 1 | Currently, ID is 1
											  // The second customer will have ID as 2, and so on | RunningID
	}
    // ============================================

	
    //  ============= Public Methods  =============
    public int getCustomerID() {
		return this.customerID;
	}

	public String getName() {
		return name;
	}
	

	/**
	 * Return ID and name in the following format
	 * 		<ID>: <Name>
	 * Examples:
	 * 	- 0: Siripen Pongpaichet
	 *
	 * @return a String representation of customer
	 */
	public String log() { // This method get called by runtime, Use this method to return following format
		// TODO 02: Implement log() method for Customer class.
		return this.customerID + ": " + this.name; // Return : "<ID>: <Name>"
	}
    // ============================================
}
