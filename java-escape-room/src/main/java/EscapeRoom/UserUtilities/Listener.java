package EscapeRoom.UserUtilities;

import EscapeRoom.Players.Path;

import java.util.Scanner;

public class Listener {
	private static Scanner scanner = new Scanner(System.in);

	public static int getBombs() {
		int value;
		
		while (true) {
			try {
				Printer.getBombs();

				value = scanner.nextInt();
				scanner.nextLine();

				if (value > 0 && value <= 30) {
					return value;
				}

				Printer.listenerError();

			} catch (Exception err) {
				return getBombs();
			}
		}
	}

	public static Path getPath() {
		try {
			Printer.getPath();

			String position = scanner.nextLine();

			if (position == "" || position == "\n") {
				Printer.applicationError("Erro de espaço");
				getPath();
			}

			String[] positionArray = position
				.replace("(", "")
				.replace(")", "")
				.split(",");

			Path path = new Path(
				Integer.parseInt(positionArray[1].trim()),
				positionArray[0].charAt(0))
				;
			
			if(!Path.DIRECTIONS.contains(path.getDirection())){
				Printer.directionError();
				getPath();
			}

			return path;
		} catch (Exception ex) {
			System.out.println("\n");
			return getPath();
		}
	}
}
