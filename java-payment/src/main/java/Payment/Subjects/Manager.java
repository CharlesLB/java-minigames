package Payment.Subjects;

import Payment.Domain.Sell;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
	public static final double COMMISSION = 0.005;
	public List<Seller> sellers = new ArrayList<>();

	public Manager(String name, double dailySalary) {
		super(name, dailySalary);
	}

	public double getCommission() {
		double total = 0;
		
		for(Seller seller: sellers){
			for (Sell sell: seller.sells){
				total += sell.getTotal() * COMMISSION;
			}
		}
		
		return total;
	}
}
