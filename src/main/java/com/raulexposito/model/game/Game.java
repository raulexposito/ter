package com.raulexposito.model.game;

import com.raulexposito.model.Color;
import com.raulexposito.model.game.checker.LimitsReachedChecker;
import com.raulexposito.model.game.result.Result;
import com.raulexposito.model.game.result.Victory;
import com.raulexposito.model.movement.Movement;
import com.raulexposito.model.board.Board;
import com.raulexposito.model.player.Player;

import java.util.HashMap;
import java.util.Map;

import static com.raulexposito.model.Color.*;

public class Game {

	// ------------------------------------------------------------------------
	// CONSTANT VALUES
	// ------------------------------------------------------------------------

	private static final Integer MAX_ATTEMPTS = 20;

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

 	private Map<Color, Player> players = new HashMap<>();
	private LimitsReachedChecker checker = new LimitsReachedChecker();

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	public Game(Player white, Player black) {
	 	this.players.put(WHITE, white);
		this.players.put(BLACK, black);
	 }

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Result play() {
		return play(Board.empty(), Steps.empty(), WHITE, Counter.upTo(MAX_ATTEMPTS));
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	// TODO: tests con jugadores mockeados
	private Result play (Board board, Steps steps, Color color, Counter attempts) {
		return checker.limitsReached(color, steps, attempts).orElseGet(() -> {
			final Movement movement = players.get(color).move(board);
			final Steps currentSteps = steps.add(movement);

			if (movement.isVictory()) {
				return new Victory(currentSteps, color);
			}

			if (movement.isFailed()) {
				return play(board, steps, color, attempts.increase());
			}

			return play(movement.getBoard(), currentSteps, color.getOpposite(), attempts.reset());
		});
	}
}
