package com.raulexposito.model.game.steps;

import com.raulexposito.model.game.Steps;
import static org.mockito.Mockito.*;

public interface StepsFixture {

    default Steps createSteps () {
        return Steps.empty();
    }

    default Steps createReachedSteps () {
        Steps steps = mock(Steps.class);
        when(steps.limitReached()).thenReturn(true);
        return steps;
    }
}
