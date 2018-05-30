package com.raulexposito.ter.model.game.counter;

import com.raulexposito.ter.fixture.game.CounterFixture;
import com.raulexposito.ter.model.game.Counter;
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
