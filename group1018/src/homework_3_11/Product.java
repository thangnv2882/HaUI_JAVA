package homework_3_11;

public class Product {
	
	protected String name;
	protected String branch;
	protected double price;
	protected int yearOfManufacture;
	
	public Product() {
		super();
	}

	public Product(String name, String branch, double price, int yearOfManufacture) {
		super();
		this.name = name;
		this.branch = branch;
		this.price = price;
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", branch=" + branch + ", price=" + price + ", yearOfManufacture="
				+ yearOfManufacture + "]";
	}

	
	

}
