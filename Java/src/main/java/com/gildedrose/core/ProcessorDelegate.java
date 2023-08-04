/**
 * @(#)ProcessorDelegate.java, 2023/8/4
 * <p/>
 * Copyright 2022 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.gildedrose.core;

import com.gildedrose.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zwb
 */
public class ProcessorDelegate {
    private Map<Tag, Processor> tag2Processor = new HashMap<>(Tag.values().length);
    public ProcessorDelegate() {
        tag2Processor.put(Tag.A, new ATagProcessor());
        tag2Processor.put(Tag.B, new BTagProcessor());
        tag2Processor.put(Tag.S, new STagProcessor());
        tag2Processor.put(Tag.D, new DTagProcessor());
    }
    public List<Processor>  determineProcessor(List<Tag> tags) {
        List<Processor> processors = new ArrayList<>(tags.size());
        for (Tag tag : tags) {
            processors.add(tag2Processor.get(tag));
        }
        return processors;
    }

    public void doProcess(List<Processor> processors, Item curItem) {
        for (Processor processor : processors) {
            processor.process(curItem);
        }
    }
}
