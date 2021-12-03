package Sudoku.Domain;

import Sudoku.UserUtilities.Listener;
import Sudoku.UserUtilities.Printer;

public class Game {
	public static void buildBoard() {
		Printer.getInitialBoardTypeText();
		int initialBoardType = Listener.getValue();

		Board.build(initialBoardType);
	}

	public static void playGame() {
		Printer.startGameMessage();

		while (true) {
			Printer.menuGame();

			int option = Listener.getValue();

			switch (option) {
				case 0:
					insertSquare();
					break;
				case 1:
					removeSquare();
					break;
				case 2:
					if (verifyGame()) {
						Printer.win();
						return;
					}
					break;
				case 3:
					takeAHint();
					break;
				case 4:
					exit();
					return;
				default:
					Printer.listenerError();
			}
		}
	}

	public static void insertSquare() {
		Square square = Listener.getSquare(true);

		if (!square.isPossible(false)) {
			Printer.squareInsertError(square);
			insertSquare();
		}

		Board.insertSquare(square, false);
		Board.print();
	}

	public static void removeSquare() {
		Square square = Listener.getSquare(false);

		Board.cleanSquare(square);

		Board.print();
	}

	public static boolean verifyGame() {
		Square square = new Square(0, 0, 0);

		for (int i = 0; i < Board.GRID_LENGTH; i++) {
			for (int j = 0; i < Board.GRID_LENGTH; i++) {
				square.x = j;
				square.y = i;
				square.value = Board.grid[i][j];

				if (!square.verify()) {
					Printer.verifyError(square);
					return false;
				}
			}
		}

		return true;
	}

	public static void takeAHint() {
		Square square = Listener.getSquare(false);

		if (Board.fixedGrid[square.y][square.y] == 1) {
			Printer.fixedError();
		}

		if (Board.grid[square.y][square.y] != 0) {
			Printer.hintError();
		}

		int possibilities = 0;
		int[] possibilitiesValues = new int[Board.GRID_LENGTH];

		for (int i = 1; i <= Board.GRID_LENGTH; i++) {
			square.value = i;

			Printer.squareValue(square);
			if (square.isPossible(false)) {
				possibilitiesValues[possibilities++] = i;
			}
		}

		Printer.showHint(possibilitiesValues);
	}

	public static void exit() {
		Printer.exitMessage();
	}
}
