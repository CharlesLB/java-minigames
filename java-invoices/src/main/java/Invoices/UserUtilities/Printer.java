// Nome: Charles Lelis Braga
// Matrícula: 202035015

package Invoices.UserUtilities;

import Invoices.Domain.Date;
import Invoices.Domain.Investment;

public class Printer {
	public static void total(double total) {
		System.out.println("Total invested: " + cashParser(total));
	}

	public static void investment(Investment investment, double income) {
		System.out.println("Name of Investment: " + investment.getName());
		System.out.println("  Invested value: " + investment.getValue());
		System.out.println("  Hiring date: " + date(investment.getHiringDate()));
		System.out.println("  Acumulated Invoice: " + cashParser(income));
	}

	public static void getIncome(int id, String type) {
		System.out.println("Read " + id + " of " + type + " list");
	}

	public static void getValue(String dataName) {
		System.out.println("Insert " + dataName + " :");
	}

	public static void exit() {
		System.out.println("Good Bye!");
	}

	// utils

	private static String cashParser(double value) {
		return ("$" + String.format("%.2f", value));
	}

	private static String date(Date date) {
		return (date.getMonth() + "/" + date.getYear());
	}

	// Error

	public static void applicationError(String message) {
		System.out.println("Application Error: " + message + "\n");
	}
}
