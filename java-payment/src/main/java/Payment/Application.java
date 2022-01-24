package Payment;

import Payment.Domain.Sell;
import Payment.Subjects.Employee;
import Payment.Subjects.Manager;
import Payment.Subjects.Seller;
import Payment.UserUtilities.Listener;
import Payment.UserUtilities.Printer;

import javax.print.attribute.standard.PrinterURI;
import java.util.ArrayList;
import java.util.List;

public class Application {
	public static List<Seller> sellers = new ArrayList<>();
	public static List<Manager> managers = new ArrayList<>();
	
	public static void createSeller(){
		Printer.getValue("Seller's name");
		String sellerName = Listener.getString();

		Printer.getValue("Seller's daily Salary");
		Double sellerDailySalary = Listener.getDouble();
		
		Seller seller = new Seller(sellerName, sellerDailySalary);
		
		sellers.add(seller);
	
		Printer.employee(seller, false);
	}

	public static void createManager(){
		Printer.getValue("Manager's name");
		String managerName = Listener.getString();

		Printer.getValue("Manager's daily Salary");
		Double managerDailySalary = Listener.getDouble();

		Manager manager = new Manager(managerName, managerDailySalary);

		managers.add(manager);

		Printer.employee(manager, false);
	}

	public static void AssociateSellerToManager(){
		if(managers.size() == 0){
			Printer.applicationError("There is not manager registered");
			return;
		}

		if(sellers.size() == 0){
			Printer.applicationError("There is not seller registered");
			return;
		}
		
		Manager manager = getManager();
		Seller seller = getSeller();
		
		manager.sellers.add(seller);
	}

	public static void RegisterSellsOfOneSeller(){
		if(sellers.size() == 0){
			Printer.applicationError("There is not seller registered");
			return;
		}

		Seller seller = getSeller();

		while (true){
			Printer.getValue("Sell's total (Insert 0 to finish)");
			double total = Listener.getDouble();

			if (total == 0){
				return;
			}
			
			Sell sell = new Sell(total);

			Printer.sell(sell);
			seller.sells.add(sell);
		}
	}
	
	public static void getEmployeesDailyValues(){
		if(managers.size() == 0 && sellers.size() == 0){
			Printer.applicationError("There are not managers or sellers");
		}
		
		if(managers.size() > 0){
			Printer.employees(managers.stream().toArray(Employee[]::new), "Managers", true);
		}

		if(sellers.size() > 0){
			Printer.employees(sellers.stream().toArray(Employee[]::new), "Sellers", true);
		}
	}
	
	public static Seller getSeller(){
		int sellerReference;
		
		Printer.employees(sellers.stream().toArray(Employee[]::new), "Sellers", false);

		do{
			Printer.getValue("Seller ID");
			sellerReference = Listener.getInt();

			if(sellerReference < 0 || sellerReference >= managers.size()){
				Printer.applicationError("Seller " + sellerReference + " doesn't exist." + sellers.size());
			}
		}while (sellerReference < 0 || sellerReference >= sellers.size());
		
		return sellers.get(sellerReference);
	}

	public static Manager getManager(){
		int managerReference;

		Printer.employees(managers.stream().toArray(Employee[]::new), "Managers", true);

		do{
			Printer.getValue("Manager ID");
			managerReference = Listener.getInt();

			if(managerReference < 0 || managerReference >= managers.size()){
				Printer.applicationError("Manager " + managerReference + " doesn't exist.");
			}
		}while (managerReference < 0 || managerReference >= managers.size());
		
		return managers.get(managerReference);
	}

	public static void exit(){
		Printer.exit();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		int option;
		
		while (true){
			Printer.menu();
			option = Listener.getInt();
			
			switch (option){
				case 0: 
					createSeller();
					break;
				case 1: 
					createManager();
					break;
				case 2: 
					AssociateSellerToManager();
					break;
				case 3: 
					RegisterSellsOfOneSeller();
					break;
				case 4: 
					getEmployeesDailyValues();
					break;
				case 5: 
					exit();
					break;
				default: 
					Printer.applicationError("Invalid Option, try again.");
			}
		}
	}
}
