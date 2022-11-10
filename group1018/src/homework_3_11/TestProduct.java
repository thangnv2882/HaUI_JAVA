package homework_3_11;

import java.util.ArrayList;
import java.util.List;

public class TestProduct {
	
	public static void main(String[] args) {
		Product p1 = new Motobike("SH 150i 2022", "SH", 100_000_000.0, 2021, "150cc");
		Product p2 = new Smartphone("IPhone 14 pro max", "Iphone", 35_000_000.0, 2022, 4300);
		Product p3 = new TV("Smart Tivi Samsung 4K Crystal", "Samsung ", 20_000_000.0, 2022, "4K");
		
		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		ProductImpl productImpl = new ProductImpl();
		
		System.out.println("Sort by name: ");
		productImpl.sortByName(products, false);
		System.out.println(products);
		
		System.out.println("Sort by price: ");
		productImpl.sortByPrice(products, false);
		System.out.println(products);
		
		System.out.println("Search product name: ");
		System.out.println(productImpl.searchByName(products, "IPhone 14 pro max"));
		
		System.out.println("Search product name branch: ");
		System.out.println(productImpl.searchByBranch(products, "SH"));
		
		System.out.println("Search product year of manufacture: ");
		System.out.println(productImpl.searchByYearOfManufacture(products, 2022));
		
		System.out.println("Search product Price: ");
		System.out.println(productImpl.searchByPrice(products, 20_000_000.0));
		
	}
	
	
	
}
