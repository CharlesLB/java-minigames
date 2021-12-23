package EscapeRoom.Domain;

import EscapeRoom.UserUtilities.Listener;
import EscapeRoom.UserUtilities.Printer;

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
