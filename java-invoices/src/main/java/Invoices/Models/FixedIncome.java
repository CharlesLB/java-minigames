// Nome: Charles Lelis Braga
// Matrícula: 202035015

package Invoices.Models;

import Invoices.Domain.Date;
import Invoices.Domain.Investment;

public class FixedIncome extends Investment {
	private final double FIXED_INCOME_RATE = 0.005;

	public FixedIncome(String name, double value, Date hiringDate) {
		super(name, value, hiringDate);
	}

	public double calculateIncome(Date date) throws Exception {
		try {
			int pastMonths = this.getHiringDate().differenceOfMonths(date);
			return pastMonths * this.getValue() * FIXED_INCOME_RATE;
		} catch (Exception err) {
			throw new Exception("Error on get passed months");
		}
	}
}
