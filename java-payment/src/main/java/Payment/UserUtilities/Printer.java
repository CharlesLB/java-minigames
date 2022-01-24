package Payment.UserUtilities;

import Payment.Domain.Sell;
import Payment.Subjects.Employee;
import Payment.Subjects.Seller;

public class Printer {
	public static void menu() {
		System.out.println("Choose action:");
		System.out.println("  [0]: Create seller");
		System.out.println("  [1]: Create manager");
		System.out.println("  [2]: Associate seller to Manager");
		System.out.println("  [3]: Register sells of one seller");
		System.out.println("  [4]: Get employees daily values");
		System.out.println("  [5]: Exit");
	}
	
	public static void getValue(String dataName){
		System.out.println("Insert " + dataName + " :");
	}
	
	public static void employees(Employee[] employees, String employeeName, boolean commission){
		int index = 0;
		
		System.out.println(employeeName + "List");
		
		for (Employee employee: employees) {
			System.out.println("|--- " + index++ + "---------");
			employee(employee, commission);
			System.out.println();
		};
	}
	
	public static void employee(Employee employee, boolean commission){
		System.out.println("Seller " + employee.getName());
		System.out.println("Daily Salary: " + cashParser(employee.getDailySalary()));
		
		if(commission){
			System.out.println("Daily Total: " + cashParser(employee.getDailySalary() + employee.getCommission()));
		}
	}

	public static void sell(Sell sell){
		System.out.println("Sell's Total: " + cashParser(sell.getTotal()));
	}
	
	// utils
	
	private static String cashParser(double value){
		return ("$" + String.format("%.2f", value));
	}
	
	
	public static void exit(){
		System.out.println("Good Bye!");
	}
		
	// Errors
	
	public static void applicationError(String message) {
		System.out.println("Application Error: " + message + "\n");
	}
}
