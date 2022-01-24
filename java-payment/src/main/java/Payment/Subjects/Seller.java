package Payment.Subjects;

import Payment.Domain.Sell;

import java.util.ArrayList;
import java.util.List;

public class Seller extends Employee {
	public static final double COMMISSION = 0.01;
	public List<Sell> sells = new ArrayList<>();

	public Seller(String name, double dailySalary) {
		super(name, dailySalary);
	}

	public double getCommission() {
		double total = 0;

		for (Sell sell : sells) {
			total += sell.getTotal() * COMMISSION;
		}

		return total;
	}
}
