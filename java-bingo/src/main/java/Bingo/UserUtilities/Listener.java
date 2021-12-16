package Bingo.UserUtilities;

import java.util.Scanner;

import Bingo.Domain.Position;

public class Listener {
	private static Scanner scanner = new Scanner(System.in);

	public static int getInt() {
		try {
			int value = scanner.nextInt();
			scanner.nextLine();
			return value;

		} catch (Exception err) {
			return getInt();
		}
	}

	public static char getChar() {
		try {
			char value = scanner.next().charAt(0);
			scanner.nextLine();
			return value;

		} catch (Exception err) {
			return getChar();
		}
	}

	public static String getString() {
		try {
			String value = scanner.nextLine();
			return value;

		} catch (Exception err) {
			return getString();
		}
	}

	public static Position getPosition() {
		try {
			Printer.getPosition();

			String positionString = scanner.nextLine();

			if (positionString == "" || positionString == "\n") {
				getPosition();
			}

			String[] positionArray = positionString
					.replace("(", "")
					.replace(")", "")
					.split(",");

			Position position = new Position(
				(Integer.parseInt(positionArray[0].trim()) - 1),
				(Integer.parseInt(positionArray[1].trim()) - 1)
			);

			return position;
		} catch (Exception ex) {
			System.out.println("\n");
			return getPosition();
		}
	}
}
