package com.raulexposito.model;

import com.raulexposito.model.game.Game;
import com.raulexposito.model.game.GameResult;
import com.raulexposito.model.game.Player;
import com.raulexposito.model.game.checker.LimitsReachedChecker;
import com.raulexposito.model.game.Color;
import com.raulexposito.model.player.RandomPlayer;

public class Main {

	public static void main(String[] args) {
		final Player white = new RandomPlayer(Color.WHITE);
		final Player black = new RandomPlayer(Color.BLACK);

		final Game game = new Game(white, black, new LimitsReachedChecker());

		final GameResult result = game.play();
		System.out.println(result);
	}
}
