package com.raulexposito.model.game.counter;

import com.raulexposito.model.game.Counter;
import org.junit.Assert;
import org.junit.Test;

public class LimitsTest implements CounterFixture {

    @Test
    public void limitIsReached() {
        // given
        Counter counter = createCounter();

        // when
        counter = increase(counter, TOP);

        // then
        Assert.assertTrue(counter.limitReached());
    }

    @Test
    public void limitIsNotReached() {
        // given
        Counter counter = createCounter();

        // when
        counter = increase(counter, TOP - 1);

        // then
        Assert.assertFalse(counter.limitReached());
    }
}
