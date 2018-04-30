package com.raulexposito.model.checker;

import com.raulexposito.model.Board;
import com.raulexposito.model.MovementResult;

public interface Checker {

	MovementResult check(Board board);
}
