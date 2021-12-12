package TicTacToe.Players;

import TicTacToe.Domain.Board;
import TicTacToe.Domain.Position;
import TicTacToe.UserUtilities.Listener;
import TicTacToe.UserUtilities.Printer;

public class Player {
	private String name;
	private char symbol;

	public Player(String name, char symbol) {
		this.name = name;
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public char getSymbol() {
		return symbol;
	}

	public Position playerPlay(Board board) {
		Printer.playerTurn(this.getName());

		while (true) {
			Position position = Listener.getPosition();

			if (board.isValidMove(position)) {
				return position;
			}

			Printer.listenerError();
		}
	}
}
