package Bingo.Domain;

import Bingo.Players.Bot;
import Bingo.Players.Player;
import Bingo.UserUtilities.Listener;
import Bingo.UserUtilities.Printer;

public class Game {
	private static Match match = new Match();

	public static void selectMode() {
		Printer.selectMode();
		int modeId = Listener.getInt();
		String matchMode = Match.getModeById(modeId);

		if (matchMode == null) {
			Printer.listenerError();
			selectMode();
			return;
		}

		match.setMode(matchMode);
	}

	public static void buildMatch() {
		switch (match.getMode()) {
			case "pvp":
				buildPvp();
				return;
			case "pve":
				buildPve();
				return;
			default:
				Printer.applicationError("Invalid Game Mode");
		}
	}

	public static void startMatch() {
		match.start();
	}

	private static void buildPvp() {
		createPlayer(1);
		createPlayer(2);
	}

	private static void buildPve() {
		createPlayer(1);
		createBot();
	}

	private static void createBot() {
		char botSymbol = match.getPlayer1().getSymbol() == 'X' ? 'O' : 'X';
		Bot bot = new Bot(botSymbol);

		match.setBot(bot);
	}

	private static void createPlayer(int playerNumber) {
		String playerName;
		char playerSymbol;

		switch (playerNumber) {
			case 1:
				Printer.getPlayerData(playerNumber, "name");
				playerName = Listener.getString();

				Printer.getPlayerData(playerNumber, "symbol");
				playerSymbol = Listener.getChar();

				Player player1 = new Player(playerName, playerSymbol);
				match.setPlayer1(player1);

				return;

			case 2:
				do {
					Printer.getPlayerData(playerNumber, "name");
					playerName = Listener.getString();

					if ((match.getPlayer1().getName()).equals(playerName)) {
						Printer.playerDataError("name");
					}

				} while ((match.getPlayer1().getName()).equals(playerName));

				do {
					Printer.getPlayerData(playerNumber, "symbol");
					playerSymbol = Listener.getChar();

					if (match.getPlayer1().getSymbol() == playerSymbol) {
						Printer.playerDataError("symbol");
					}

				} while (match.getPlayer1().getSymbol() == playerSymbol);

				Player player2 = new Player(playerName, playerSymbol);
				match.setPlayer2(player2);
		}
	}
}
