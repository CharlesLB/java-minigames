package EscapeRoom.Domain;

import EscapeRoom.Players.Path;
import EscapeRoom.Players.Player;
import EscapeRoom.UserUtilities.Printer;

public class Game {

	public static void buildMatch() {
		Board.createBoard();
	}
	
	public static void playGame(){
		while (true){
			Printer.printBoard(Board.getData());
			
			int moveStatus = Player.play();
		
			switch (moveStatus){
				case 0:
					break;
				case 1:
					Printer.diedBomb();
					return;
				case 2:
					Printer.diedLeft();
					return;
				case 3:
					Printer.winner();
				default:
					Printer.applicationError("Invalid Status");
					return;
			}
		}
	}
}
