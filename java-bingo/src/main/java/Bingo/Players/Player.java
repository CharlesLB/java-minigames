package Bingo.Players;

import Bingo.Domain.Board;

public class Player {
	private int id;
	private Board board;

	public Player(int id) {
		this.id = id;
		this.board = new Board();
	}

	public int getId() {
		return id;
	}

	public Board getBoard() {
		return board;
	}

	public void markNumber(int number) {
		this.board.markNumber(number);
	}

	public boolean isWinner() {
		return this.board.isWinner();
	}
}
