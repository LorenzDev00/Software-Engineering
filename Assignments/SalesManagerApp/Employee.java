package GestioneVendite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Employee {
	
	public void readCustomerList(ArrayList<Customer> customersList) {
		System.out.println("\n\n---Updated customers list---");
		for (Customer c : customersList) {
			System.out.printf("%s\t%s\t%s\t%s\n",c.getName(), c.getSurname(), c.getFiscalCode(), c.getAddress());
		}
	}
	
	public void newCustomer(ArrayList<Customer> customersList) {
		System.out.println("\n\n---Insert new customer---");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Name: ");
		String name = scan.nextLine();
		
		System.out.println("Surname: ");
		String surname = scan.nextLine();
		
		System.out.println("Address: ");
		String address = scan.nextLine();
		
		System.out.println("fiscalCode: ");
		int fiscalCode = scan.nextInt();
		
	
		Customer customer = new Customer(name,surname,fiscalCode,address, null);
		System.out.printf("New customer created:\n%s\t%s\t%s\t%s",customer.getName(), customer.getSurname(), customer.getFiscalCode(), customer.getAddress());
		customersList.add(customer);

	}
	
	public void updateCustomer(ArrayList<Customer> customersList) {
		System.out.println("Digit customer surname:");
		Scanner s = new Scanner(System.in);
		String surname = s.nextLine();
		System.out.println(surname);

		
		for(Customer c: customersList) {
			if(c.getSurname().equals(surname)) {
				System.out.printf("Customer found:\n%s\t%s\t%s\t%s",c.getName(), c.getSurname(), c.getFiscalCode(), c.getAddress());
				System.out.println("\nInsert update command:\n[1] Name\n[2] Surname\n[3] Fiscalcode\n[4] Address");
				Scanner s1 = new Scanner(System.in);
				int command = s1.nextInt();
				switch(command) {
				case 1: 
					System.out.println("Update name: ");
					Scanner scan = new Scanner(System.in);
					String newName = scan.nextLine();
					c.setName(newName);	
					break;
				case 2:
					System.out.println("Update surname: ");
					Scanner scan1 = new Scanner(System.in);
					String newSurname = scan1.nextLine();
					c.setSurname(newSurname);
					break;
				case 3:
					System.out.println("Update Fiscal code: ");
					Scanner scan2 = new Scanner(System.in);
					int newFiscCode = scan2.nextInt();
					c.setFiscalCode(newFiscCode);
					break;
				case 4:
					System.out.println("Update Address: ");
					Scanner scan3 = new Scanner(System.in);
					String newAddress = scan3.nextLine();
					c.setAddress(newAddress);
					break;
				default:
					System.out.println("Command not found");
					
				}
				
			}else {
				System.out.println("Customer not found");
			}
		}
	}
	
	
	public void listPurchases(ArrayList<Customer> customersList) {
		System.out.println("Digit customer surname:");
		Scanner s = new Scanner(System.in);
		String surname = s.nextLine();
		System.out.println(surname);
		
		for(Customer c: customersList) {
			if(c.getSurname().equals(surname)) {
				c.listing(c.getPurchases());
			}
		}
		
	}
	
	public void addPurchase(ArrayList<Customer> customerList) {
		System.out.println("\n\n---Insert new purchase---");
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Product: ");
		String product = scan.nextLine();
		
		System.out.println("Supplier: ");
		String supplier = scan.nextLine();
		
		System.out.println("Purchase date: ");
		String localD = scan.nextLine();
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(localD,dateFormat);

		System.out.println("Price: ");
		double price = scan.nextDouble();
		
		Purchase purchase = new Purchase(product,price,supplier,localDate);
		System.out.printf("New product created:\n%s\t%s\t%s\t%s",purchase.getProduct(),purchase.getPrice(),purchase.getSupplier(),purchase.getPurchaseDate());
		
		System.out.println("Select customer to add purchase\n");
		System.out.println("Digit customer surname:");
		Scanner s = new Scanner(System.in);
		String surname = s.nextLine();
		System.out.println(surname);
		
		for(Customer c: customerList) {
			if(c.getSurname().equals(surname)) {
				c.getPurchases().add(purchase);
			}
		}
		
	}

}
