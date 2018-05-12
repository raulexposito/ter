package com.raulexposito.model.game;

import com.raulexposito.model.game.checker.LimitsReachedChecker;
import com.raulexposito.model.game.movement.Movement;
import com.raulexposito.model.board.Board;

import java.util.HashMap;
import java.util.Map;

import static com.raulexposito.model.game.Color.*;

public class Game {

	// ------------------------------------------------------------------------
	// CONSTANT VALUES
	// ------------------------------------------------------------------------

	private static final Integer MAX_ATTEMPTS = 20;

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

 	private Map<Color, Player> players = new HashMap<>();
	private LimitsReachedChecker checker;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	public Game(Player white, Player black, LimitsReachedChecker checker) {
		this.checker = checker;
	 	this.players.put(WHITE, white);
		this.players.put(BLACK, black);
	 }

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public GameResult play() {
		return play(Board.empty(), Steps.empty(), WHITE, Counter.upTo(MAX_ATTEMPTS));
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	// TODO: tests con jugadores mockeados
	private GameResult play (Board board, Steps steps, Color color, Counter attempts) {
		return checker.limitsReached(color, steps, attempts).orElseGet(() -> {
			final Movement movement = players.get(color).move(board);
			final Steps currentSteps = steps.add(movement);

			if (movement.isVictory()) {
				return new GameResult(currentSteps, color);
			}

			if (movement.isFailure()) {
				return play(board, steps, color, attempts.increase());
			}

			return play(movement.getBoard(), currentSteps, color.getOpposite(), attempts.reset());
		});
	}
}
