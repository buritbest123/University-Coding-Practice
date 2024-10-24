// ID: 9388999
// Name: Siripen
// Section: 3

// Ref: Modified from this class project from http://math.hws.edu/javanotes/c5/s4.html#OOP.4.1

package part0_understanding; // ***DO NOT PUT PACKAGE IN YOUR EXAM***

public class Deck {
	
	private Card[] cards;
	private int cardsUsed;	// number of cards that have been dealt from the deck so far
	
	/**
	 * Constructor
	 * @param cards
	 */
	public Deck(Card[] cards) {
	}
	
	
	/**
	 * Constructor
	 * @param n_suit: max suit value (start at 1), n_value: max value of cards (start at 1)
	 */
	public Deck(int n_suit, int n_value) {
		
	}
	
	/**
	 * Puts the used cards back into the deck, and shuffles desk into a random order
	 */
	public void shuffle() {
		
	}
	
	/**
	 * Returns the number of cards that are still left in the deck
	 */
	public int cardsLeft() {
		return 0;
	}
	
	/**
	 * Deals one card from the deck and returns it
	 * @throws IllegalStateException if there are no cards left in the deck
	 */
	public Card dealCard() {
		return null;
	}
}


