/**
 * @(#)TagIdentifier.java, 2023/8/4
 * <p/>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gildedrose.core;

import com.gildedrose.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwb
 */
public class TagIdentifier {
    private TagFinder tagFinder;

    public TagIdentifier() {
        tagFinder = new NameEqTagFinder();
    }

    public List<Tag> identify(Item item) {
        // 使用 tagFinder 解耦 tag 和 item 之间的关系，便于后续使用不同的方式确认 tag
        return tagFinder.findTag(item);
    }

    interface TagFinder {
        List<Tag> findTag(Item item);
    }

    private class NameEqTagFinder implements TagFinder{

        @Override
        public List<Tag> findTag(Item item) {
            List<Tag> res = new ArrayList<>();
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                res.add(Tag.B);
            } else if (item.name.equals("Aged Brie")) {
                res.add(Tag.A);
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                res.add(Tag.S);
            } else {
                res.add(Tag.D);
            }

            return res;
        }
    }
}
