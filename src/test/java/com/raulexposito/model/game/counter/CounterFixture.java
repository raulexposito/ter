package com.raulexposito.model.game.counter;

import com.raulexposito.model.game.Counter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public interface CounterFixture {

    Integer TOP = 10;

    default Counter createCounter(){
        return Counter.upTo(TOP);
    }

    default Counter createReachedCounter () {
        Counter movements = mock(Counter.class);
        when(movements.limitReached()).thenReturn(true);
        return movements;
    }

    default Counter increase (Counter counter, Integer times) {
        for (int i = 0; i < times; i++) {
            counter = counter.increase();
        }
        return counter;
    }
}
