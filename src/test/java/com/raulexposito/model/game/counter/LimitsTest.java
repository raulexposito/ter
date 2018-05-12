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
        for (int i = 0; i < TOP; i++) {
            counter = counter.increase();
        }

        // then
        Assert.assertTrue(counter.limitReached());
    }

    @Test
    public void limitIsNotReached() {
        // given
        Counter counter = createCounter();

        // when
        for (int i = 0; i < TOP - 1; i++) {
            counter = counter.increase();
        }

        // then
        Assert.assertFalse(counter.limitReached());
    }
}
