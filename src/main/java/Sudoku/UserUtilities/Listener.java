package Sudoku.UserUtilities;

import java.util.Arrays;
import java.util.Scanner;

public class Listener {
	private static Scanner scanner = new Scanner(System.in);

	public static int getValue() {
		return scanner.nextInt();
	}

	public static int[] getPositionValue() {
		String position = scanner.nextLine();

		String[] positionArray = position
			.replace("(", "")
			.replace(")", "")
			.split(",");

		int[] positionValues = {
			Integer.parseInt(positionArray[0].trim()),
			Integer.parseInt(positionArray[1].trim()),
			Integer.parseInt(positionArray[2].trim())
		};

		return positionValues;
	}
}

