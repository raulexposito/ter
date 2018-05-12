package com.raulexposito.model.game.counter;

import com.raulexposito.model.game.Counter;
import org.junit.Assert;
import org.junit.Test;

public class ResetTest implements CounterFixture {

    private static final Integer PENULTIMATE = TOP - 1;

    @Test
    public void resetAvoidsReachingLimit() {
        // given
        Counter counter = createCounter();

        // when
        counter = countUntilPenultimate(counter);
        counter = counter.reset();
        counter = countUntilPenultimate(counter);

        // then
        Assert.assertFalse(counter.limitReached());
    }

    private Counter countUntilPenultimate(Counter counter) {
        for (int i = 0; i < PENULTIMATE; i++) {
            counter = counter.increase();
        }
        return counter;
    }
}
