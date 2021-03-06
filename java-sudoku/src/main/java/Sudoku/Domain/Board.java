package Sudoku.Domain;

import Sudoku.UserUtilities.Listener;
import Sudoku.UserUtilities.Printer;

public class Board {
	public static final int GRID_LENGTH = 9;

	public static int[][] grid = new int[GRID_LENGTH][GRID_LENGTH];
	public static int[][] fixedGrid = new int[GRID_LENGTH][GRID_LENGTH];

	public Board(int[][] grid, int[][] fixedGrid) {
		this.grid = grid;
		this.fixedGrid = fixedGrid;
	}

	public static void build(int boardType) {
		switch (boardType) {
			case 0:
				buildRandom();
				break;
			case 1:
				buildManually();
				break;
			default:
				Printer.boardTypeError();
				Game.buildBoard();
		}
	}

	public static void buildRandom() {
		Printer.randomBoardBuilder();
		int squaresToFill = Listener.getValue();

		while (squaresToFill > 0) {
			Square newSquare = Square.getRandom();
			insertSquare(newSquare, true);

			squaresToFill--;
		}

		print();

		return;
	}

	public static void buildManually() {
		while (true) {
			Square square = Listener.getSquare(true);

			if (isEndOfBuild(square)) {
				return;
			}

			if (square.isPossible(true)) {
				insertSquare(square, true);
				print();
			} else {
				Printer.squareInsertError(square);
			}
		}
	}

	public static boolean isEndOfBuild(Square square) {
		return square.y == -2 && square.x == -2 && square.value == -1;
	}

	public static void insertSquare(Square square, boolean fixedSquare) {
		grid[square.y][square.x] = square.value;

		if (fixedSquare) {
			fixedGrid[square.y][square.x] = 1;
		}
	}

	public static void cleanSquare(Square square) {
		if (!square.fixedVerify()) {
			Printer.listenerError();
		}

		grid[square.y][square.x] = 0;
	}

	public static void print() {
		for (int i = 0; i < GRID_LENGTH; i++) {
			for (int j = 0; j < GRID_LENGTH; j++) {
				if (j % 3 == 0 && j != 0)
					System.out.print("   ");
				System.out.print("[" + grid[i][j] + "]");
			}

			if ((i + 1) % 3 == 0 && i != 8)
				System.out.print("\n");

			System.out.print("\n");
		}

		for (int i = 0; i < 33; i++)
			System.out.print("-");

		System.out.println("\n");

	}
}
