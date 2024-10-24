package app;

/**
 * Name: Burit Sihabut
 * Student ID: 6488079
 * Section: 1
 */


public class PaymentFactory {


	/**
	 * Crate a Payment object according to the given parameters
	 * 
	 * @param amount
	 *            total amount that need to be paid
	 * @param args
	 *            list of parameters depends on the payment type. For example, Cash
	 *            payment only requires cash tendered, while CreditCard payment
	 *            requires CardType, and card's number
	 * @return 
	 * 		Payment	
	 * @throws IllegalArgumentException
	 * 			  - if the payment type is unavailable => not [CASH|CARD],
	 * 			    throw IllegalArgumentException exception with a specific message 
	 * 				"xx is an unavailable payment type." where xxx is the unavailable input argument
	 * 
	 * 			  - if the card type is unavailable => not [VISA|AMERICANEXPRESS|JCB|MASTERCARD] 
	 * 			    throw IllegalArgumentException exception with a specific message 
	 * 				"xxx is an unavailable card type." where xxx is the unavailable input argument
	 * 
	 * @throws IndexOutOfBoundsException
	 * 			  - if the number of arguments is insufficient to construct the payment,
	 * 			    throw IndexOutOfBoundsException exception
	 * 			    For example, Cash payment needs 2 arguments: amount and cash value, 
	 * 							 CreditCard payment needs 3 arguments: amount, card's type, and card's number
	 * 
	 */
	public static Payment createPayment(double amount, String[] args)
			throws IllegalArgumentException, IndexOutOfBoundsException {

		String type = args[0];

		if (type.equalsIgnoreCase("CASH")) { // For Cash payment
			// TODO 15: Create `Cash` payment class by parsing arguments according to the
			// Cash constructor method
			if (args.length == 2) { // If args.length equal 2 do this block
				double cash = Double.parseDouble(args[1]); // Cast String to Double
				return new Cash(amount, cash); // Cash payment needs 2 arguments: (amount and cash)
			}
			else { // else, program said "Insufficient number of arguments for cash payment at index 1"
				throw new IndexOutOfBoundsException("1");
			}
		} else if (type.equalsIgnoreCase("CARD")) { // For CreditCard payment
			// TODO 16: Create `CreditCard` payment class by parsing arguments according to
			// the CreditCard constructor method
			if (args.length == 3) { // If args.length equal 3 do this block
				CreditCard.CardType cardType = null; // Set null to "cardType" objects
				if (args[1].equalsIgnoreCase("VISA")) cardType = CreditCard.CardType.VISA; // assignment cardType = VISA
				else if (args[1].equalsIgnoreCase("AMERICANEXPRESS")) cardType = CreditCard.CardType.AMERICANEXPRESS; // assignment cardType = AMERICANEXPRESS
				else if (args[1].equalsIgnoreCase("JCB")) cardType = CreditCard.CardType.JCB; // assignment cardType = JCB
				else if (args[1].equalsIgnoreCase("MASTERCARD")) cardType = CreditCard.CardType.MASTERCARD; // assignment cardType = MASTERCARD
				return new CreditCard(amount, cardType, args[2]); // return amount, card's type (cardType), and card's number
			}
			else { // For the card type is unavailable
				if (args.length >= 2 && !(args[1].equalsIgnoreCase("VISA") || args[1].equalsIgnoreCase("AMERICANEXPRESS") || args[1].equalsIgnoreCase("JCB") || args[1].equalsIgnoreCase("MASTERCARD"))) {
					throw new IllegalArgumentException(args[1] + " is an unavailable card type.");
				}
				else { // else, program said "Insufficient number of arguments for card payment at index 2"
					throw new IndexOutOfBoundsException("2");
				}
			}

		} else {
			// DO NOT MODIFY
			throw new IllegalArgumentException(type + " is an unavailable payment type.");
		}

	}
}