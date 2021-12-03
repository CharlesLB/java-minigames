package Sudoku.Domain;

import Sudoku.UserUtilities.Printer;

import java.util.Arrays;
import java.util.Random;

public class Square {
	public int y;
	public int x;
	public int value;

	public Square(int y, int x, int value) {
		this.y = y;
		this.x = x;
		this.value = value;
	}

	public boolean isPossible(boolean fixed) {
		if (!fixed && !fixedVerify()) {
			return false;
		}

		if (this.y >= Board.GRID_BOUNDARY || this.y < 0) {
			return false;
		}

		if (this.x >= Board.GRID_BOUNDARY || this.x < 0) {
			return false;
		}

		if (this.value > 9 || this.value < 1) {
			return false;
		}

		for (int i = 0; i < Board.GRID_BOUNDARY - 1; i++) {
			if (Board.grid[this.y][i] == this.value) {
				return false;
			}

			if (Board.grid[i][this.x] == this.value) {
				return false;
			}
		}

		int x0 = (int) Math.floor(this.x / 3) * 3;
		int y0 = (int) Math.floor(this.y / 3) * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (Board.grid[y0 + i][x0 + j] == this.value) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean verify() {
		return this.value != 0;
	}

	public boolean fixedVerify() {
		return (Board.fixedGrid[this.y][this.x] == 0);
	}

	public static Square getRandom() {
		Random random = new Random();

		Square randomSquare = new Square(
			random.nextInt(Board.GRID_BOUNDARY),
			random.nextInt(Board.GRID_BOUNDARY),
			random.nextInt(Board.GRID_BOUNDARY) + 1);


		if (Board.grid[randomSquare.y][randomSquare.x] != 0) {
			return getRandom();
		}

		if (!randomSquare.isPossible(true)) {
			return getRandom();
		}

		return randomSquare;
	}
}
