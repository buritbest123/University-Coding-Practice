package app;

/**
 * Name: Burit Sihabut
 * Student ID: 6488079
 */


public abstract class Payment implements Loggable {
	// This Payment class is abstract so it cannot be instantiated.
	// Later, you will have to complete Cash and CreditCard classes that inherit from this class.


	// ============ Instance Variables ============
	public double amount;	// amount to be paid
	public String method;	// name of the payment method e.g., CASH, CARD
	
	// ============================================
	
	
	// =============== Constructors ===============
	
	/**
	 * Constructor initializes the payment method's name and amount to be paid
	 * @param method
	 * @param amount
	 */
	public Payment(String method, double amount) { // Constructor "Payment" Parameters are (String method, double amount)
		// TODO 12: implement a constructor method of Payment class
		this.method = method;
		this.amount = amount;
	}

	// ============================================
	
	
	// DO NO MODIFY
	
	public String getMethod() {
		return method;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String log() {
		return (isValid()? "[VALID] ":"[VOID] ") + method + "::" + df.format(amount);
	}
	// ============================================
	
	/**
	 * Abstract method isValid()
	 * @return boolean
	 */
	public abstract boolean isValid();
	
	// ============================================
		
	
}
