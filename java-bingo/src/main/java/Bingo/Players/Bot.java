package Bingo.Players;

import Bingo.Domain.Board;
import Bingo.Domain.Position;

import java.util.Random;

public class Bot extends Player {
	public Bot(char symbol) {
		super("Bot", symbol);
	}

	public Position play(Board board) {
		Random rand = new Random();

		while (true) {
			int x = rand.nextInt(3);
			int y = rand.nextInt(3);

			Position position = new Position(y, x);

			if (board.isValidMove(position)) {
				return position;
			}
		}
	}
}
