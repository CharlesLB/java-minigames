package Sudoku.UserUtilities;

import Sudoku.Domain.Square;

public class Printer {
	public static void getInitialBoardTypeText() {
		System.out.println("Choose initial board type:");
		System.out.println("  [0]: random board");
		System.out.println("  [1]: manual builder board");
	}

	public static void randomBoardBuilder() {
		System.out.println("How many squares do you want filled in?");
	}

	public static void startGameMessage() {
		System.out.println("Let's Play Sudoku!");
	}

	public static void menuGame() {
		System.out.println("Choose action:");
		System.out.println("  [0]: Play move");
		System.out.println("  [1]: Remove move");
		System.out.println("  [2]: Verify Game");
		System.out.println("  [3]: Take a hint");
		System.out.println("  [4]: Exit");
	}

	public static void getSquare(boolean withValue) {
		if (withValue) {
			System.out.println("Insert the next square:");
			return;
		}
		System.out.println("Insert a position square '(x,y)':");
	}

	public static void getPosition() {
	}

	public static void exitMessage() {
		System.out.println("Good Bye!");
	}

	// Errors

	public static void boardTypeError() {
		System.out.println("Invalid board type \n");
	}

	public static void squareInsertError(Square square) {
		System.out.println("Unable to insert square (" + square.x + ", " + square.y + ", " + square.value + ")" + "\n");
	}

	public static void listenerError() {
		System.out.println("The value inserted is not valid \n");
	}
}
