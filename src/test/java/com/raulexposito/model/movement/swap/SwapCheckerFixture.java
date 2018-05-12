package com.raulexposito.model.movement.swap;

import com.raulexposito.model.movement.check.SwapChecker;

public interface SwapCheckerFixture {

    default SwapChecker createSwapChecker() {
        return new SwapChecker();
    }
}
