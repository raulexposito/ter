package com.raulexposito.model.game.checker.victory;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.game.checker.VictoryChecker;

public interface VictoryCheckerFixture {

    default VictoryChecker createVictoryChecker(Board board) {
        return new VictoryChecker(board);
    }
}
