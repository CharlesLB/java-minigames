package Payment.UserUtilities;

import java.util.Scanner;

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

	public static double getDouble() {
		try {
			double value = scanner.nextDouble();
			scanner.nextLine();
			return value;

		} catch (Exception err) {
			return getDouble();
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
}
