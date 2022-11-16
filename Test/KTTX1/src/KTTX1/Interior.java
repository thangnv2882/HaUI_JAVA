package KTTX1;

import java.util.List;
import java.util.Scanner;

public class Interior extends Product {
	
	private String color;
	private String size;
	private String material;
	
	
	public Interior() {
		super();
	}


	public Interior(String product_id, String product_name, double product_price, int product_total, String color, String size, String material) {
		super(product_id, product_name, product_price, product_total);
		this.color = color;
		this.size = size;
		this.material = material;
	}
	
	public void Input() {
		super.Input();
		Scanner sc = new Scanner(System.in);
		System.out.print("Input color: ");
		color = sc.nextLine();
		System.out.print("Input size: ");
		size = sc.nextLine();
		System.out.print("Input material: ");
		material = sc.nextLine();
	}
	
	public void Output() {
		super.Output();
        System.out.printf("%-15s %-10s %-15s", color, size, material);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	@Override
	public String toString() {
		return "Interior [id=" + getProduct_id() 
				+ ", name=" + getProduct_name() 
				+ ", price=" + getProduct_price() 
				+ ", total=" + getProduct_total() 
				+ ", color=" + color + ", size=" + size 
				+ ", material=" + material + "]";
	}
	
	
	
	
	
	
	
	
}
