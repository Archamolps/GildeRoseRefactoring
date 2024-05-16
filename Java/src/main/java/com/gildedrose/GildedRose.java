package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (getItemType(item)) {
                case AGED_BRIE:
                    updateAgedBrie(item);
                    break;
                case BACKSTAGE_PASS:
                    updateBackstagePass(item);
                    break;
                case SULFURAS:
                    // Sulfuras never changes, no need to update
                    break;
                case CONJURED:
                    updateConjured(item);
                    break;
                case NORMAL:
                default:
                    updateNormalItem(item);
                    break;
            }
        }
    }

    private ItemType getItemType(Item item) {
        if (item.name.equals("Aged Brie")) {
            return ItemType.AGED_BRIE;
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            return ItemType.BACKSTAGE_PASS;
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return ItemType.SULFURAS;
        } else if (item.name.startsWith("Conjured")) {
            return ItemType.CONJURED;
        } else {
            return ItemType.NORMAL;
        }
    }
    private void updateAgedBrie(Item item) {
        decreaseSellIn(item);
        increaseQuality(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void updateBackstagePass(Item item) {
        decreaseSellIn(item);
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
    private void updateConjured(Item item) {
        decreaseSellIn(item);
        decreaseQuality(item);
        decreaseQuality(item); // Conjured items degrade twice as fast
        if (item.sellIn < 0) {
            decreaseQuality(item);
            decreaseQuality(item);
        }
    }
    private void updateNormalItem(Item item) {
        decreaseSellIn(item);
        decreaseQuality(item);
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseSellIn(Item item) {
        if (!isLegendary(item)) {
            item.sellIn--;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (!isLegendary(item) && item.quality > 0) {
            item.quality--;
        }
    }

    private boolean isLegendary(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}
