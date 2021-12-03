package Sudoku.UserUtilities;

import Sudoku.Domain.Square;

import java.util.Arrays;

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
	
	public static void showHint(int[] hint){
		System.out.println("Hints: " + Arrays.toString(hint).replaceAll(", 0", ""));
	}

	public static void exitMessage() {
		System.out.println("Good Bye!");
	}

	public static void squareValue(Square square) {
		System.out.println("(" + (square.x + 1) + ", " + (square.y + 1) + ", " + square.value + ")" + "\n");
	}
	
	public static void win(){
		System.out.println("Congratulations! You win!");
	}
	

	// Errors

	public static void boardTypeError() {
		System.out.println("Invalid board type \n");
	}

	public static void squareInsertError(Square square) {
		System.out.println("Unable to insert square: ");
		squareValue(square);
		System.out.println("\n");
	}

	public static void listenerError() {
		System.out.println("The value inserted is not valid \n");
	}

	public static void hintError() {
		System.out.println("This square is already filled\n");
	}

	public static void fixedError() {
		System.out.println("This square is fixed \n");
	}

	public static void verifyError(Square square) {
		System.out.println("This square is incorrect");
		squareValue(square);
	}
}
