package com.raulexposito.model.game.steps;

import com.raulexposito.model.game.Steps;
import static org.mockito.Mockito.*;

public interface StepsFixture {

    default Steps createUnlimitedSteps () {
        return Steps.upTo(Integer.MAX_VALUE);
    }

    default Steps createLimitedSteps (Integer maxSteps) {
        return Steps.upTo(maxSteps);
    }

    default Steps createReachedSteps () {
        Steps steps = mock(Steps.class);
        when(steps.limitReached()).thenReturn(true);
        return steps;
    }
}
