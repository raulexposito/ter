package com.raulexposito.model.movement.add;

import com.raulexposito.model.movement.check.AddChecker;

public interface AddCheckerFixture {

    default AddChecker createAddChecker() {
        return new AddChecker();
    }
}
