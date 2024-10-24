package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.CreditCard.CardType;
import app.Customer;
import app.Item;
import app.OnlineCustomer;
import app.Order;

public class OrderTest {

    @Test
    @DisplayName("Order getTotalPrice")
    void testGetTotalPrice() {
        Order order = new Order(new Customer("Nor"));
        assertEquals(0, order.getTotalPrice(), "Empty order has 0 total price.");
        Item item1 = new Item("Test 1", 20, 10);
        order.addItem(item1);
        assertEquals(200, order.getTotalPrice(), "Order with 1 item (" + item1 + ")");
        Item item2 = new Item("Test 2", 3, 100);
        order.addItem(item2);
        assertEquals(500, order.getTotalPrice(), "Order with 2 items (" + item1 + " and " + item2 + ")");
    }
    
    
    @Test
    @DisplayName("Order getTotalPrice for Online Customer")
    void testGetTotalPriceOnline() {
    	OnlineCustomer c = new OnlineCustomer("Siripen", "siripen.pon@mahidol.ac.th", "73170");
        Order order = new Order(c);
        assertEquals(0, order.getTotalPrice(), "Empty order has 0 total price.");
        Item item1 = new Item("Test 1", 20, 10);
        order.addItem(item1);
        assertEquals(250, order.getTotalPrice(), "Order with 1 item (" + item1 + ") and shipping fee " + c.getShippingFee());
        Item item2 = new Item("Test 2", 3, 100);
        order.addItem(item2);
        assertEquals(550, order.getTotalPrice(), "Order with 2 items (" + item1 + " and " + item2 + ")" 
        											+ " and shipping fee " + c.getShippingFee());
        
    }

    @Test
    @DisplayName("Order findItem")
    void testFindItem() {
        Order order = new Order(new Customer("Nor"));
        Item item1 = new Item("Test 10", 20, 10);
        order.addItem(item1);
        Item item2 = new Item("Test 42", 3, 100);
        order.addItem(item2);
        assertNull(order.findItem("XXX"), "XXX is not in items.");
        Item[] items = {item1, item2};
        for (int i = 0; i < items.length; i++) {
            Item item = items[1];
            Item findOne = order.findItem(item.getName());
            assertNotNull(findOne, item.getName() + " is in order.");
            assertEquals(item.getName(), findOne.getName(), "findItem returns item of the same name");
        }
    }

    @Test
    @DisplayName("Order addItem with Item")
    void testAddItem() {
        Order order = new Order(new Customer("Nor"));
        Item item1 = new Item("Test 20", 20, 10);
        order.addItem(item1);
        Item item2 = new Item("Test 17", 3, 100);
        order.addItem(item2);
        assertEquals(2, order.numItems(), "Order has 2 items (different names)");
        Item item3 = new Item("Test 20", 1, 32);
        order.addItem(item3);
        Item findOne = order.findItem("Test 20");
        assertNotNull(findOne, "Added item is in order.");
        assertEquals(2, order.numItems(), "Order has 2 items (different names)");
        assertEquals(42, findOne.getQuantity(), "Added items twice (10 and 32 units)");
        assertEquals(20, findOne.getPrice(), "Added item the second time should not change the price.");
    }

    @Test
    @DisplayName("Order addItem with barcode")
    void testAddItem2() {
        Order order = new Order(new Customer("Nor"));
        Item item1 = new Item("Unknown", 42, 10);
        order.addItem(item1);
        Item item2 = new Item("Test 17", 3, 100);
        order.addItem(item2);
        assertEquals(2, order.numItems(), "Order has 2 items (different names)");
        order.addItem(0, 32);
        Item findOne = order.findItem("Unknown");
        assertNotNull(findOne, "Added item is in order.");
        assertEquals(2, order.numItems(), "Order has 2 items (different names)");
        assertEquals(42, findOne.getQuantity(), "Added items twice (10 and 32 units)");
        assertEquals(42, findOne.getPrice(), "Added item the second time should not change the price.");
    }

    @Test
    @DisplayName("Order reduceItem with Item")
    void testReduceItem() {
        Order order = new Order(new Customer("Nor"));
        Item item1 = new Item("Test 20", 20, 10);
        order.addItem(item1);
        Item item2 = new Item("Test 17", 3, 100);
        order.addItem(item2);
        Item item3 = new Item("Test 20", 1, 2);
        order.reduceItem(item3);
        order.reduceItem(new Item("xxxxxx", 20202, 222));
        Item findOne = order.findItem("Test 20");
        assertNotNull(findOne, "Reduced item is in order.");
        assertEquals(2, order.numItems(), "Order has 2 items (different names)");
        assertEquals(8, findOne.getQuantity(), "Reduced items has 8 units (10 - 2)");
        assertEquals(20, findOne.getPrice(), "Reduced item should not change the price.");

        Item item4 = new Item("Test 20", 1, 100000);
        order.reduceItem(item4);
        Item findOne2 = order.findItem("Test 20");
        assertNull(findOne2, "Reduced item to have quantity less than zero.");
        assertEquals(1, order.numItems(), "Order has 1 item (One was removed).");

        Item item5 = new Item("Test 17", 1, 100);
        order.reduceItem(item5);
        Item findOne3 = order.findItem("Test 17");
        assertNull(findOne3, "Reduced item to have quantity equal to zero.");
        assertEquals(0, order.numItems(), "Order has 0 item (both were removed).");
    }

