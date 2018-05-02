package com.raulexposito.model.checker;

import com.raulexposito.model.Board;
import com.raulexposito.model.MovementResult;
import com.raulexposito.model.Placement;
import com.raulexposito.model.cell.Chip;

public class AddChecker {

	private static final Integer SAME_CHIP_MAX = 3;

	public MovementResult check(Board board, Chip chip, Placement placement) {
		if (topChipsIsReached(board, chip)
				|| placementIsFilled(board, placement)) {
			return MovementResult.FAILURE;
		}
		return MovementResult.SUCCESS;
	}

	private boolean topChipsIsReached(Board board, Chip chip) {
		return board.count(chip).equals(SAME_CHIP_MAX);
	}

	private boolean placementIsFilled(Board board, Placement placement) {
		return board.isPlacementFilled(placement);
	}
}
