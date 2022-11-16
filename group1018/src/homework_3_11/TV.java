package homework_3_11;

public class TV extends Product {
	
	private String resolution;

	public TV() {
		super();
	}

	public TV(String name, String branch, double price, int yearOfManufacture, String resolution) {
		super(name, branch, price, yearOfManufacture);
		this.resolution = resolution;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	@Override
	public String toString() {
		return "TV [resolution=" + resolution + ", name=" + name + ", branch=" + branch + ", price=" + price
				+ ", yearOfManufacture=" + yearOfManufacture + "]";
	}
	
	
	
	
	

}
