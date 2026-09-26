package de.sharpsharp.gildedrose;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void normalItemLosesOneQualityAndOneSellInPerDay() {
        Item item = new Item("Normal Item", 10, 20);

        GildedRose.with(item).updateQuality();

        assertThat(item.getSellIn(), is(9));
        assertThat(item.getQuality(), is(19));
    }
}
