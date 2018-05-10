package com.raulexposito.model.game;

import com.raulexposito.model.Color;

// Contemplar el empate
public class GameResult {

	private Steps steps;

	private Color winner;

	public GameResult(Steps steps, Color winner) {
		this.steps = steps;
		this.winner = winner;
	}

	public Steps getSteps() {
		return steps;
	}

	public Color getWinner() {
		return winner;
	}
}
