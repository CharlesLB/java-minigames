package EscapeRoom.Players;

import EscapeRoom.Domain.Board;
import EscapeRoom.UserUtilities.Printer;

import java.util.List;

public class Path {
	private int jumps;
	private char direction;
	public static final List<Character> DIRECTIONS = List.of('e','d','c','b');

	public Path(int jumps, char direction) {
		this.jumps = jumps;
		this.direction = direction;
	}

	public int getJumps() {
		return jumps;
	}
	
	public char getDirection() {
		return direction;
	}
	
	public int move(){
		switch (this.getDirection()){
			case 'e': 
				return goLeft();
			case 'd':
				return goRight();
			case 'c': 
				return goUp();
			case 'b': 
				return goDown();
			default:
				Printer.applicationError("Invalid Direction");
				return 4;
		}
	}

	private int goLeft(){
		for (int i = getJumps(); i > 0; i--){
			if(Player.getX() - 1 < 0){
				return 2;
			}
			
			if(Board.data[Player.getY()][Player.getX() - 1] == 'S'){
				Player.setX(Player.getX() - 1);
				return 3;
			}
			
			if(Board.data[Player.getY()][Player.getX() - 1] == 'B') {
				return 1;
			}

			Player.setX(Player.getX() - 1);
		}
		
		return 0;
	}

	private int goRight(){
		for (int i = getJumps(); i > 0; i--){
			if(Player.getX() + 1 > 9){
				return 2;
			}

			if(Board.data[Player.getY()][Player.getX() + 1] == 'S'){
				Player.setX(Player.getX() + 1);
				return 3;
			}

			if(Board.data[Player.getY()][Player.getX() + 1] == 'B') {
				return 1;
			}

			Player.setX(Player.getX() + 1);
		}

		return 0;
	}

	private int goUp(){
		for (int i = getJumps(); i > 0; i--){
			if(Player.getY() - 1 < 0){
				return 2;
			}

			if(Board.data[Player.getY() - 1][Player.getX()] == 'S'){
				Player.setY(Player.getY() - 1);
				return 3;
			}

			if(Board.data[Player.getY() - 1][Player.getX()] == 'B') {
				return 1;
			}

			Player.setY(Player.getY() - 1);
		}

		return 0;
	}

	private int goDown(){
		for (int i = getJumps(); i > 0; i--){
			if(Player.getY() + 1 > 9){
				return 2;
			}

			if(Board.data[Player.getY() + 1][Player.getX()] == 'S'){
				Player.setY(Player.getY() + 1);
				return 3;
			}

			if(Board.data[Player.getY() + 1][Player.getX()] == 'B') {
				return 1;
			}

			Player.setY(Player.getY() + 1);
		}

		return 0;
	}
}


