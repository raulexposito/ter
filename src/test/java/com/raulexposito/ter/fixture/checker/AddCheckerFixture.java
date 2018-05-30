package com.raulexposito.ter.fixture.checker;

import com.raulexposito.ter.model.movement.check.AddChecker;

public interface AddCheckerFixture {

    default AddChecker createAddChecker() {
        return new AddChecker();
    }
}
