package GestioneVendite;

import java.util.ArrayList;

public class Customer {
  private String name;
	private String surname;
	private int fiscalCode;
	private String address;
	private ArrayList<Purchase> purchases; 
  
  public Customer(String name, String surname, int fiscalCode, String address, ArrayList<Purchase> purchases) {
		super();
		this.name = name;
		this.surname = surname;
		this.fiscalCode = fiscalCode;
		this.address = address;
		this.purchases = purchases;
	}
  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getFiscalCode() {
		return fiscalCode;
	}
	public void setFiscalCode(int fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}
	public void setPurchases(ArrayList<Purchase> purchases) {
		this.purchases = purchases;
	}
  
  public void listing(ArrayList<Purchase> purchasesList) {
		System.out.println("Customer purchases:");
		for(Purchase p: purchasesList) {
			System.out.printf("%s\t%s\t%s\t%s\n",p.getProduct(), p.getSupplier(), p.getPrice(), p.getPurchaseDate());
		}		
	}
}

