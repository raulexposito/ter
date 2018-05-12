package com.raulexposito.model.game.player;

import com.raulexposito.model.board.Board;
import com.raulexposito.model.game.Player;

public interface PlayerFixture {

    Integer MAX_SAME_COLOR_PIECES = 3;

    default Board move (Board board, Player player, Integer times) {
        for (int i = 0; i < times; i++) {
            board = player.move(board).getBoard();
        }
        return board;
    }
}
