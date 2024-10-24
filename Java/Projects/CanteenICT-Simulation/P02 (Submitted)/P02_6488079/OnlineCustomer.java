ฺpackage app;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Name: Burit Sihabut
 * Student ID: 6488079
 * Section: 1
 */


public class OnlineCustomer extends Customer {
	
	// TODO 03: Complete class `OnlineCustomer` that inherits Customer class.
	// 		 `OnlineCustomer`:
	//			Subclass "private" instance variables:
	//			- email 
	//			- zipcode 
	//			- SHIPPING <String, double> table storing shipping fee according to the zipcode
	//			Extra public interfaces
	//        	- public OnlineCustomer(String name, String email, String zipcode)
	//			- public String getEmail()
	// 			- public String getZipCode()
	//			- public double getShippingFee() returns 
	//		   Overrided behaviors
	//			- public String log() will also return email and zipcode in parenthesis
	//				For example: "2: Siripen Pongpaichet (siripen.pon@mahidol.edu, 73170)"
	//			- Public boolean equals()


	
	// ============ Instance Variables ============
	// This map table store the key value pair of zipcode and shipping fee
	private static final Map<String, Double> SHIPPING;  // - SHIPPING <String, double> table storing shipping fee according to the zipcode
	static {
		SHIPPING = new HashMap<>();
		SHIPPING.put("73170",  50.0);
		SHIPPING.put("10700",  20.0);
		SHIPPING.put("50230", 210.0);
		SHIPPING.put("83120", 250.0);
		SHIPPING.put("20120", 150.0);
	}
		
	private String email = ""; // - email
	private String zipcode = ""; // - zipcode
	
	
	// ============================================
	
	
	
	// ============== DO NOT MODIFY ===============
	
	public OnlineCustomer(String name, String email, String zipcode) { // + public OnlineCustomer(String name, String email, String zipcode)
		super(name);
		this.email = email;
		this.zipcode = zipcode;
	}
	
	public String getEmail() {
		return email;
	} // + public String getEmail()
	
	public String getZipcode() { // + public String getZipCode()
		return zipcode;
	}

	// ============================================


	// =========== YOUR CODE GOES HERE ===========
	
	/**
	 * Lookup for the shipping fee from the SHIPPING table based on the customer's zipcode,
	 * if the zipcode doesn't exist, returns 99.00 as a default shipping fee.
	 * @return shipping fee 
	 */
	public double getShippingFee() { // + public double getShippingFee() returns
		// TODO 04: Implement getShippingFee() method for this class
		if (SHIPPING.containsKey(this.getZipcode())) { // The method takes just one parameter (key_element "Zipcode") that refers to the key whose mapping is supposed to be checked inside a (map "SHIPPING").
			return SHIPPING.get(this.getZipcode()); // returns "Zipcode" if that element is mapped in the (map "SHIPPING").
		}
		return 99.00;  // if the zipcode doesn't exist, returns 99.00 as a default shipping fee.
	}

	@Override
	public String log(){ // Return following format: "ID: Name (Email, Zipcode)"
		return this.getCustomerID() + ": " + this.getName() + " (" + this.getEmail() +", "+this.getZipcode()+")";
	}

	// The equals(Object o) method returns true when the value of the private data instance variables
	// (i.e., email and zipcode)
	// between two OnlineCustomer objects are the same. Return false, otherwise.
	@Override
	public boolean equals(Object o) { // Use this method to check element is equal or not | e.g. email == email or zipcode == zipcode
		if (this == o) { // To check all elements
			return true;
		}
		if (!(o instanceof OnlineCustomer that)){ // To check (Object o) is reference to OnlineCustomer or not
			return false;
		}
		return super.getName().equals(((OnlineCustomer) o).getName()) && Objects.equals(email, that.email) && Objects.equals(zipcode, that.zipcode);
	}

}