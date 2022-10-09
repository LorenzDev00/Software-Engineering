package GestioneVendite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Employee {
	
	public static final String ANSI_RED = "\u001B[41m";
	public static final String ANSI_BLUE = "\u001B[44m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	//Command 5 - Read all customers 

	public void readCustomerList(ArrayList<Customer> customersList) {
		System.out.println("NAME\tSURNAME\tFISCALCODE\tBILL\tADDRESS");
		for (Customer c : customersList) {
			System.out.printf("%s\t%s\t%s\t\t%s\t%s\n", c.getName(), c.getSurname(), c.getFiscalCode(), c.getBill(),
					c.getAddress());
		}
	}
	
	// Command 1 - Insert new customer

	public void newCustomer(ArrayList<Customer> customersList) {
		System.out.println("\nInsert new customer");
		Scanner scan = new Scanner(System.in);

		System.out.println("Name: ");
		String name = scan.nextLine();

		System.out.println("Surname: ");
		String surname = scan.nextLine();

		System.out.println("Address: ");
		String address = scan.nextLine();

		System.out.println("Bill: ");
		double bill = scan.nextDouble();

		while (true) {

			// Checking fiscal code length & uniqueness

			System.out.println("fiscalCode [ please insert 5 digists ]: ");
			int fiscalCode = scan.nextInt();

			// Checking length

			if (String.valueOf(fiscalCode).length() < 5) {
				System.out.println(ANSI_BLUE + "Your fiscal code is too short, try again" + ANSI_RESET);
			} else if (String.valueOf(fiscalCode).length() > 5) {
				System.out.println(ANSI_BLUE + "Your fiscal code is too long, try again" + ANSI_RESET);

			} else if (String.valueOf(fiscalCode).length() == 5) {

				// Checking uniqueness

				for (int i = 0; i < customersList.size(); i++) {

					if (customersList.get(i).getFiscalCode() == fiscalCode) {
						System.out.println(ANSI_BLUE + "fiscal code already existing, try again" + ANSI_RESET);
						break;
					} else {
						System.out.println("Your fiscal code is accettable, creating new customer: ");
						Customer customer = new Customer(name, surname, fiscalCode, bill, address, null);
						System.out.printf("\n%s\t%s\t%s\t%s\t%s\n\n", customer.getName(), customer.getSurname(),
								customer.getFiscalCode(), customer.getBill(), customer.getAddress());
						customersList.add(customer);
						return;

					}

				}

			}

		}

	}
	
	// Command 2 - update customer attributes

	public void updateCustomer(ArrayList<Customer> customersList) {
		
		System.out.println("Digit customer fiscal code:");
		Scanner s = new Scanner(System.in);
		int fiscalCode = s.nextInt();
		System.out.println(fiscalCode);

		for (Customer c : customersList) {
			
			// Checking customer existence 
			
			if (c.getFiscalCode() == fiscalCode) {
				System.out.printf("Customer found:\n%s\t%s\t%s\t%s\t%s" , c.getName(), c.getSurname(), c.getFiscalCode(),
						c.getBill(), c.getAddress());
				
				// Asking user the attribute to update 
				
			while(true) {	
				System.out.println("\nInsert update command:\n[1] Name\n[2] Surname\n[3] Fiscalcode\n[4] Address");
				Scanner s1 = new Scanner(System.in);
				int command = s1.nextInt();
				
				
					switch (command) {
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
						System.out.println(ANSI_RED + "Command not found" + ANSI_RESET);
				}

				}

			} else {
				System.out.println(ANSI_RED + "Customer not found" + ANSI_RESET);
			}
		}
	}

	// Command 3 - list customer purchases

	public void listPurchases(ArrayList<Customer> customersList) {
		
		System.out.println("Digit customer fiscal code:");
		Scanner s = new Scanner(System.in);
		int fiscalCode = s.nextInt();
		System.out.println(fiscalCode);

		for (Customer c : customersList) {
			if (c.getFiscalCode() == fiscalCode) {
				c.listing(c.getPurchases());
			}
		}

	}

	// Command 4 - add purchase

	public void addPurchase(ArrayList<Customer> customersList) {

		System.out.println("\nSelect customer to add purchase");
		System.out.println("Digit customer fiscal code:");
		Scanner s = new Scanner(System.in);
		int fiscalCode = s.nextInt();

		// Checking customer with corresponding fiscalCode

		for (Customer c : customersList) {
			if (c.getFiscalCode() == fiscalCode) {

				// Asking user to input product data

				System.out.printf("Customer [ %s %s ], enter new purchase attributes:\n", c.getName(), c.getSurname());
				Scanner scan = new Scanner(System.in);

				System.out.println("Product: ");
				String product = scan.nextLine();

				System.out.println("Supplier: ");
				String supplier = scan.nextLine();

				System.out.println("Purchase date [ yyyy-mm-dd ]: ");
				String localD = scan.nextLine();

				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate localDate = LocalDate.parse(localD, dateFormat);
				
				

				try {

					System.out.println("Price: ");
					double price = scan.nextDouble();
					
					
					while (true) {
						System.out.println("Id:");
						int id = scan.nextInt();
						
						// Checking ID uniqueness 

						for (int i = 0; i < c.getPurchases().size(); i++) {
							if (c.getPurchases().get(i).getId() == id) {
								System.out.println(ANSI_RED +"ID already existing, try again" + ANSI_RESET);
								break;
							} else {
								Purchase purchase = new Purchase(id, product, price, supplier, localDate);
								System.out.printf("New product created:\n%s\t%s\t%s\t%s\t%s\n", purchase.getId(),
										purchase.getProduct(), purchase.getPrice(), purchase.getSupplier(),
										purchase.getPurchaseDate());
								
								// Adding new purchase to customer's purchases list
								
								c.getPurchases().add(purchase);
								
								// Decreasing customer's bill
								
								c.setBill(c.decreaseBill(c, price));
								System.out.println("\npurchase successfully added");
								return;

							}
						}

					}
				} catch (Exception e) {
					System.out.println("Uncorrect Price format: " + e);
				}

			}
		}
	}
}
