package Sudoku.UserUtilities;

import Sudoku.Domain.Square;

import java.util.Scanner;

public class Listener {
	private static Scanner scanner = new Scanner(System.in);

	public static int getValue() {
		int value = scanner.nextInt();
		scanner.nextLine();

		return value;
	}

	public static Square getSquare(boolean withValue) {
		try {
			Printer.getSquare();

			String position = scanner.nextLine();

			if (position == "" || position == "\n") {
				getSquare(withValue);
			}

			String[] positionArray = position
					.replace("(", "")
					.replace(")", "")
					.split(",");

			Square square = withValue ? new Square(
					Integer.parseInt(positionArray[1].trim()),
					Integer.parseInt(positionArray[0].trim()),
					Integer.parseInt(positionArray[2].trim()))
					: new Square(
							Integer.parseInt(positionArray[1].trim()),
							Integer.parseInt(positionArray[0].trim()),
							0);

			return square;
		} catch (Exception ex) {
			System.out.println("\n");
			return getSquare(withValue);
		}
	}

}
