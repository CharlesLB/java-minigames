package TicTacToe;

import TicTacToe.Domain.Game;

public class Application {
	Game game;

	public static void main(String[] args) {
		Game.selectMode();
		Game.buildMatch();
		Game.startMatch();	
	}
}
