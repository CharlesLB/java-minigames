package Sudoku.UserUtilities;

public class Printer {
	public static void printGetInitialBoardTypeText(){
		System.out.println("Choose initial board type: \n");
		System.out.println("  [0]: random board \n");
		System.out.println("  [1]: manual builder board \n");
	}

	public static void printBoardTypeError(){
		System.out.println("Invalid board type \n");
	}
	
	
}
