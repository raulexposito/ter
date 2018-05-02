package com.raulexposito.model.checker.add;

import com.raulexposito.model.checker.AddChecker;

public interface AddCheckerFixture {

    default AddChecker createPutChecker() {
        return new AddChecker();
    }
}
