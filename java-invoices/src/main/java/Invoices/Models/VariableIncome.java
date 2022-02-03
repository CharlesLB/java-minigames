// Nome: Charles Lelis Braga
// Matrícula: 202035015

package Invoices.Models;

import Invoices.Domain.Date;
import Invoices.Domain.Investment;

public class VariableIncome extends Investment {
	private final double VARIABLE_INCOME_RATE = 0.008;

	public VariableIncome(String name, double value, Date hiringDate) {
		super(name, value, hiringDate);
	}

	public double calculateIncome(Date date) throws Exception {
		try {
			double investmentValue = 0.00;
			int pastMonths = this.getHiringDate().differenceOfMonths(date);

			for (int i = 0; i < pastMonths; i++) {
				investmentValue += (investmentValue + this.getValue()) * VARIABLE_INCOME_RATE;
			}

			return investmentValue;
		} catch (Exception err) {
			throw new Exception("Error on get passed months");
		}
	}
}
