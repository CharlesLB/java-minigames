package Bingo;

import Bingo.Domain.Game;

public class Application {
	public static void main(String[] args) {
		Game.buildMatch();
		Game.startMatch();
	}
}
