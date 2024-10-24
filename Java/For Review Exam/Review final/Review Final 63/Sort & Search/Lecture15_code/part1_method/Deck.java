// ID: 9388999
// Name: Siripen
// Section: 3

// Ref: Modified from this class project from http://math.hws.edu/javanotes/c5/s4.html#OOP.4.1

package part1_method; // ***DO NOT PUT PACKAGE IN YOUR EXAM***


public class Deck {
	
	private Card[] cards;
	private int cardsUsed;	// number of cards that have been dealt from the deck so far
	
	/**
	 * Constructor
	 * @param cards
	 */
	public Deck(Card[] cards) {
		this.cards = cards;
		cardsUsed = 0;
		shuffle();
	}
	
	/**
	 * Constructor
	 * @param n_suit: max suit value (start at 1), n_value: max value of cards (start at 1)
	 */
	public Deck(int n_suit, int n_value) {
		cards = new Card[n_suit * n_value];
		
		int cardCreate = 0;
		for(int suit = 1; suit <= n_suit; suit++) {
			for(int value = 1; value <= n_value; value++) {
				cards[cardCreate] = new Card(value, suit);
				cardCreate++;
			}
		}
		
		cardsUsed = 0;
		shuffle();
	}

	
	/**
	 * Puts the used cards back into the deck, and shuffles desk into a random order
	 */
	public void shuffle() {
		for(int i = cards.length - 1; i > 0; i--) {
			int rand = (int)(Math.random()*(i+1));
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
		}
		cardsUsed = 0;
	}
	
	/**
	 * Returns the number of cards that are still left in the deck
	 */
	public int cardsLeft() {
		return cards.length - cardsUsed;
	}
	
	/**
	 * Deals one card from the deck and returns it
	 * @throws IllegalStateException if there are no cards left in the deck
	 */
	public Card dealCard() {
		if(cardsUsed == cards.length) 
			throw new IllegalStateException("No card is left in the deck.");
		
		cardsUsed++;
		return cards[cardsUsed - 1];
	}
}
