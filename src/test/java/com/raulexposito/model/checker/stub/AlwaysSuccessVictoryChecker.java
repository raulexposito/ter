package com.raulexposito.model.checker.stub;

import com.raulexposito.model.Board;
import com.raulexposito.model.MovementResult;
import com.raulexposito.model.checker.Checker;

import static com.raulexposito.model.MovementResult.SUCCESS;

public class AlwaysSuccessVictoryChecker implements Checker {

    @Override
    public MovementResult check(Board board) {
        return SUCCESS;
    }
}
