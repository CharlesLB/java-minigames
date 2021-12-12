package TicTacToe.Domain;

public class Board {
	public static final int GRID_LENGTH = 9;
	private static int[] board = new int[GRID_LENGTH];
	private static int[][] WINNING_COMBINATIONS = {
			{ 0, 1, 2 },
			{ 3, 4, 5 },
			{ 6, 7, 8 },
			{ 0, 3, 6 },
			{ 1, 4, 7 },
			{ 2, 5, 8 },
			{ 0, 4, 8 },
			{ 2, 4, 6 },
	};

	private void printBoard() {

	}
}
