package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.CreditCard;
import app.CreditCard.CardType;
import app.Payment;


public class CreditCardTest {
	
	@Test
    @DisplayName("CreditCard isValid")
    void creditCardIsValid() {
		
		Payment[] payments = {
			new CreditCard(100.0, CardType.VISA, "123"),						// invalid
			new CreditCard(100.0, CardType.VISA, "1234567890123456"),	// the card's number does not match with card's type
			new CreditCard(100.0, CardType.VISA, "4234567890123456"),			// valid
			new CreditCard(100.0, CardType.AMERICANEXPRESS, "373456789012345"),	// valid
			new CreditCard(100.0, CardType.JCB, "3550567890123456"),			// valid
			new CreditCard(100.0, CardType.MASTERCARD, "5234567890123456"),		// valid
		};
	
    	boolean[] expecteds = { false, false, true, true, true, true};
    	
    	
        for (int i = 0; i < expecteds.length; i++) {
            CreditCard payment = (CreditCard) payments[i];
            boolean expected = expecteds[i];
            assertEquals(expected, payment.isValid(), "Input payment: " + payment.log());
        }
    }
	
    @Test
    @DisplayName("CreditCard getFormattedCardNumber")
    void creditCardGetFormattedCardNumber() {
    	Payment[] payments = {
    			new CreditCard(100.0, CardType.VISA, "123"),						// invalid
    			new CreditCard(100.0, CardType.VISA, "1234567890123456"),	// the card's number does not match with card's type
    			new CreditCard(100.0, CardType.VISA, "4234567890123456"),			// valid
    			new CreditCard(100.0, CardType.AMERICANEXPRESS, "373456789012345"),	// valid
    			new CreditCard(100.0, CardType.JCB, "3550567890123456"),			// valid
    			new CreditCard(100.0, CardType.MASTERCARD, "5234567890123456"),		// valid
    		};
    	
    	
    	String[] expecteds = { 
    			"invalid card number",
    			"invalid card number",
    			"4234 5678 9012 3456",
    			"3734 567890 12345",
    			"3550 5678 9012 3456",
    			"5234 5678 9012 3456"
    	};
    	
        for (int i = 0; i < expecteds.length; i++) {
            CreditCard payment = (CreditCard) payments[i];
            String expected = expecteds[i];
            assertEquals(expected, payment.getFormattedCardNumber(), "Input payment: " + payment.log());
        }
    }
    
    @Test
    @DisplayName("CreditCard Log")
    void creditCardLog() {
    	Payment[] payments = {
    			new CreditCard(100.0, CardType.VISA, "123"),						// invalid
    			new CreditCard(200.0, CardType.VISA, "1234567890123456"),	// the card's number does not match with card's type
    			new CreditCard(300.0, CardType.VISA, "4234567890123456"),			// valid
    			new CreditCard(400.0, CardType.AMERICANEXPRESS, "373456789012345"),	// valid
    			new CreditCard(500.0, CardType.JCB, "3550567890123456"),			// valid
    			new CreditCard(600.0, CardType.MASTERCARD, "5234567890123456"),		// valid
    		};
    	
    	
    	String[] expecteds = { 
    			"[VOID] CARD::100.00::VISA::invalid card number",
    			"[VOID] CARD::200.00::VISA::invalid card number",
    			"[VALID] CARD::300.00::VISA::4234 5678 9012 3456",
    			"[VALID] CARD::400.00::AMERICANEXPRESS::3734 567890 12345",
    			"[VALID] CARD::500.00::JCB::3550 5678 9012 3456",
    			"[VALID] CARD::600.00::MASTERCARD::5234 5678 9012 3456"
    	};
    	
        for (int i = 0; i < expecteds.length; i++) {
            CreditCard payment = (CreditCard) payments[i];
            String expected = expecteds[i];
            assertEquals(expected, payment.log(), "Input payment: " + payment.log());
        }
    }
}
