package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testUpdateQuality() {
        // Create some sample items
        Item[] items = new Item[] {
            new Item("Normal Item", 5, 10),
            new Item("Aged Brie", 3, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 30),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Conjured Mana Cake", 7, 15),
            new Item("Normal Item", 0, 20),
            new Item("Aged Brie", 0, 50),
            new Item("Normal Item", 0, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 30)
        };

        // Create GildedRose object
        GildedRose gildedRose = new GildedRose(items);

        // Call updateQuality method
        gildedRose.updateQuality();

        // Test updated quality values
        assertEquals(9, items[0].quality);  // Normal item quality decreases by 1
        assertEquals(21, items[1].quality); // Aged Brie quality increases by 1
        assertEquals(31, items[2].quality); // Backstage pass quality increases by 1
        assertEquals(80, items[3].quality); // Sulfuras quality remains unchanged
        assertEquals(13, items[4].quality); // Conjured item quality decreases by 2
        assertEquals(18, items[5].quality); // Once the sell by date has passed, Quality degrades twice as fast
        assertEquals(50, items[6].quality); // Quality of an item is never more than 50
        assertEquals(0, items[7].quality); // Quality of an item is never negative
        assertEquals(32, items[8].quality); // Quality increases by 2 when there are 10 days or less for Backstage passes
        assertEquals(33, items[9].quality); // Quality increases by 3 when there are 5 days or less

    }

}
