package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item curItem = items[i];
            if (curItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (curItem.quality < 50) {
                    curItem.quality = curItem.quality + 1;

                    if (curItem.sellIn < 11) {
                        if (curItem.quality < 50) {
                            curItem.quality = curItem.quality + 1;
                        }
                    }

                    if (curItem.sellIn < 6) {
                        if (curItem.quality < 50) {
                            curItem.quality = curItem.quality + 1;
                        }
                    }
                }

                curItem.sellIn = curItem.sellIn - 1;

                if (curItem.sellIn < 0) {
                    curItem.quality = curItem.quality - curItem.quality;
                }
            } else if (curItem.name.equals("Aged Brie")) {
                if (curItem.quality < 50) {
                    curItem.quality = curItem.quality + 1;
                }

                curItem.sellIn = curItem.sellIn - 1;

                if (curItem.sellIn < 0) {
                    if (curItem.quality < 50) {
                        curItem.quality = curItem.quality + 1;
                    }
                }
            } else if (curItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                // do nothing
            } else {
                if (curItem.quality > 0) {
                    curItem.quality = curItem.quality - 1;
                }
                curItem.sellIn = curItem.sellIn - 1;
                if (curItem.sellIn < 0 && curItem.quality > 0) {
                    curItem.quality = curItem.quality - 1;
                }
            }
        }
    }
}
