package Sudoku.Domain;

import Sudoku.UserUtilities.Listener;
import Sudoku.UserUtilities.Printer;

public class Game {
	public static void buildBoard() {
		Board.buildBoard(getInitialBoardType());
	}

	public static int getInitialBoardType() {
		Printer.printGetInitialBoardTypeText();
		int initialBoardType = Listener.getValue();

		return initialBoardType;
	}

}
