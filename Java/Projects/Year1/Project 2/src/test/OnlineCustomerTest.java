package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.Customer;
import app.OnlineCustomer;

public class OnlineCustomerTest {

    @Test
    @DisplayName("OnlineCustomer Construction")
    void testConstruction() {
        String[] emails = {"siripen.pon@mahidol.ac.th", "petch.saj@mahidol.edu", "suppawong.tua@mahidol.edu"};
        String[] names = {"Siripen Pongpaichet", "Petch Sajjacholapunt", "Suppawong Tuarob"};
        String[] zipcodes = {"73170", "20120", "83120"};
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String email = emails[i];
            String zipcode = zipcodes[i];
            OnlineCustomer c = new OnlineCustomer(name, email, zipcode);
            assertEquals(name, c.getName(), "Input name: " + name + ", email: " + email + ", zipcode: " + zipcode);
            assertEquals(email, c.getEmail(), "Input name: " + name + ", email: " + email + ", zipcode: " + zipcode);
            assertEquals(zipcode, c.getZipcode(), "Input name: " + name + ", email: " + email + ", zipcode: " + zipcode);

        }
    }
    
   
    @Test
    @DisplayName("OnlineCustomer Shipping Fee")
    void testShippingFee() {
    	String[] emails = {"siripen.pon@mahidol.ac.th", "petch.saj@mahidol.ac.th", "suppawong.tua@mahidol.edu", "thanapon.nor@mahidol.edu"};
        String[] names = {"Siripen Pongpaichet", "Petch Sajjacholapunt", "Suppawong Tuarob", "Thanapon Noraset"};
        String[] zipcodes = {"73170", "20120", "83120", "11111"};
        double[] expecteds = { 50.0, 150.0, 250.0, 99.0};
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String email = emails[i];
            String zipcode = zipcodes[i];
            OnlineCustomer c = new OnlineCustomer(name, email, zipcode);
            assertEquals(expecteds[i], c.getShippingFee(), "Input name: " + name + ", email: " + email + ", zipcode: " + zipcode);
        }
    }
    

    @Test
    @DisplayName("OnlineCustomer Log")
    void testLog() {
    	String[] emails = {"siripen.pon@mahidol.ac.th", "petch.saj@mahidol.ac.th", "suppawong.tua@mahidol.edu", "thanapon.nor@mahidol.edu"};
        String[] names = {"Siripen Pongpaichet", "Petch Sajjacholapunt", "Suppawong Tuarob", "Thanapon Noraset"};
        String[] zipcodes = {"73170", "20120", "83120", "11111"};
        String[] expecteds = {
            ": Siripen Pongpaichet (siripen.pon@mahidol.ac.th, 73170)",
            ": Petch Sajjacholapunt (petch.saj@mahidol.ac.th, 20120)",
            ": Suppawong Tuarob (suppawong.tua@mahidol.edu, 83120)",
            ": Thanapon Noraset (thanapon.nor@mahidol.edu, 11111)"};
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String email = emails[i];
            String zipcode = zipcodes[i];
            Customer c = new OnlineCustomer(name, email, zipcode);
            assertEquals(c.getCustomerID() + expecteds[i], c.log(), "Input name: " + name + ", email: " + email + ", zipcode: " + zipcode);
        }
    }
}
