package part2_comparable;		// ***DO NOT PUT PACKAGE IN YOUR EXAM***

import java.util.Scanner;

////////////////////////////////////////////////////////////
// DO NOT MODIFY THIS CLASS
////////////////////////////////////////////////////////////

/**
 * This program lets the user play HighLow, a simple card game 
 * After the user plays several games, the user's average score is reported.
 */

public class HighLow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("A card is dealt from a deck of cards.");
		System.out.println("You have to predict whether the next card will be higher or lower.");
		System.out.println("Your score in the game is the number of correct guess untill ties");

		int gamesPlayed = 0;
		//boolean correct = true;
		
		int numCorrect = 0;
		try {
			
			Deck deck = createStudentCardDeck();
			
			Card currentCard;	// The current card which the user sees
			Card nextCard;		// The next card in deck. 
								// The user have to predict whether this card is higher/lower than the current card
			
			char guess;			// The user's guess.
			
			currentCard = deck.dealCard();
			System.out.println("The first card is " + currentCard);
			
			while(true) {
				System.out.println("Will the next card be higher (H) or lower (L)?");
				Scanner sc = new Scanner(System.in);
				
				do {
		             guess = sc.next().toUpperCase().charAt(0);
		 			
		             if (guess != 'H' && guess != 'L' && guess != 'T') 
		                System.out.print("Please respond with H or L:  ");
		        } while (guess != 'H' && guess != 'L' && guess != 'T');
		         
				nextCard = deck.dealCard();
				gamesPlayed++;
				System.out.println("The next card is " + nextCard);
				
				boolean correct = false;
				
				// using compareTo instead of ==
				int compare = nextCard.compareTo(currentCard);
				if(compare == 0) {
					break;
				} else if(compare > 0) {
					if(guess == 'H') 	correct = true;
				} else {
					if(guess == 'L') 	correct = true;
				}
			
				if(correct) {
					System.out.println("CORRECT");
					numCorrect++;
				} else 
					System.out.println("WRONG");
				
				currentCard = nextCard;
				System.out.println("--- next turn ---");
				System.out.println("The current card is " + currentCard);
			}
		} catch (Exception e) {
			// no more card lefts in the deck
			// System.out.println("The game is over. Your score is " + numCorrect);
		} finally {
			System.out.println("The game is over. Your score is " + numCorrect + "/" + gamesPlayed);
		}
	}
	
	public static Deck createCardDeck() {
		return new Deck(4, 13);
		
	}
	
	public static Deck createStudentCardDeck() {
		Card[] cards = new StudentCard[10];
		for(int i = 0; i < cards.length; i++) {
			int id = 6388000 + (i + 1);
			int suit = (int) (Math.random()*(4)) + 1;
			String name = "" + (char)(65+i) + (char)(65+i+1);
			double gpa = Math.random()*4.0 + 0.1;
			cards[i] = new StudentCard(id, suit, name, gpa);
		}
		return new Deck(cards);
	}

}
