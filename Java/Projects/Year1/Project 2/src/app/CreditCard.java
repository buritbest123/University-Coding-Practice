package app;

/**
 * Name: Burit Sihabut
 * Student ID: 6488079
 * Section: 1
 */

public class CreditCard extends Payment {

	// TODO 14: Complete class `CreditCard` that inherits Payment class.
	// 		 `CreditCard`:
	//			Subclass "private" instance variables:
	//			 - CardType type
	//			 - String number
	//
	//			Extra public interfaces
	//        	 - public String getFormattedCardNumber()	
	//					The card's number must be in the actual format with space between group of number based on card type
	// 
	//		    Overrided behaviors
	//			 - public boolean isValid() if card number is valid return true. Otherwise, return false
	//				For example: 
	//					if the card is VISA and has number "4234567890123456", this card is valid.
	//					If the card is JCB and has number "4234567890123456", this card is invalid. 
	//			 - public String log() return creditcard payment information
	//				For example: 
	//					"[VALID] CARD::3600.00::VISA::3434 567890 12345"
	//				
	
	// ============ Instance Variables ============
	public static enum CardType{ VISA, AMERICANEXPRESS, JCB, MASTERCARD }; 
					// different types of credit card 
		
	private CardType type;		// card's type
	private String number;		// card's number
	// ============================================

	
	// =============== Constructors ===============
	
	public CreditCard(double amount, CardType type, String number) {
		super("CARD", amount);
		this.type = type;
		this.number = number;		// i.e., 343456789012345
	}
	// ============================================
	
	
	/**
	 * Verify the validity of the card information. Different card type has different format of card number as follow
	 * VISA -> the number must be 16 digits, and start with number 4
	 * AMERICANEXPRESS -> the number must be 15 digits, and start with either 34 or 37
	 * JCB -> the number must be 16 digits, and start with 3528 to 3589
	 * MASTERCARD -> the number must be 16 digits, and start with 51 or 52
	 * 
	 * For example, if the card is VISA and has number "4234567890123456", this card is valid.
	 * If the card is JCB and has number "4234567890123456", this card is invalid.
	 * 
	 * @return True if the card is valid, otherwise return false
	 */
	@Override
	public boolean isValid() {
		// TODO 14.1: implement isValid() method to validate card number
		switch (type) {
			case VISA:
				if (this.number.charAt(0) == '4' && this.number.length() == 16) { // the number must be 16 digits, and start with number 4
					return true;
				}
			case AMERICANEXPRESS:
				if (this.number.length() == 15 && this.number.charAt(0) == '3') { // the number must be 15 digits, and start with either 34 or 37
					if (this.number.charAt(1) == '4' || this.number.charAt(1) == '7') { // 34 || 37
						return true;
					}
				}
			case JCB:
				if (this.number.length() == 16) { // the number must be 16 digits
					int startDigits = Integer.parseInt(number.substring(0,4)); // Convert String to int (4 Digits)
					if (startDigits >= 3528 && startDigits <=3589) {  // start with 3528 to 3589
						return true;
					}
				}
			case MASTERCARD:
				if (this.number.charAt(0) == '5' && this.number.length() == 16) { // the number must be 16 digits, and start with 51 or 52
					if (this.number.charAt(1) == '1' || this.number.charAt(1) == '2') { // 51 || 52
						return true;
					}
				}
		}
		return false;
	}
	
	
	/**
	 * If the card is valid, formats the card's number according to the card's type.
	 * AMERICANEXPRESS (15 digits): #### ###### ##### (4-6-5)
	 * VISA, JCB, MASTERCARD (16 digits): #### #### #### #### (4-4-4-4)
	 * 
	 * For example, if the card is VISA and has number "4234567890123456", 
	 * the string value "4234 5678 9012 3456" will be returned.
	 * 
	 * if the card is AMERICANEXPRESS and has number "343456789012345", 
	 * the string value "3434 567890 12345" will be returned.
	 * 
	 * If the card information is invalid, returns "invalid card number".
	 * 
	 * @return a string of formatted card's number | "invalid card number"
	 */
	public String getFormattedCardNumber() {
		// TODO 14.2: implement getFormattedCardNumber() to return card number in a beautify format				
		if (this.isValid()) {
			switch (this.type) {
				case VISA:
				case JCB:
				case MASTERCARD: // VISA, JCB, MASTERCARD (16 digits)
					return this.number.substring(0, 4) +" " + this.number.substring(4, 8) + " " + this.number.substring(8, 12) +" " + this.number.substring(12, 16);
				case AMERICANEXPRESS: // AMERICANEXPRESS (15 digits)
					return this.number.substring(0, 4) +" " + this.number.substring(4, 10) + " " + this.number.substring(10, 15);
			}
		}
		return "invalid card number";
	}
	
	/**
	 * @Override log
	 * return credit card payment information
	 * 
	 * For example, 
	 * 	"[VALID] CARD::3600.00::VISA::3434 567890 12345"
     * @return string to provide information of this payment
	 */
	public String log() { // This method get called by runtime, Use this method to return following format
		// TODO 14.3: implement log() method of credit card
		return (isValid() ? "[VALID] ":"[VOID] ") + "CARD" + "::" + df.format(amount)+ "::" + type +"::" + getFormattedCardNumber();
	}


}
