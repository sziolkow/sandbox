package logic;

public class PositionChecker {

	protected Result checkRows(int[][] playfield) {
		Result result = Result.DRAWN;
		for (int i = 0; i < playfield.length; i++) {
			result = checkOneRow(playfield[i]);
			if (result.equals(Result.WON)) {
				break;
			}
		}

		return result;
	}

	private Result checkOneRow(int[] playfield) {
		Result result = Result.WON;
		for (int i = 0; i < playfield.length; i++) {
			if (playfield[i] == 0) {
				result = Result.DRAWN;
				break;
			}
		}
		return result;
	}

	protected Result checkColumns(int[][] playfield) {
		Result result = Result.DRAWN;
		for (int i = 0; i < playfield.length; i++) {
			result = checkOneColumn(playfield, i);
			if (result.equals(Result.WON)) {
				break;
			}
		}

		return result;
	}

	private Result checkOneColumn(int[][] playfield, int columnIndex) {
		Result result = Result.WON;
		for (int i = 0; i < playfield.length; i++) {
			if (playfield[i][columnIndex] == 0) {
				result = Result.DRAWN;
				break;
			}
		}
		return result;
	}

	protected Result checkDiagonals(int[][] playfield) {
		Result result = Result.DRAWN;
		result = checkDiagonal(playfield, 0);
		if (result.equals(Result.DRAWN)) {
			result = checkDiagonal(playfield, playfield.length - 1);
		}
		return result;
	}

	private Result checkDiagonal(int[][] playfield, int startIndex) {
		Result result = Result.WON;
		int column = 0;
		for (int i = 0; i < playfield.length; i++) {

			column = ((startIndex == 0) ? i : startIndex - i);

			if (playfield[i][column] == 0) {
				result = Result.DRAWN;
				break;
			}
		}
		return result;
	}

	public Result checkGame(int[][] playfield) {
		Result result = Result.DRAWN;
		result = checkRows(playfield);
		if (result.equals(Result.DRAWN)) {
			result = checkColumns(playfield);
		}
		if (result.equals(Result.DRAWN)) {
			result = checkDiagonals(playfield);
		}
		return result;
	}
}