package com.raulexposito.ter.fixture.game;

import com.raulexposito.ter.model.game.Counter;
import com.raulexposito.ter.model.game.Movements;
import com.raulexposito.ter.model.game.Step;

public interface StepFixture extends MovementsFixture, CounterFixture {

    default Step createUnlimitedStep() {
        return new Step(createUnlimitedMovements(), createCounter());
    }

    default Step createStep(Movements movements, Counter counter) {
        return new Step(movements, counter);
    }
}
