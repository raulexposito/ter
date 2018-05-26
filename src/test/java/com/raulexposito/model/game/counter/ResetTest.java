package com.raulexposito.model.game.counter;

import com.raulexposito.model.game.Counter;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

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
        assertThat(counter.limitReached()).isFalse();
    }

    private Counter countUntilPenultimate(Counter counter) {
        for (int i = 0; i < PENULTIMATE; i++) {
            counter = counter.increase();
        }
        return counter;
    }
}
