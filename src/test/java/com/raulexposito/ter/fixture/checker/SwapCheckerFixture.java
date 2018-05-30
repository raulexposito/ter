package com.raulexposito.ter.fixture.checker;

import com.raulexposito.ter.model.movement.check.SwapChecker;

public interface SwapCheckerFixture {

    default SwapChecker createSwapChecker() {
        return new SwapChecker();
    }
}
