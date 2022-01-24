package EscapeRoom.Domain;

import EscapeRoom.UserUtilities.Listener;

import java.util.Random;

public class Board {
	public static final int GRID_LENGTH = 10;
	public static char[][] data;

	public static char[][] getData() {
		return data;
	}

	public static void setData(char[][] data) {
		Board.data = data;
	}

	public static void createBoard() {
		char[][] boardData = createTemplateBoard();
		Random random = new Random();
		int x;
		int y;

		int bombsRemaining = Listener.getBombs();

		while (bombsRemaining > 0) {
			x = random.nextInt(Board.GRID_LENGTH);
			y = random.nextInt(Board.GRID_LENGTH);

			if (boardData[y][x] == 0) {
				boardData[y][x] = 'B';
				bombsRemaining--;
			}

		}

		setData(boardData);
	}

	private static char[][] createTemplateBoard() {
		char[][] boardTemplate = new char[GRID_LENGTH][GRID_LENGTH];

		boardTemplate[0][0] = 'P';
		boardTemplate[8][8] = 'S';

		return boardTemplate;
	}
}
