// Nome: Charles Lelis Braga
// Matrícula: 202035015

package Invoices.Domain;

public class Date {
	private int month;
	private int year;

	public Date(int month, int year) {
		this.month = month;
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int differenceOfMonths(Date date) throws Exception {
		if ((date.getYear() < this.getYear()) || (date.getYear() == this.getYear() && date.getMonth() < this.getMonth())) {
			throw new Exception("The posted date is later");
		}

		return (date.getYear() - this.getYear()) * 12 + date.getMonth() - this.getMonth();
	}
}