    @Test
    @DisplayName("Order reduceItem with barcode")
    void testReduceItem2() {
        Order order = new Order(new Customer("Nor"));
        Item item1 = new Item("Unknown", 20, 10);
        order.addItem(item1);
        Item item2 = new Item("Test 17", 3, 100);
        order.addItem(item2);
        order.reduceItem(0, 7);
        Item findOne = order.findItem("Unknown");
        assertNotNull(findOne, "Reduced item is in order.");
        assertEquals(2, order.numItems(), "Order has 2 items (different names)");
        assertEquals(3, findOne.getQuantity(), "Reduced items has 8 units (10 - 2)");
        assertEquals(20, findOne.getPrice(), "Reduced item should not change the price.");
    }
    
    
    @Test
    @DisplayName("Order set payment method")
    void testSetPayment() {
    	Order order = new Order(new Customer("Nor"));
        assertEquals(0, order.getTotalPrice(), "Empty order has 0 total price.");
        Item item1 = new Item("Test 1", 20, 10);	// total price 200
        order.addItem(item1);
        
        // test cash payment
        order.setPayment( new String[] {"CASH", "300.0"});
        assertTrue(order.checkPaymentStatus(), "Valid cash payment");
        
        order.setPayment( new String[] {"CASH", "100.0"});
        assertFalse(order.checkPaymentStatus(), "Invalid cash payment: insufficient money");
        
    	// test card payment
        order.setPayment( new String[] {"CARD", "VISA", "4234567890123456" });
        assertTrue(order.checkPaymentStatus(), "Valid credit card payment");
        
        order.setPayment( new String[] {"CARD", "VISA", "1234567890123456"});
        assertFalse(order.checkPaymentStatus(), "Invalid credit card payment");
    	
    }

    @Test
    @DisplayName("Order Log")
    void testLog() {
    	// in-store customer -> no payment yet
        Order order = new Order(new Customer("Siripen"));
        String expected = "Customer: " + order.getCustomer().getCustomerID()
            + ": Siripen"
            + "\nTotal: 0.00\n[PENDING]";
        assertEquals(expected, order.log());
       
        order.addItem(new Item("Sinovac", 3000, 2));
        expected = "Customer: " + order.getCustomer().getCustomerID()
            + ": Siripen"
            + "\n- Sinovac\t3000.00\t2 (units)\t6000.00"
            + "\nTotal: 6000.00\n[PENDING]";
        assertEquals(expected, order.log());
        
        order.addItem(new Item("AstraZeneca", 300, 1));
        expected = "Customer: " + order.getCustomer().getCustomerID()
            + ": Siripen"
            + "\n- Sinovac\t3000.00\t2 (units)\t6000.00"
            + "\n- AstraZeneca\t300.00\t1 (units)\t300.00"
            + "\nTotal: 6300.00\n[PENDING]";
        assertEquals(expected, order.log());
        
        // set payment
        order.setPayment( new String[] {"CASH", "7000.0"});
        expected = "Customer: " + order.getCustomer().getCustomerID()
                + ": Siripen"
                + "\n- Sinovac\t3000.00\t2 (units)\t6000.00"
                + "\n- AstraZeneca\t300.00\t1 (units)\t300.00"
                + "\nTotal: 6300.00" 
                + "\n[VALID] CASH::6300.00::7000.00::700.00";
        assertEquals(expected, order.log());
        
        // set invalid payment
        order.setPayment( new String[] {"CASH", "2000.0"});
        expected = "Customer: " + order.getCustomer().getCustomerID()
                + ": Siripen"
                + "\n- Sinovac\t3000.00\t2 (units)\t6000.00"
                + "\n- AstraZeneca\t300.00\t1 (units)\t300.00"
                + "\nTotal: 6300.00" 
                + "\n[VOID] CASH::6300.00::2000.00::0.00";
        assertEquals(expected, order.log());
        
        // online customer -> no payment yet
        Order orderOnline = new Order(new OnlineCustomer("Siripen", "siripen.pon@mahidol.ac.th", "73170"));
        expected = "Customer: " + orderOnline.getCustomer().getCustomerID()
            + ": Siripen (siripen.pon@mahidol.ac.th, 73170)"
            + "\nTotal: 0.00\n[PENDING]";
        assertEquals(expected, orderOnline.log());
        
    }
}
