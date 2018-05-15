package com.raulexposito.model;

import com.raulexposito.model.game.Game;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.player.Player;
import com.raulexposito.model.player.RandomPlayer;

import static com.raulexposito.model.board.Color.*;

public class Main {

	public static void main(String[] args) {
		final Player white = new RandomPlayer(WHITE);
		final Player black = new RandomPlayer(BLACK);

		final Game game = new Game(white, black);

		final Result result = game.play();
		System.out.println(result);
	}
}
