package homework_3_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductImpl implements IProduct {

	@Override
	public void sortByName(List<Product> products, boolean isINC) {
		if(isINC) {
			Collections.sort(products, new sortByName());
		} else {
			Collections.sort(products, new sortByName().reversed());
		}
	}

	@Override
	public void sortByPrice(List<Product> products, boolean isINC) {
		if(isINC) {
			products.sort((p1, p2) -> (int)(p1.getPrice() - p2.getPrice())) ;
		} else {
			products.sort((p1, p2) -> (int)(p2.getPrice() - p1.getPrice())) ;
		}
	}

	@Override
	public Product searchByName(List<Product> products, String name) {
		for (Product product : products) {
			if (product.getName().contains(name)) {
				return product;
			}
		}
		return null;
	}

	@Override
	public List<Product> searchByBranch(List<Product> products, String branch) {
		List<Product> results = new ArrayList<>();
		for (Product product : products) {
			if (product.getBranch().contains(branch)) {
				results.add(product);
			}
		}
		return results;
	}

	@Override
	public List<Product> searchByYearOfManufacture(List<Product> products, int yearOfManufacture) {
		List<Product> results = new ArrayList<>();
		for (Product product : products) {
			if (product.getYearOfManufacture() == yearOfManufacture) {
				results.add(product);
			}
		}
		return results;
	}

	@Override
	public List<Product> searchByPrice(List<Product> products, Double price) {
		List<Product> results = new ArrayList<>();
		for (Product product : products) {
			if (product.getPrice() == price) {
				results.add(product);
			}
		}
		return results;
	}
}

class sortByName implements Comparator<Product> {
	@Override
	public int compare(Product p1, Product p2) {
		return p1.getName().compareTo(p2.getName());
	}
}
