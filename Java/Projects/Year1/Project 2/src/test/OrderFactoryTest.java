package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.Item;
import app.ItemFactory;
import app.OnlineCustomer;
import app.Order;
import app.OrderFactory;
import app.Payment;
import app.PaymentAdapter;

public class OrderFactoryTest {
	
	public static final String INPUT_PATH = Paths.get("C:\\Users\\Admin\\IdeaProjects\\Java\\Projects\\Project2").toAbsolutePath().toString()
			+ File.separator + "data" +  File.separator + "inputs" + File.separator ;
	public static final String OUTPUT_PATH = Paths.get("C:\\Users\\Admin\\IdeaProjects\\Java\\Projects\\Project2").toAbsolutePath().toString()
			+ File.separator + "data" +  File.separator + "outputs" + File.separator ;

	
    @Test
    @DisplayName("OrderFactory createOrderFromFile")
    void testCreateOrderFromFile() {
    	
    	// read from not exist file
		Order o = OrderFactory.createOrderFromFile(INPUT_PATH + "notexist.txt");
	    assertTrue(o == null, "Invalid payment type, no order is created");
    	
    	// read from text file
	    
	    /**
	     * === NOTE ===
	     * You know how to read and process the text file, right?
	     * This test case only check on create order from 3 text files 
	     * 		(i.e., order3.txt, order4.txt, and order5.txt). 
	     * Please feel free to write your own code to check on other files.
	     */

	    String file3 = INPUT_PATH + "order3.txt";
    	Order order3 = OrderFactory.createOrderFromFile(file3);
        assertEquals(1, order3.numItems(), file3 + " only has 1 item left");
        assertEquals("Hesitant Customer", order3.getCustomer().getName(), 
        		file3 + " customer name is Hesitant Customer");
        Item item = ItemFactory.createItem(3, 1);
        Item findOne = order3.findItem(item.getName());
        assertEquals(item.getName(), findOne.getName(), 
        		file3 + " has item barcode 3 (" + item.getName() + ")");
        assertTrue(order3.getPayment() == null, file3 + " has no payment info yet");
        
        
        String file4 = INPUT_PATH + "order4.txt";
        Order order4 = OrderFactory.createOrderFromFile(file4);
        assertEquals(0, order4.numItems(), file4 + " has no item");
        assertEquals("Dud Customer", order4.getCustomer().getName(), 
        		file4 + " customer name is Dud Customer");
        assertTrue(order4.getPayment() == null, file4 + " has no payment info yet");
        
        
        // Online customer
        String file5 = INPUT_PATH + "order5.txt";
        Order order5 = OrderFactory.createOrderFromFile(file5);
        assertEquals(4, order5.numItems(), file5 + " only has 4 items left");
        String expectedName = "Online Customer";
        assertEquals(expectedName, order5.getCustomer().getName(), 
        		file5 + " customer name is " + expectedName);
        OnlineCustomer c = (OnlineCustomer) order5.getCustomer();
        assertEquals("ict@mail.com", c.getEmail(), file5 + " is an online customer");
        assertEquals("20120", c.getZipcode(),  file5 + " is an online customer");
        assertEquals("CARD", order5.getPayment().getMethod(), file5 + " CARD payment");	

    }

    private String readFromInputStream(String filepath) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    @Test
    @DisplayName("OrderFactory writeOrder in Json format")
    void testWriteOrderJson() throws IOException {
    	
    	Reader reader = null;
    	
        // create Gson object to deserialize with PaymentAdapter deserializer
        GsonBuilder gsonBuilder = new  GsonBuilder();
    	gsonBuilder.registerTypeAdapter(Payment.class, new PaymentAdapter());
    	Gson gson = gsonBuilder.setPrettyPrinting().create();
    	
    	String[][] payments = {
    			null,							// no payment
    			{"CASH", "4000"},				// valid payment
    			{"CARD", "VISA", "4234567890123456"},	// valid payment
    			{"CARD", "VISA", "1112121"}		// invalid payment
    	};
    	
    	String[] expectedCustomerNames = {
    			"Test Order Factory 0",
    			"Test Order Factory 1",
    			"Test Order Factory 2",
    			"Test Order Factory 3"
    	};
    	boolean[] expectedPaymentStatus = { false, true, true, false };
    	 
    	
    	try {
    		Order order = null;
    		for(int i = 0; i < payments.length; i++) {
    			String filepath = OUTPUT_PATH + "test_output_" + i + ".json";
    	    	
    			
    			// create order and write serialize an oder object to file
    	        order = OrderFactory.createOneOfEachOrder("Test Order Factory " + i, payments[i]);
    			OrderFactory.writeOrderJson(order,  filepath);
    			
    			reader = new FileReader(filepath);
            	Order orderLog = gson.fromJson(reader, Order.class);
            	System.out.println("=======\n" + orderLog.log());
            	assertEquals(order.getCustomer().getName(), expectedCustomerNames[i], "Incorrect customer name");
            	assertEquals(order.checkPaymentStatus(), expectedPaymentStatus[i], "Incorrect payment status");
            	assertEquals(order.numItems(), ItemFactory.MAX_BARCODE, "Incorrect items in order");
            	assertEquals(order.log().trim(), orderLog.log().trim(), "Order from json file must equal to the input order");
    		}
    		
        } catch (IOException e) {
            e.printStackTrace();
            assertEquals(0,1, "WriteOrderJson() failed - no file is created.");
        } catch (OrderFactory.JsonIOException e) {
			e.printStackTrace();
		} finally {
        	if(reader != null) {
        		reader.close();
        	}
        }
        
    }
    
    @Test
    @DisplayName("OrderFactory writeOrder in Text format")
    void testWriteOrderText() {
    	
    	String[][] payments = {
    			null,
    			{"CASH", "4000"},
    			{"CARD", "VISA", "4234567890123456"},
    			{"CARD", "VISA", "1112121"}
    	};
    	 
        try {
        	Order order = null;
        	
    		for(int i = 0; i < payments.length; i++) {
    			String filepath = OUTPUT_PATH + "test_output_" + i + ".txt";
    			
    			// create order and write serialize an oder object to file
    			order = OrderFactory.createOneOfEachOrder("Test Order Factory " + i, payments[i]);
    			
    			OrderFactory.writeOrderText(order, filepath);
    			
    			String output = this.readFromInputStream(filepath);
    			String[] lines = output.split("\n");
    			 
	            Pattern pattern1 = Pattern.compile("^Sale Person: [A-Za-z ]+ \\(\\d{7}\\)$", Pattern.CASE_INSENSITIVE);
	            Matcher matcher1 = pattern1.matcher(lines[0]);
	            boolean matchFound = matcher1.matches();
	            assertTrue(matchFound, "First line should be \"Sale Person: Student Name (Student ID)\"");
            	String orderLog = "";
	            for (int j = 1; j < lines.length; j++) {
	                orderLog += lines[j] + "\n";
	            }
	            assertEquals(order.log().trim(), orderLog.trim(), "After the frist line, it should contain Order's log.");
    		}
    		
        } catch (IOException e) {
            e.printStackTrace();
            assertEquals(0,1, "WriteOrderText() failed - no file is created.");
        } 
        
    }
}
