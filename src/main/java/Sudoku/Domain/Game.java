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
				case 1:
					removeSquare();
				case 2:
					verifyGame();
				case 3:
					takeAHint();
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

		if (square.isPossible(false)) {
			Board.insertSquare(square, false);
		} else {
			Printer.squareInsertError(square);
			insertSquare();
		}
	}

	public static void removeSquare() {
		Printer.getPosition();
		Square square = Listener.getSquare(false);

		if (square.fixedVerify()) {

		}
	}

	public static void verifyGame() {

	}

	public static void takeAHint() {

	}

	public static void exit() {
		Printer.exitMessage();
	}
}
