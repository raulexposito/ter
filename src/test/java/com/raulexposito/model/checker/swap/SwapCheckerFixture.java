package com.raulexposito.model.checker.swap;

import com.raulexposito.model.checker.SwapChecker;

public interface SwapCheckerFixture {

    default SwapChecker createSwapChecker() {
        return new SwapChecker();
    }
}
