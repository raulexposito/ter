package com.raulexposito.ter.model.movement.execution;

public class Failed extends Execution {

    @Override
    public boolean isFailed() {
        return true;
    }
}
