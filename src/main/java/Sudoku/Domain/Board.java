package Sudoku.Domain;

import Sudoku.UserUtilities.Printer;

public class Board {
	private static final int GRID_BOUNDARY = 9;

	private static int[][] grid = new int[GRID_BOUNDARY][GRID_BOUNDARY];
	private static int[][] fixedGrid = new int[GRID_BOUNDARY][GRID_BOUNDARY];

	public Board(int[][] grid, int[][] fixedGrid) {
		this.grid = grid;
		this.fixedGrid = fixedGrid;
	}

	public static void buildBoard(int boardType) {
		switch (boardType){
			case 0:
				System.out.println("Dez");
				break;
			case 1:
				System.out.println("Numero muito grande");
				break;
			default:
				Printer.printBoardTypeError();
				Game.buildBoard();
		}		
	}

	public static void buildRandomBoard() {
		return;
	}

	public static void buildManuallyBoard() {
		return;
	}

	public static void printGrid() {
		for (int i = 0; i < GRID_BOUNDARY; i++) {
			for (int j = 0; j < GRID_BOUNDARY; j++) {
				if (j % 3 == 0 && j != 0) System.out.print("   ");
				System.out.print("[" + grid[i][j] + "]");
			}

			if ((i+1) % 3 == 0 && i != 8) System.out.print("\n");

			System.out.print("\n");
		}
	}
}
