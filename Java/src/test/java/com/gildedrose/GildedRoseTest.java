package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void testUpdateQuality() {
        // Create GildedRose object
        GildedRose gildedRose = new GildedRose();

        // Create some sample items
        Item normalItem = new Item("Normal Item", 5, 10);
        gildedRose.updateQuality(normalItem);
        assertEquals(9, normalItem.quality);  // Normal item quality decreases by 1

        Item agedBrie = new Item("Aged Brie", 3, 20);
        gildedRose.updateQuality(agedBrie);
        assertEquals(21, agedBrie.quality);   // Aged Brie quality increases by 1

        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 30);
        gildedRose.updateQuality(backstagePass);
        assertEquals(31, backstagePass.quality); // Backstage pass quality increases by 1

        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        gildedRose.updateQuality(sulfuras);
        assertEquals(80, sulfuras.quality);   // Sulfuras quality remains unchanged

        Item conjuredItem = new Item("Conjured Mana Cake", 7, 15);
        gildedRose.updateQuality(conjuredItem);
        assertEquals(13, conjuredItem.quality); // Conjured item quality decreases by 2

        Item normalItemSellDatePassed = new Item("Normal Item", 0, 20);
        gildedRose.updateQuality(normalItemSellDatePassed);
        assertEquals(18, normalItemSellDatePassed.quality);// Once the sell by date has passed, Quality degrades twice as fast

        Item qualityItemGreater50 = new Item("Aged Brie", 0, 50);
        gildedRose.updateQuality(qualityItemGreater50);
        assertEquals(50, qualityItemGreater50.quality); // Quality of an item is never more than 50

        Item qualityItemNever0 = new Item("Normal Item", 0, 0);
        gildedRose.updateQuality(qualityItemNever0);
        assertEquals(0, qualityItemNever0.quality); // Quality of an item is never negative

        Item backItemLess10days = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 30);
        gildedRose.updateQuality(backItemLess10days);
        assertEquals(32, backItemLess10days.quality); // Quality increases by 2 when there are 10 days or less for Backstage passes

        Item backItemLess5days = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 30);
        gildedRose.updateQuality(backItemLess5days);
        assertEquals(33, backItemLess5days.quality); // Quality increases by 3 when there are 5 days or less
    }
}
