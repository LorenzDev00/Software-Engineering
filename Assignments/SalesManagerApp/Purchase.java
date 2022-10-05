package GestioneVendite;

import java.time.LocalDate;

public class Purchase {
	private String product;
	private double price;
	private String supplier;
	private LocalDate purchaseDate;
	
	public Purchase(String product, double price, String supplier, LocalDate purchaseDate) {
		super();
		this.product = product;
		this.price = price;
		this.supplier = supplier;
		this.purchaseDate = purchaseDate;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	

}
