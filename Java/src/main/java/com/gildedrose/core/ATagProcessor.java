/**
 * @(#)ATagProcessor.java, 2023/8/4
 * <p/>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gildedrose.core;

import com.gildedrose.Item;

/**
 * @author zwb
 */
public class ATagProcessor implements Processor{
    @Override
    public void process(Item curItem) {
        if (curItem.quality < 50) {
            curItem.quality = curItem.quality + 1;
        }

        curItem.sellIn = curItem.sellIn - 1;

        if (curItem.sellIn < 0) {
            if (curItem.quality < 50) {
                curItem.quality = curItem.quality + 1;
            }
        }
    }
}
