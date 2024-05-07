package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void testAgedBrieQualityIncrease() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(21, items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityIncrease() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(21, items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityIncreaseNearConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(22, items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityIncreaseVeryNearConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(23, items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityDropAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(0, items[0].quality);
    }

    @Test
    public void testSulfurasQualityDoesNotChange() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 10, 80) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(80, items[0].quality);
    }

    @Test
    public void testConjuredItemQualityDecreaseTwiceAsFast() {
        Item[] items = new Item[] { new Item("Conjured", 10, 20) };
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(18, items[0].quality);
    }

}
