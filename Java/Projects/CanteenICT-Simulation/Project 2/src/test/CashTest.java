package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.Cash;
import app.Payment;


public class CashTest {
	
	@Test
    @DisplayName("Cash isValid")
    void cashIsValid() {
    	Payment[] payments = {
    		new Cash(200.00, 1000.50),
    		new Cash(1999.70, 2000.75),
    		new Cash(200.45, 105.00),
    		new Cash(-200.00, 100.00)
    	};
    	
    	boolean[] expecteds = { true, true, false, true};
    	
    	
        for (int i = 0; i < expecteds.length; i++) {
            Cash payment = (Cash) payments[i];
            boolean expected = expecteds[i];
            assertEquals(expected, payment.isValid(), "Input payment: " + payment.log());
        }
    }
	
    @Test
    @DisplayName("Cash getChange")
    void cashGetChange() {
    	Payment[] payments = {
        		new Cash(200.00, 1000.50),
        		new Cash(1999.70, 1999.75),
        		new Cash(200.45, 205.00),	 
        		new Cash(200.65, 205.00),	
        		new Cash(200.05, 205.00),
        		new Cash(200.45, 105.00),	// invalid
        		new Cash(-200.00, 100.00)
        	};
        	
    	double[] expecteds = { 800.50, 0.00, 4.50, 4.25, 4.75, 0.00, 300.0};
    	
    	
        for (int i = 0; i < expecteds.length; i++) {
            Cash payment = (Cash) payments[i];
            double expected = expecteds[i];
            assertEquals(expected, payment.getChange(), "Input payment: " + payment.log());
        }
    }
    
    @Test
    @DisplayName("Cash Log")
    void cashLog() {
    	Payment[] payments = {
    			new Cash(200.00, 1000.50),
        		new Cash(1999.70, 1999.75),
        		new Cash(200.45, 105.00),	// invalid
        		new Cash(-200.00, 100.00)
        	};
        	
    	String[] expecteds = {
    			"[VALID] CASH::200.00::1000.50::800.50",
    			"[VALID] CASH::1999.70::1999.75::0.00",
    			"[VOID] CASH::200.45::105.00::0.00",
    			"[VALID] CASH::-200.00::100.00::300.00",
    			
    	};
    	
        for (int i = 0; i < expecteds.length; i++) {
            Cash payment = (Cash) payments[i];
            String expected = expecteds[i];
            assertEquals(expected, payment.log(), "Input payment: " + payment.log());
        }
    }
}
