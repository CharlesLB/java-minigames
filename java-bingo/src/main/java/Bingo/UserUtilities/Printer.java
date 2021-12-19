package Bingo.UserUtilities;

import Bingo.Domain.Match;
import Bingo.Players.Player;
import java.util.List;

public class Printer {
	public static void buildMatch() {
		System.out.println("How many players will play bingo?");
	}

	public static void startMatch(Player[] players) {
		System.out.println("Let's Play Bingo!");
		printBoards(players);
	}

	public static void printNumber(int number) {
		System.out.println("the number drawn was: " + number);
	}

	public static void waitMessage() {
		System.out.println("Drawn number (Press enter) ");
	}

	public static void printBoard(Player player) {
		List<Integer> board = player.getBoard().getData();
		String playerName = String.format("%03d", player.getId());

		System.out.println("-------------------------------");
		System.out.println("| ID " + playerName + "                      |");
		System.out.println("-------------------------------");
		System.out.println("|  B  |  I  |  N  |  G  |  O  |");
		System.out.println("-------------------------------");

		for (int i = 0; i < 5; i++) {
			System.out.println(
					"| "
							+ getValueLine(board.get(i))
							+ " | "
							+ getValueLine(board.get(i + 5))
							+ " | "
							+ (i == 2
									? "   "
									: i > 2
											? getValueLine(board.get(i + 9))
											: getValueLine(board.get(i + 10)))
							+ " | "
							+ getValueLine(board.get(i + 14))
							+ " | "
							+ getValueLine(board.get(i + 19))
							+ " |");

			System.out.println("-------------------------------");
		}
	}

	public static void printBoards(Player[] players) {
		for (Player player : players) {
			printBoard(player);
			System.out.println("\n");
		}
	}

	public static void winner(Player[] players) {
		if (players.length == 1) {
			System.out.println(players[0].getId() + " Wins!");

			printBoard(players[0]);
			return;
		}

		System.out.println("Finish Game.");
		System.out.println("There are " + players.length + " winners: ");

		printBoards(players);
	}

	// utils

	public static String getValueLine(int number) {
		return (Match.drawnNumbers.contains(number) ? "*" : " ") + String.format("%02d", number);
	}

	// errors

	public static void listenerError() {
		System.out.println("The value inserted is not valid \n");
	}

	public static void applicationError(String message) {
		System.out.println("Application Error:" + message + "\n");
	}
}
