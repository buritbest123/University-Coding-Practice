package test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.Customer;

public class CustomerTest {
    @Test
    @DisplayName("Customer Log")
    void testLog() {
        String[] names = {"Siripen Pongpaichet", "Thanapon Noraset"};
        String[] expecteds = {": Siripen Pongpaichet", ": Thanapon Noraset"};
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            Customer c = new Customer(name);
            assertEquals(c.getCustomerID() + expecteds[i], c.log(), "Input name: " + name);
        }
    }
}