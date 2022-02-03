// Nome: Charles Lelis Braga
// Matrícula: 202035015

package Invoices;

import Invoices.Domain.Date;
import Invoices.Domain.Investment;
import Invoices.Models.FixedIncome;
import Invoices.Models.VariableIncome;
import Invoices.UserUtilities.Listener;
import Invoices.UserUtilities.Printer;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
	public static List<Investment> investments = new ArrayList<>();

	public static void accumulatedIncome(Date date) {
		double total = 0;
		for (Investment investment : investments) {
			if ((date.getYear() > investment.getHiringDate().getYear())
					|| (date.getYear() == investment.getHiringDate().getYear()
							&& date.getMonth() > investment.getHiringDate().getMonth())) {
				try {
					double income = investment.calculateIncome(date);
					Printer.investment(investment, income);
					total += income;
				} catch (Exception e) {
					Printer.applicationError("Date Error");
				}

				Printer.total(total);
			}
		}
	};

	public static void readFixedIncome() {
		Printer.getValue("Fixed Invoice's name");
		String name = Listener.getString();

		Printer.getValue("Fixed Invoice's value");
		Double value = Listener.getDouble();

		Date date = Listener.getDate();

		FixedIncome fixedIncome = new FixedIncome(name, value, date);

		investments.add(fixedIncome);
	}

	public static void readVariableIncome() {
		Printer.getValue("Variable Invoice's name");
		String name = Listener.getString();

		Printer.getValue("Variable Invoice's value");
		Double value = Listener.getDouble();

		Date date = Listener.getDate();

		VariableIncome variableIncome = new VariableIncome(name, value, date);

		investments.add(variableIncome);
	}

	public static void main(String[] args) {
		int numberOfFixedIncomes = 3;
		int numberOfVariableIncomes = 2;

		for (int i = 0; i < numberOfFixedIncomes; i++) {
			Printer.getIncome(i + 1, "Fixed Income");
			readFixedIncome();
		}

		for (int i = 0; i < numberOfVariableIncomes; i++) {
			Printer.getIncome(i + 1, "Variable Income");
			readVariableIncome();
		}

		Printer.getValue("Insert Final Date: ");
		Date date = Listener.getDate();
		accumulatedIncome(date);

		Printer.exit();
	}
}
