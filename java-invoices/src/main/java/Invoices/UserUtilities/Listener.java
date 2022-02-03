// Nome: Charles Lelis Braga
// Matrícula: 202035015

package Invoices.UserUtilities;

import Invoices.Domain.Date;

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

	public static Date getDate() {
		Printer.getValue("Month");
		int month = getInt();

		Printer.getValue("Year");
		int year = getInt();

		Date date = new Date(month, year);
		return date;
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
