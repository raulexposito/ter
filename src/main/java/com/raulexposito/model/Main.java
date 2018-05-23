package com.raulexposito.model;

import com.raulexposito.model.game.Game;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.player.Player;
import com.raulexposito.model.player.RandomPlayer;

import static com.raulexposito.model.board.Piece.CIRCLE;
import static com.raulexposito.model.board.Piece.CROSS;

public class Main {

    public static void main(String[] args) {
        final Player cross = new RandomPlayer(CROSS);
        final Player circle = new RandomPlayer(CIRCLE);

        final Game game = new Game(cross, circle);

        final Result result = game.play();
        System.out.println(result.toJSON());
    }
}
