package app;
/**
 * Name: Burit Sihabut
 * Student ID: 6488079
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.*;

public class OrderFactory {
	
    
    public static Order createOneOfEachOrder(String customerName, String[] paymentInfo) {
    	
    	Customer c = new Customer(customerName);
        Order order = new Order(c);
        for (int barcode = 1; barcode <= ItemFactory.MAX_BARCODE; barcode++) {
            order.addItem(ItemFactory.createItem(barcode, 1));
        }
        
        if(paymentInfo != null) {
        	order.setPayment(paymentInfo);
    	}
    	
    	return order;
    }
    
    

    /**
     * Read the text file at `filepath` and create Order using the information in the file.
     *
     * The format of the file is:
     * Customer Name
     * barcode1 quantity1
     * barcode2 qunatity2
     * . . .
     * NONE or Payment Data (at the last line)
     *
     * If the quantity is negative, it means that the customer wants to reduce the items.
     *
     * For example:
     * Hesitant Customer
     * 1 20
     * 3 10
     * 2 5
     * 1 -10
     * 1 -5
     * 2 5
     * 1 -10
     * 1 -100
     * 2 -10
     * NONE
     *
     * In this example, only items with the barcode of 3 is left (quantity = 10) and there is no payment method.
     *
     * @param filepath
     * @return Order | null
     */
    public static Order createOrderFromFile(String filepath) {
        // TODO 26: Implement createOrderFromFile(String filepath)
        // Reading Text Files (filepath)
        File file = new File(filepath); // create File (filepath) named file to read
        Scanner in = null; // Use 'Scanner' class to read input from a disk file
        Customer customer; // Create Customer object named customer
        Order order = null; // Create Order object named order and set to null
        try {
            in = new Scanner(file);
            String customerName = in.nextLine(); // Use the Scanner methods 'nextLine' to read data from the filepath file

            // First part will check Customer / onlineCustomer
            String[] real_online = customerName.split("[\\\\(||\\\\)||,]"); // Split to 3 parts
            if (real_online.length == 1 ) { // Customer
                customer = new Customer(customerName); // Customer has onlyName
            } else { // OnlineCustomer
                customer = new OnlineCustomer(real_online[0].trim(), real_online[1].trim(), real_online[2].trim()); // OnlineCustomer have Named, E-mail, and ZIP
            }
            // Second part will check order and payment
            order = new Order(customer);
            while (in.hasNextLine()) { // This loop will run every line until there is no newline
                String line = in.nextLine();
                if (line.startsWith("NONE")) { // If found NONE do nothing
                } else if (line.startsWith("CASH")) { // If found CASH, then split (::) and setPayment (cash)
                    String[] cash = line.split("::");
                    order.setPayment(cash);
                } else if (line.startsWith("CARD")) { // If found CARD, then split (::) and setPayment (card)
                    String[] card = line.split("::");
                    order.setPayment(card);
                } else { //
                    String[] barcode_quantity = line.split(" "); // split ( )
                    int barcode = Integer.parseInt(barcode_quantity[0]); // Initialization barcode convert String to int
                    int quantity = Integer.parseInt(barcode_quantity[1]); // Initialization quantity convert String to int
                    if (quantity < 0) { // If the quantity is negative, the customer wants to reduce the items.
                        order.reduceItem(barcode, quantity * -1);
                    } else { // If quantity more than 0, then addItem
                        order.addItem(barcode, quantity );
                    }
                }
            }
        } catch (Exception e) {
        }
        return order;
    }

    
    /**
     * Write `order` into a file at `filepath`. The format of the output is:
     *
     * Sale Person: Student Full Name (Student ID)
     * <order log()>
     *
     * For example:
     * Sale Person: Siripen Pongpaichet (6488000)
	 * Customer: 1: Thanapon Noraset
	 * - Sinovac\t3000.00\t2 (doses)\t6000.00
	 * - AstraZeneca\t300.00\t1 (doses)\t300.00
	 * Total: 6300.00
	 * [VALID] CASH::6300.00::7000.00::700.00
     *
     * @param order
     * @param filepath
     * @throws IOException
     */
    public static void writeOrderText(Order order, String filepath) throws IOException {
        // TODO 27: Implement writeOrderText(Order order, String filepath)
    	try {
            FileWriter file = new FileWriter(filepath); // Write output to a file (filepath)
            file.write("Sale Person: Burit Sihabut (6488079)\n" + order.log()); // Write the format
            file.close(); // To close this FileWriter stream
        } catch (Exception e) {
        }
    }
    
    /**
     * Write `order` into a file at `filepath`. The format of the output is in JSON:
     * 
-----------------------------------------------------
{
  "orderID": 4,
  "customer": {
    "customerID": 1,
    "name": "Thanapon Noraset"
  },
  "items": [
    {
      "name": "Sinovac",
      "price": 3000.0,
      "quantity": 2
    },
    {
      "name": "AstraZeneca",
      "price": 300.0,
      "quantity": 1
    },
    
  ],
  "payment": {
    "type": "Cash",
    "properties": {
      "cash": 7000.0,
      "amount": 6300.0,
      "method": "CASH"
    }
  }
}
-----------------------------------------------------
     * 
     * @param order
     * @param filepath
     * @throws JsonIOException
     * @throws IOException
     */
    public static void writeOrderJson(Order order, String filepath) throws JsonIOException, IOException {
    	// TODO 28: Implement writeOrderJson(Order order, String filepath)
    	// Hint. Since the Payment is an abstract class which cannot be constructed,
    	// so you will need to apply your custom serializer and deserializer.
    	// If you use Gson library, you can register GsonBuilder with PaymentAdapter class  
    	// (already provided - see the file for more detail).
    	// However, feel free to explore other methods and create any additional classes or methods as needed.

        Gson gson = new GsonBuilder().registerTypeAdapter(Payment.class, new PaymentAdapter()).create();
        /* Create Gson named gson, then Configures Gson (GsonBuilder()) for custom serialization for an inheritance type hierarchy.
        put a Gson instance (PaymentAdapter) based on the current configuration as argument.
        Source: https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.0/com/google/gson/GsonBuilder.html
        */
        String json = gson.toJson(order); // convert Order objects named order into JSON string.
        FileWriter writing = new FileWriter(filepath); // Create FileWrite named writing
        writing.write(json);  // To write (json) in it
        writing.close(); // To close this FileWriter stream
    }
    public static class JsonIOException extends Exception {
    }
}
