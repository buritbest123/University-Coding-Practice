package part0_understanding; // ***DO NOT PUT PACKAGE IN YOUR EXAM***

////////////////////////////////////////////////////////////
//DO NOT MODIFY THIS CLASS
////////////////////////////////////////////////////////////

public class Card {
	
	private final int value;
	private final int suit;
	
	/**
	 *  Constructor
	 */
	public Card(int value, int suit) {
		this.value = value;
		this.suit = suit;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getSuit() {
		return this.suit;
	}
	
	public String toString() {
		return "CARD:" + this.value;
	}
	
	public String getValueAsString() {
		if(value == 1)	return "Ace";
		if(value == 11)	return "Jack";
		if(value == 12)	return "Queen";
		if(value == 13)	return "King";
		return "" + value;
	}
	
	public String getSuitAsString() {
		if(suit == 1) 	return "Spades";
		if(suit == 2)	return "Hearts";
		if(suit == 3)	return "Diamons";
		if(suit == 4) 	return "Clubs";
		return "Unknown";
	}
	
	
}

