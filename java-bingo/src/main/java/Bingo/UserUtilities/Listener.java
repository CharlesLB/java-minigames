package Bingo.UserUtilities;

import java.util.Scanner;

public class Listener {
	private static Scanner scanner = new Scanner(System.in);

	public static int getInt() {
		try {
			int value;

			do {
				value = scanner.nextInt();
				scanner.nextLine();

				if (value <= 0) {
					Printer.listenerError();
				}
			} while (value <= 0);

			return value;

		} catch (Exception err) {
			return getInt();
		}
	}

	public static void waitEnter() {
		Printer.waitMessage();
		scanner.nextLine();
	}
}
