package Payment.Subjects;

public abstract class Employee {
	private String name;
	private double dailySalary;

	public abstract double getCommission();

	public Employee(String name, double dailySalary) {
		this.name = name;
		this.dailySalary = dailySalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDailySalary() {
		return dailySalary;
	}

	public void setDailySalary(double dailySalary) {
		this.dailySalary = dailySalary;
	}
}
