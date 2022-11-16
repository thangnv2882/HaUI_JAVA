package homework_3_11;

public class Motobike extends Product {
	private String engine;

	public Motobike() {
		super();
	}

	public Motobike(String name, String branch, double price, int yearOfManufacture, String engine) {
		super(name, branch, price, yearOfManufacture);
		this.engine = engine;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Motobike [engine=" + engine + ", name=" + name + ", branch=" + branch + ", price=" + price
				+ ", yearOfManufacture=" + yearOfManufacture + "]";
	}
	
	
	
}
