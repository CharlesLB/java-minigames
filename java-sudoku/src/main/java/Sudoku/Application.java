package Sudoku;

import Sudoku.Domain.Game;

public class Application {
	public static void main(String[] args) {
		Game.buildBoard();
		Game.playGame();
	}
}
