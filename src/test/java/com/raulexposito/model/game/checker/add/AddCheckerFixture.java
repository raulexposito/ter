package com.raulexposito.model.game.checker.add;

import com.raulexposito.model.game.checker.AddChecker;

public interface AddCheckerFixture {

    default AddChecker createPutChecker() {
        return new AddChecker();
    }
}
