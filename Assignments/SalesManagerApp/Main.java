package GestioneVendite;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		Purchase purchase1 = new Purchase("dress",3.50,"Zara",LocalDate.of(2020,1,8));
		Purchase purchase2 = new Purchase("computer",350.50,"MediaWorld",LocalDate.of(2020,1,8));
		Purchase purchase3 = new Purchase("phone",390.90,"MediaWorld",LocalDate.of(2020,1,8));
		Purchase purchase4 = new Purchase("dress",3.50,"H&M",LocalDate.of(2020,1,8));
		Purchase purchase5 = new Purchase("food",3.50,"McDonald",LocalDate.of(2020,1,8));
		
		ArrayList<Purchase> purchases01 = new ArrayList<Purchase>();
		purchases01.add(purchase1);
		purchases01.add(purchase2);
		
		ArrayList<Purchase> purchases02 = new ArrayList<Purchase>();
		purchases02.add(purchase3);
		purchases02.add(purchase4);
		purchases02.add(purchase5);
		
		ArrayList<Purchase> purchases03 = new ArrayList<Purchase>();
		purchases03.add(purchase2);
		purchases03.add(purchase4);
		
		
		Customer customer1 = new Customer("Mario","Rossi",12345,"Milan",purchases01);
		Customer customer2 = new Customer("Milena","Bianchi",54321,"Rome",purchases02);
		Customer customer3 = new Customer("Roberto","Verdi",98765,"Turin",purchases03);
		
		ArrayList<Customer> customersList = new ArrayList<Customer>();
		customersList.add(customer1);
		customersList.add(customer2);
		customersList.add(customer3);
		
		
		while(true) {
			System.out.println("\nDigit recognition code:\n[1]Employee\n[2]Administrator\nDigit here:");
			Scanner c = new Scanner(System.in);
			int code = c.nextInt();
			//System.out.println(code);
			if (code == 1) {
				System.out.println("EMPLOYEE CONSOLE\n");
				Employee employee = new Employee();
				
				System.out.println("Select action: [1 to insert] [2 to update] [3 to list customer purchases] [4 to add purches] [5 to list all customers]");
				Scanner a = new Scanner(System.in);
				int action = a.nextInt();
				
				if(action == 1) {
					employee.newCustomer(customersList);
					employee.readCustomerList(customersList);
				}else if (action == 2) {
					employee.updateCustomer(customersList);
					employee.readCustomerList(customersList);
				}else if (action == 3) {
					employee.listPurchases(customersList);
				}else if (action == 4) {
					employee.addPurchase(customersList);
				}else if (action == 5) {
					employee.readCustomerList(customersList);
				}else {
					System.out.println("Command not found");
				}
		
				
			}else if (code == 2) {
				System.out.println("ADMINISTRATOR CONSOLE\n");
			}else {
				System.out.println("Uknown code");
			}
		}

	}
}
  


