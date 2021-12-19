package Bingo.Domain;

import Bingo.UserUtilities.Listener;
import Bingo.UserUtilities.Printer;

public class Game {
	private static Match match;

	public static void buildMatch() {
		Printer.buildMatch();
		int playersNumber = Listener.getInt();

		match = new Match(playersNumber);
	}

	public static void startMatch() {
		match.start();
	}
}
