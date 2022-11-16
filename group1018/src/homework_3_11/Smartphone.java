package homework_3_11;

public class Smartphone extends Product {
	
	private int batteryCapacities;

	public Smartphone() {
		super();
	}

	public Smartphone(String name, String branch, double price, int yearOfManufacture, int batteryCapacities) {
		super(name, branch, price, yearOfManufacture);
		this.batteryCapacities = batteryCapacities;
	}

	public int getBatteryCapacities() {
		return batteryCapacities;
	}

	public void setBatteryCapacities(int batteryCapacities) {
		this.batteryCapacities = batteryCapacities;
	}

	@Override
	public String toString() {
		return "Smartphone [batteryCapacities=" + batteryCapacities + ", name=" + name + ", branch=" + branch
				+ ", price=" + price + ", yearOfManufacture=" + yearOfManufacture + "]";
	}
	
	
	
}
