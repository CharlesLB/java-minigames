package Bingo.Players;

import Bingo.Domain.Board;
import Bingo.Domain.Position;
import Bingo.UserUtilities.Listener;
import Bingo.UserUtilities.Printer;

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
