package TicTacToe.Domain;

import TicTacToe.UserUtilities.Printer;

public class Board {
	public static final int GRID_LENGTH = 3;
	private char[][] board = {
			{ ' ', ' ', ' ' },
			{ ' ', ' ', ' ' },
			{ ' ', ' ', ' ' }
	};

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public void insert(Position position, char symbol) {
		this.board[position.getY()][position.getX()] = symbol;
		this.print();
	}

	public boolean isPlayerWinner(char symbol) {
		return ((this.board[0][0] == symbol && this.board[0][1] == symbol && this.board[0][2] == symbol) ||
				(this.board[1][0] == symbol && this.board[1][1] == symbol && this.board[1][2] == symbol) ||
				(this.board[2][0] == symbol && this.board[2][1] == symbol && this.board[2][2] == symbol) ||
				(this.board[0][0] == symbol && this.board[1][0] == symbol && this.board[2][0] == symbol) ||
				(this.board[0][1] == symbol && this.board[1][1] == symbol && this.board[2][1] == symbol) ||
				(this.board[0][2] == symbol && this.board[1][2] == symbol && this.board[2][2] == symbol) ||
				(this.board[0][0] == symbol && this.board[1][1] == symbol && this.board[2][2] == symbol) ||
				(this.board[0][2] == symbol && this.board[1][1] == symbol && this.board[2][0] == symbol));
	}

	public boolean isValidMove(Position position) {
		if(position.getX() > (GRID_LENGTH - 1) || position.getX() < 0){
			return false;
		}

		if(position.getY() > GRID_LENGTH - 1 || position.getY() < 0){
			return false;
		}
		
		if(this.board[position.getY()][position.getX()] != ' '){
			return false;
		}
		
		return true;
	}

	public void print() {
		Printer.printBoard(this.board);
	}
	
	public void clean(){
		char[][] cleanBoard = {
			{ ' ', ' ', ' ' },
			{ ' ', ' ', ' ' },
			{ ' ', ' ', ' ' }
		};

		setBoard(cleanBoard);
	}
}
