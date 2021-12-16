package Bingo.Domain;

import Bingo.Players.Bot;
import Bingo.Players.Player;
import Bingo.UserUtilities.Listener;
import Bingo.UserUtilities.Printer;

public class Match {
	private String mode;
	private Player player1;
	private Player player2;
	private Bot bot;
	private Board board = new Board();

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Bot getBot() {
		return bot;
	}

	public void setBot(Bot bot) {
		this.bot = bot;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public static String getModeById(int modeId) {
		switch (modeId) {
			case 0:
				return "pvp";
			case 1:
				return "pve";
			default:
				return null;
		}
	}

	public void start() {
		while (true) {
			Printer.startMatch(this);
			this.board.print();

			switch (this.getMode()) {
				case "pvp":
					pvp();
					break;
				case "pve":
					pve();
					break;
				default:
					Printer.applicationError("Invalid Game Mode");
			}

			if (!playAgain()) {
				return;
			}

			this.board.clean();
		}
	}

	public static boolean playAgain() {
		Printer.playAgain();
		int playAgainCode = Listener.getInt();

		if (playAgainCode != 0 && playAgainCode != 1) {
			Printer.listenerError();
			return playAgain();
		}

		return playAgainCode == 0;
	}

	private void pvp() {
		for (int turn = 1; true; turn++) {
			Position player1Play = this.player1.playerPlay(this.board);
			this.board.insert(player1Play, this.player1.getSymbol());

			if (turn >= 3 && this.board.isPlayerWinner(this.player1.getSymbol())) {
				Printer.winner(this.player1.getName());
				return;
			}

			if (turn == 5) {
				Printer.draw();
				return;
			}

			Printer.playerTurn(this.player2.getName());
			Position player2Play = this.player2.playerPlay(this.board);
			this.board.insert(player2Play, this.player2.getSymbol());

			if (turn >= 3 && this.board.isPlayerWinner(this.player2.getSymbol())) {
				Printer.winner(this.player2.getName());
				return;
			}
		}
	}

	private void pve() {
		for (int turn = 1; true; turn++) {
			Position player1Play = this.player1.playerPlay(this.board);
			this.board.insert(player1Play, this.player1.getSymbol());

			if (turn >= 3 && this.board.isPlayerWinner(this.player1.getSymbol())) {
				Printer.winner(this.player1.getName());
				return;
			}

			if (turn == 5) {
				Printer.draw();
				return;
			}

			Position botPlay = this.bot.play(this.board);
			Printer.botTurn(botPlay);
			this.board.insert(botPlay, this.bot.getSymbol());

			if (turn >= 3 && this.board.isPlayerWinner(this.bot.getSymbol())) {
				Printer.winner(this.bot.getName());
				return;
			}
		}
	}
}
