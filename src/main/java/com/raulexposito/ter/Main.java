package com.raulexposito.ter;

import com.raulexposito.ter.model.game.Game;
import com.raulexposito.ter.model.game.result.Result;
import com.raulexposito.ter.model.player.Player;
import com.raulexposito.ter.model.player.RandomPlayer;

import static com.raulexposito.ter.model.board.Piece.CIRCLE;
import static com.raulexposito.ter.model.board.Piece.CROSS;

public class Main {

    public static void main(String[] args) {
        final Player cross = new RandomPlayer(CROSS);
        final Player circle = new RandomPlayer(CIRCLE);

        final Game game = new Game(cross, circle);

        final Result result = game.play();
        System.out.println(result.toJSON());
    }
}
