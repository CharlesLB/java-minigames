// Nome: Charles Lelis Braga
// Matrícula: 202035015

package Invoices.Domain;

public abstract class Investment implements Income {
	private String name;
	private double value;
	private Date hiringDate;

	public Investment(String name, double value, Date hiringDate) {
		this.name = name;
		this.value = value;
		this.hiringDate = hiringDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}
}
