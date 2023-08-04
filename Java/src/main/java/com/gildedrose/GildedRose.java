package com.gildedrose;

import com.gildedrose.core.Processor;
import com.gildedrose.core.ProcessorDelegate;
import com.gildedrose.core.Tag;
import com.gildedrose.core.TagIdentifier;

import java.util.List;

class GildedRose {
    Item[] items;

    private ProcessorDelegate processorDelegate = new ProcessorDelegate();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        // 测试方法见 com.gildedrose.GildedRoseTest.approvalTest；本地执行应该一切 ok
        TagIdentifier tagIdentifier = new TagIdentifier();
        for (Item curItem : items) {
            // 解耦 name 和 processor 的关系，通过 tag 来提高可扩展性
            List<Tag> tags = tagIdentifier.identify(curItem);
            // 确定当前 item 的 processor
            List<Processor> processors = processorDelegate.determineProcessor(tags);
            // 执行 processor
            processorDelegate.doProcess(processors, curItem);
        }
    }
}
