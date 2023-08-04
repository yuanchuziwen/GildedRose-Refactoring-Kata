package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    public void approvalTest() {
        Item[] items = genItems();

        GildedRose app = new GildedRose(items);

        int days = 2;

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }

        String res = collectRes(items);
        Approvals.verifyAll("", items);
    }

    private String collectRes(Item[] items) {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    private static Item[] genItems() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6),
            new Item("Aged Brie", 10, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30),
            new Item("Sulfuras, Hand of Ragnaros", 10, 80),
            new Item("Regular item", 10, 30),
            new Item("Regular item", 0, 30),
            new Item("Regular item", -1, 0),
            new Item("else", -1, 48),
            new Item("Aged Brie", -1, 49),
            new Item("Aged Brie", -1, 48)};
        return items;
    }

}
