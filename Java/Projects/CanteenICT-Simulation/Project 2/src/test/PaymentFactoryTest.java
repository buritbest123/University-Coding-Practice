package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.Cash;
import app.CreditCard;
import app.Payment;
import app.PaymentFactory;

public class PaymentFactoryTest {

	@Test
	@DisplayName("PaymentFactory createPayment with no exception")
	void testCreatePaymentNoException() {

		double[] amounts = { 100.0, 200.0, 300.0, 400.0 };
		String[][] params = { 
				{ "CASH", "200.0" }, 
				{ "CASH", "300.5" }, 
				{ "CARD", "VISA", "1234567890123456" },
				{ "CARD", "JCB", "3550567890123456" } };

		// valid payment
		for (int i = 0; i < params.length; i++) {
			Payment payment = PaymentFactory.createPayment(amounts[i], params[i]);
			assertNotNull(payment, "PaymentType = " + params[i][0]);
			if (params[i][0].equalsIgnoreCase("CASH")) {
				assertTrue(payment instanceof Cash, "payment type = Cash");
			} else {
				assertTrue(payment instanceof CreditCard, "payment type = CreditCard");
			}

		}
	}

	@Test
	@DisplayName("PaymentFactory createPayment with exception")
	void testCreatePaymentWithException() {

		// invalid payment type
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			PaymentFactory.createPayment(99.99, new String[] { "E-WALLET" });
		});
		
		String expected = "E-WALLET is an unavailable payment type.";
	    assertEquals(expected, exception.getMessage(), 
	    		"Unavailable payment type, expect IllegalArgumentException");

	    // invalid number of parameters, cash payment needs cash tendered number
	    exception = assertThrows(IndexOutOfBoundsException.class, () -> {
 			PaymentFactory.createPayment(99.99, new String[] { "CASH" });
 		});
 		assertEquals("1", exception.getMessage(), 
 	    		"Insufficient number of arguments for cash payment at index 1");

 		// invalid number of parameters, card payment needs card's number
 		exception = assertThrows(IndexOutOfBoundsException.class, () -> {
 			PaymentFactory.createPayment(99.99, new String[] { "CARD", "VISA" });
 		});
 		
 	    assertEquals("2", exception.getMessage(), 
 	    		"Insufficient number of arguments for card payment at index 2");
 	    
 	    // invalid credit card type, only VISA, AMERICANEXPRESS, JCB, MASTERCARD are allowed
	    exception = assertThrows(IllegalArgumentException.class, () -> {
 			PaymentFactory.createPayment(99.99, new String[] { "CARD", "ABC" });
 		});
 		
	    expected = "ABC is an unavailable card type.";
 	    assertEquals(expected, exception.getMessage(), 
 	    		"Unavailable credit card type");

	}

}
