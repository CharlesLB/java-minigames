package Payment.Domain;

public class Sell {
	private double total;

	public Sell(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
