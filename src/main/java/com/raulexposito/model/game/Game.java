package com.raulexposito.model.game;

import com.raulexposito.model.Color;
import com.raulexposito.model.game.movement.Movement;
import com.raulexposito.model.board.Board;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.raulexposito.model.Color.*;

public class Game {

	// ------------------------------------------------------------------------
	// ATTRIBUTES
	// ------------------------------------------------------------------------

 	private Map<Color, Player> players;

	// ------------------------------------------------------------------------
	// CONSTRUCTOR
	// ------------------------------------------------------------------------

	public Game(Player white, Player black) {
	 	this.players = new HashMap<Color, Player>() {{
	 		put(WHITE, white);
			put(BLACK, black);
		}};
	 }

	// ------------------------------------------------------------------------
	// BUSINESS LOGIC
	// ------------------------------------------------------------------------

	public Color play() {
		return play(Board.empty(), WHITE, Counter.initSteps(), Counter.initAttempts());
	}

	// ------------------------------------------------------------------------
	// PRIVATE METHODS
	// ------------------------------------------------------------------------

	private Color play (Board board, Color turn, Counter steps, Counter attempts) {
		return limitsReached(turn, steps, attempts).orElseGet(() -> {
			final Movement movement = players.get(turn).move(board);

			if (movement.isVictory()) {
				return turn;
			}

			if (movement.isFailure()) {
				return play(board, turn, steps, attempts.increase());
			}

			return play(movement.getBoard(), turn.getOpposite(), steps.increase(), Counter.initAttempts());
		});
	}

	// TODO: sacar a otra clase tipo checker
	private Optional<Color> limitsReached(Color turn, Counter steps, Counter attempts) {
		if (steps.maxReached()) {
			// TODO: empate
			return Optional.of(WHITE);
		}

		if (attempts.maxReached()) {
			return Optional.of(turn.getOpposite());
		}

		return Optional.empty();
	}
}
