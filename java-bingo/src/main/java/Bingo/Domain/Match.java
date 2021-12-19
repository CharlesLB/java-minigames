package Bingo.Domain;

import Bingo.Players.Player;
import Bingo.UserUtilities.Listener;
import Bingo.UserUtilities.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Match {
	private List<Player> players;
	public static List<Integer> drawnNumbers = new ArrayList<>(75);

	Random random = new Random();

	public List<Player> getPlayers() {
		return players;
	}

	public Match(int numberOfPlayers) {
		this.players = new ArrayList<>(numberOfPlayers);

		for (int i = 1; i <= numberOfPlayers; i++) {
			Player newPlayer = new Player(i);
			this.players.add(newPlayer);
		}

	}

	public void start() {
		Printer.startMatch(this.getPlayers().toArray(Player[]::new));

		while (true) {
			boolean playAgain = playRound();
			if (!playAgain) {
				return;
			}
		}
	}

	private boolean playRound() {
		Listener.waitEnter();

		int numberDrawn = drawnNumber();

		List<Player> winners = playersPlay(numberDrawn);

		Printer.printBoards(this.getPlayers().toArray(Player[]::new));

		if (winners.size() > 0) {
			Printer.winner(winners.toArray(Player[]::new));
			return false;
		}

		return true;
	}

	private int drawnNumber() {
		while (true) {
			int numberDrawn = random.nextInt(75) + 1;

			if (!drawnNumbers.contains(numberDrawn)) {
				drawnNumbers.add(numberDrawn);
				Printer.printNumber(numberDrawn);
				return numberDrawn;
			}
		}
	}

	private List<Player> playersPlay(int numberDrawn) {
		Player currentPlayer;
		List<Player> winners = new ArrayList<>();

		for (int i = 0; i < this.getPlayers().size(); i++) {
			currentPlayer = this.getPlayers().get(i);
			currentPlayer.markNumber(numberDrawn);

			if (currentPlayer.isWinner()) {
				winners.add(currentPlayer);
			}
		}

		return winners;
	}
}
