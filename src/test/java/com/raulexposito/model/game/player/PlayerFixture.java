package com.raulexposito.model.game.player;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.game.Player;

public interface PlayerFixture {

    Long MAX_SAME_COLOR_PIECES = 3L;

    default Board move (Board board, Player player, Long times) {
        for (int i = 0; i < times; i++) {
            board = player.move(board).getBoard();
        }
        return board;
    }
}
