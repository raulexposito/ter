package com.raulexposito.ter.fixture.game.checker;

import com.raulexposito.ter.model.board.Board;
import com.raulexposito.ter.model.game.checker.VictoryChecker;

public interface VictoryCheckerFixture {

    default VictoryChecker createVictoryChecker(Board board) {
        return new VictoryChecker(board);
    }
}
