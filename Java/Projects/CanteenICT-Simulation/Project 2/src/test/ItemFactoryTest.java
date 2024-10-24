package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import app.Item;
import app.ItemFactory;

public class ItemFactoryTest {
    @Test
    @DisplayName("ItemFactory createItem")
    void testCreateItem() {
        for(int barcode = 1; barcode < ItemFactory.MAX_BARCODE; barcode++) {
            Item item1 = ItemFactory.createItem(1, 10);
            assertNotNull(item1, "barcode = " + barcode);
        }
        assertNull(ItemFactory.createItem(ItemFactory.MAX_BARCODE + 1, 42),
            "Creating item with a barcode = " + ItemFactory.MAX_BARCODE + 1 + " should return null.");
    }
}
