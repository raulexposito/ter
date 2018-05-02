package com.raulexposito.model.checker;

import com.raulexposito.model.Board;
import com.raulexposito.model.MovementResult;
import com.raulexposito.model.Placement;
import com.raulexposito.model.cell.Chip;

public class SwapChecker {

	private static final Integer SAME_CHIP_MAX = 3;

	public MovementResult check(Board board, Chip chip, Placement current,
			Placement candidate) {
		if (swapIsInvalid(board, chip, current, candidate)) {
			return MovementResult.FAILURE;
		}
		return MovementResult.SUCCESS;
	}

	private boolean swapIsInvalid(Board board, Chip chip, Placement current,
			Placement candidate) {
		return board.count(chip) < SAME_CHIP_MAX
				|| !board.placementHasChip(current, chip)
				|| board.isPlacementEmpty(current)
				|| board.isPlacementFilled(candidate);
	}
}
