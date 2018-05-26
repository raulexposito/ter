package com.raulexposito.model.game.counter;

import com.raulexposito.model.game.Counter;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class LimitsTest implements CounterFixture {

    @Test
    public void limitIsReached() {
        // given
        Counter counter = createCounter();

        // when
        counter = increase(counter, TOP);

        // then
        assertThat(counter.limitReached()).isTrue();
    }

    @Test
    public void limitIsNotReached() {
        // given
        Counter counter = createCounter();

        // when
        counter = increase(counter, TOP - 1);

        // then
        assertThat(counter.limitReached()).isFalse();
    }
}
