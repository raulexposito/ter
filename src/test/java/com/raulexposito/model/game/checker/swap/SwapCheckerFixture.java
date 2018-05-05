package com.raulexposito.model.game.checker.swap;

import com.raulexposito.model.game.checker.SwapChecker;

public interface SwapCheckerFixture {

    default SwapChecker createSwapChecker() {
        return new SwapChecker();
    }
}
