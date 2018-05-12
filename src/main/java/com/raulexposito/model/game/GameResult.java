package com.raulexposito.model.game;

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

	@Override
	public String toString() {
		return steps.toString();
	}
}
