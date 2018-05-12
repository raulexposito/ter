package com.raulexposito.model.movement.execution;

public class Failed extends Execution {

    @Override
    public boolean isFailed() {
        return true;
    }
}
