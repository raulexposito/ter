package com.raulexposito.model.game.counter;

import com.raulexposito.model.game.Counter;

import static org.mockito.Mockito.*;

public interface CounterFixture {

    Integer TOP = 10;

    default Counter createCounter(){
        return Counter.upTo(TOP);
    }

    default Counter createReachedCounter () {
        Counter steps = mock(Counter.class);
        when(steps.limitReached()).thenReturn(true);
        return steps;
    }
}