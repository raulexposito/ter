package com.raulexposito.ter.fixture.game;

import com.raulexposito.ter.model.game.Counter;

public interface CounterFixture {

    Integer TOP = 10;

    Integer NONE = 0;

    default Counter createCounter() {
        return Counter.upTo(TOP);
    }

    default Counter createReachedCounter() {
        return Counter.upTo(NONE);
    }

    default Counter increase(Counter counter, Integer times) {
        for (int i = 0; i < times; i++) {
            counter = counter.increase();
        }
        return counter;
    }
}
