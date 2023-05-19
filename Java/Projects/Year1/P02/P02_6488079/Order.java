package app;
/**
 * Name: Burit Sihabut
 * Student ID: 6488079
 */

import java.util.ArrayList;
import java.util.Objects;

public class Order implements Loggable {

	// ============ Instance Variables ============
	public static int runningID = 0;

	private int orderID;
	private Customer customer;
	private ArrayList<Item> items;
	private Payment payment;
	// ============================================

	// =============== Constructors ===============

	/**
	 * Constructor to initialize orderID according to the running ID
	 * The first order's ID is 1. The second order's ID is 2, and so on.
	 *
	 * @param c : Customer
	 */
	public Order(Customer c) {
		// TODO 17: Implement a constructor method of Order
		this.customer = c;
		this.orderID = runningID; // The first order's ID is 1.
		runningID++; // The second order's ID is 2, and so on.
		this.items = new ArrayList<Item>(); // Order can now manage items by ArrayList
		payment = null;  // always set Customer (c) null at the beginning
	}

	// ============================================

	//  ============= DO NOT MODIFY  =============

	public int getOrderID() {
		return orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int numItems() {
		return this.items.size();
	}

	public Payment getPayment() {
		return this.payment;
	}

	public boolean checkPaymentStatus() {
		if (payment != null) {
			return this.payment.isValid();
		} else {
			return false;
		}
	}

	@Override
	public boolean equals(Object object) {
		Order o = (Order) object;
		return this.log().equalsIgnoreCase(o.log());
	}

	// ============================================

	/**
	 * Return total price of all items in the `items` array list.
	 * If the customer is an OnlineCustomer, include his shipping fee into the total too.
	 * Note that if there is no order, nothing to ship, the total price will always be zero.
	 *
	 * @return
	 */
	public double getTotalPrice() {
		// TODO 18: Implement getTotalPrice() method
		double TotalPrice = 0; // Initialization TotalPrice = 0;
		if (!(customer instanceof OnlineCustomer)) { // To check customer is OnlineCustomer or not
			for (Item item : items) { // This for each loop will calculate total, then get TotalPrice
				TotalPrice += item.getTotal();
			}
		} else { // OnlineCustomer
			for (Item item : items) { // This for each loop will calculate total, then get TotalPrice
				TotalPrice += item.getTotal();
			}
			TotalPrice += ((OnlineCustomer) customer).getShippingFee(); // the customer is an OnlineCustomer, include his shipping fee into the total too.
		}
		if (items.size() == 0) { // If items.size == 0
			return 0;
		}
		return TotalPrice;
	}

	/**
	 * Return an item in the `items` array list if the `name` exists
	 * otherwise return null
	 *
	 * @param name
	 * @return Item | null
	 */
	public Item findItem(String name) {
		// TODO 19: Implemenent findItem(String name) method
		for (Item item : items) {
			if (Objects.equals(item.getName(), name)) { // To check itemName equal name (parameter)
				return item; // return item
			}
		}
		return null;
	}


	/**
	 * Add `newItem` to the `items` array list.
	 * If the name exists, add only the quantity to the existing item, ignoring the price.
	 * Otherwise add `newItem` as an object.
	 * <p>
	 * For example:
	 * items:
	 * 0: Sinovac 1 doses
	 * <p>
	 * Add Sinovac 1 doses
	 * -> items:
	 * 0: Sinovac 2 doses
	 * Add AstraZeneca 1 doses
	 * -> items:
	 * 0: Sinovac 2 doses
	 * 1: AstraZeneca 1 doses
	 *
	 * @param newItem
	 */
	public void addItem(Item newItem) {
		// TODO 20: Implement addItem(Item newItem) method
		boolean duplicateName = false; // Initialize (boolean) duplicate = false;
		for (Item item : items) { // This for-each loop will go every element
			if (Objects.equals(item.getName(), newItem.getName())) { // To check nameItem is equal to nameNewItem
				item.setQuantity(item.getQuantity() + newItem.getQuantity()); // Then, add Quantity to QuantityItem
				duplicateName = true;
			}
		}
		if (!duplicateName) { // If no duplicate, then add another newItem
			items.add(newItem);
		}
	}

	/**
	 * Add an item using `barcode`. See `addItem(Item newItem)`	for the documentation
	 * The `barcode` of items is defined in `ItemFactory`
	 *
	 * @param barcode
	 * @param quantity
	 */
	public void addItem(int barcode, int quantity) {
		// TODO 21: Implement addItem(int barcode, int quantity) method
		// Hint:
		// - Use ItemFactory to create an item
		// - Use the above method addItem(Item newItem) to add the item
		Item newItem = ItemFactory.createItem(barcode, quantity); // Create newItem by using object "Item"
		addItem(newItem);  // Then, addItem put newItem as an argument
	}

	/**
	 * Reduce `reducingItem` to the `items` array list.
	 * If the name exists, reduce the quantity to the existing item.
	 * Otherwise do nothing.
	 * <p>
	 * After the reduction, if the quantity is less than or equal to 0,
	 * remove the item from the list.
	 * <p>
	 * <p>
	 * For example:
	 * items:
	 * 0: Sinovac 2 doses
	 * <p>
	 * Reduce Sinovac 1 doses
	 * -> items:
	 * 0: Sinovac 1 doses
	 * Reduce Sinovac 1 doses
	 * -> items: (empty)
	 *
	 * @param reducingItem
	 */
	public void reduceItem(Item reducingItem) {
		// TODO 22: Implement reduceItem(Item reducingItem) method
		int reduceQuantity = -1; // Initialization reduceQuantity = -1;
		for (Item item : items) {  // This for-each loop will go every element
			if (Objects.equals(item.getName(), reducingItem.getName())) {  // To check nameItem is equal to nameNewItem
				item.setQuantity(item.getQuantity() - reducingItem.getQuantity());  // Then, reduce the quantity to the existing item.
			}
			if (item.getQuantity() <= 0) { // if the quantity is less than or equal to 0
				reduceQuantity = items.indexOf(item);
			}
		}
		if (reduceQuantity != -1) {
			items.remove(reduceQuantity); // remove the item from the list.
		}
	}

	/**
	 * Reduce item using `barcode`. See `reduceItem(Item reducingItem)` for the documentation.
	 * The `barcode` of items is defined in `ItemFactory`
	 *
	 * @param barcode
	 * @param deductQuantity
	 */
	public void reduceItem(int barcode, int deductQuantity) {
		// TODO 23: Implement reduceItem(int barcode, int deductQuantity) method
		Item reducingItem = ItemFactory.createItem(barcode, deductQuantity); // Reduce Item by using object "Item"
		reduceItem(reducingItem); // Then, reduceItem put reducingItem as an argument
	}


	/**
	 * Set a payment method for this order
	 *
	 * @param args
	 */

	public void setPayment(String[] args) {
		// TODO 24: Implement setPayment(String type, Object[] params) method 
		// Hint:
		// - Use PaymentFactory to create an payment object
		// - Use getTotalPrice() to get an total order amount
		this.payment = PaymentFactory.createPayment(getTotalPrice(), args); // Set payment
	}


	/**
	 * Return a string representation of an order
	 * <p>
	 * Example:
	 * Customer: 1: Siripen Pongpaichet
	 * - Sinovac\t3000.00\t2 (doses)\t6000.00
	 * - AstraZeneca\t300.00\t1 (doses)\t300.00
	 * Total: 6300.00
	 * [VALID] CASH::6300::7000::700
	 * <p>
	 * If there is not payment yet, return [PENDING] in the last line
	 * <p>
	 * Example:
	 * Customer: 1: Siripen Pongpaichet
	 * - Sinovac\t3000.00\t2 (doses)\t6000.00
	 * - AstraZeneca\t300.00\t1 (doses)\t300.00
	 * Total: 6300.00
	 * [PENDING]
	 *
	 * @return String
	 */
	public String log() {
		// TODO 25: Implement log() method for Order class.
		String format = "";
		for (Item item : items) { // This for-each loop will go every element
			format += "- " + item.log() + "\n";
		}
		if (payment != null) { // If payment is not null
			return "Customer: " + customer.log() + "\n" + format + "Total: " + df.format(getTotalPrice()) + "\n" + payment.log();
		} else {
			return "Customer: " + customer.log() + "\n" + format + "Total: " + df.format(getTotalPrice()) + "\n" + "[PENDING]";
		}
	}
		// ============================================
}