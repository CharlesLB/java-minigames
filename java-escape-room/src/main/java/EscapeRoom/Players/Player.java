package EscapeRoom.Players;

import EscapeRoom.Domain.Board;
import EscapeRoom.UserUtilities.Listener;

import java.util.ArrayList;
import java.util.List;

public class Player {
	public static List<Path> paths = new ArrayList<>();
	public static int y = 0;
	public static int x = 0;

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		move(y, getX());
		Player.y = y;
	}

	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		move(getY(), x);
		Player.x = x;
	}

	public static int play(){
		Path path = Listener.getPath();
		paths.add(path);
		
		System.out.println(Player.x +" "+ Player.y);
		
		int wayStatus = path.move();
		
		return wayStatus;
	}
	
	private static void move(int newY, int newX){
		Board.data[getY()][getX()] = 0;
		Board.data[newY][newX] = 'P';
	}
}
