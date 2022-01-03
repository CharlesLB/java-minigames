package EscapeRoom.UserUtilities;

import EscapeRoom.Domain.Board;
import EscapeRoom.Players.Path;
import EscapeRoom.Players.Player;

public class Printer {
	public static void startMatch(char[][] board) {
		System.out.println("Let's Play Escape Room!");
		printBoard(board);
	}

	public static void getBombs() {
		System.out.println("How many bombs will there be on the board? (max: 30) \n");
	}

	public static void getPath() {
		System.out.println("Insert a position square '(direction , jumps)':");
	}

	public static void printPath(Path path) {
		System.out.println("[ " + path.getDirection() + "," + path.getJumps() + " ]");
	}

	public static void paths() {
		System.out.println("Your moves");

		for (Path path : Player.paths) {
			printPath(path);
		}
	}

	public static void printBoard(char[][] board) {
		for (int i = 0; i < Board.GRID_LENGTH; i++) {
			for (int j = 0; j < Board.GRID_LENGTH; j++) {
				System.out.print("[" + (board[i][j] == 0 ? " " : board[i][j]) + "]");
			}

			System.out.print("\n");
		}
	}

	public static void diedBomb() {
		System.out.println("You died in a bomb");
		paths();
	}

	public static void diedLeft() {
		System.out.println("You left the board");
		paths();
	}

	public static void winner() {
		System.out.println("You Win");
		paths();
	}

	// errors

	public static void listenerError() {
		System.out.println("The value inserted is not valid \n");
	}

	public static void directionError() {
		System.out.println("This direction is not valid \n");
	}

	public static void applicationError(String message) {
		System.out.println("Application Error:" + message + "\n");
	}
}
