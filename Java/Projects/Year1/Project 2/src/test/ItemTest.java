package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.Item;

public class ItemTest {
    @Test
    @DisplayName("Item Log")
    void testLog() {
        Item[] items = {
            new Item("Test1", 1000, 2),
            new Item("Test2", 11, 3),
            new Item("Test3", 4)
        };
        String[] expecteds = {
            "Test1\t1000.00\t2 (units)\t2000.00",
            "Test2\t11.00\t3 (units)\t33.00",
            "Test3\t4.00\t1 (units)\t4.00"
        };
        for (int i = 0; i < expecteds.length; i++) {
            Item item = items[i];
            String expected = expecteds[i];
            assertEquals(expected, item.log(), "Input item: " + item);
        }
    }
}
