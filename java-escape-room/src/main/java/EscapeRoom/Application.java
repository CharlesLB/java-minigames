package EscapeRoom;

import EscapeRoom.Domain.Game;

public class Application {
	public static void main(String[] args) {
		Game.buildMatch();
		Game.playGame();
	}
}
