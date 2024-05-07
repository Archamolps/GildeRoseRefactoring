package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            editItemQuality(item);
        }
    }

    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";

    private static void editItemQuality(Item item) {
        if (!isLegendary(item)) {
            degradeQuality(item);
            upgradeQuality(item);
        }
    }

    private static void upgradeQuality(Item item) {
        if (item.name.equals(AGED_BRIE) || item.name.equals(BACKSTAGE_PASS)) {
            increaseQuality(item);
            if (item.name.equals(BACKSTAGE_PASS)) {
                if (item.sellIn <= 10) {
                    increaseQuality(item);
                }
                if (item.sellIn <= 5) {
                    increaseQuality(item);
                }
                if (item.sellIn <= 0) {
                    item.quality = MIN_QUALITY;
                }
            }
        }
    }

    private static void degradeQuality(Item item) {
        int qualityChange = item.sellIn > 0 ? 1 : 2; // Quality degrades twice as fast once sell-by date has passed
        if (item.name.equals(CONJURED)) {
            qualityChange *= 2; // Conjured items degrade twice as fast
        }
        decreaseQuality(item, qualityChange);
    }


    private static boolean isLegendary(Item item) {
        return item.name.equals(SULFURAS);
    }

    private static void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }


    private static void decreaseQuality(Item item, int amount) {
        item.quality -= amount;
        if (item.quality < MIN_QUALITY) {
            item.quality = MIN_QUALITY;
        }
    }

    private boolean isExpired(Item item){
        return item.sellIn<0;
    }
}
