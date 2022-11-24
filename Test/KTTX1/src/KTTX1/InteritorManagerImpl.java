package KTTX1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class InteritorManagerImpl implements InteriorManager {

	@Override
	public boolean addInterior(Interior i) {
		if(checkIdExist(i.getProduct_id())) {
			System.out.println("Invalid Product ID");
			return false;
		}
		TestInterior.interiors.add(i);
		System.out.println("Added.");
		return true;
	}

	@Override
	public boolean editInterior(Interior i) {
		for(Interior interior : TestInterior.interiors) {
			if(interior.getProduct_id().compareTo(i.getProduct_id()) == 0) {
				interior.setProduct_name(i.getProduct_name());
				interior.setProduct_price(i.getProduct_price());
				interior.setProduct_total(i.getProduct_total());
				interior.setColor(i.getColor());
				interior.setSize(i.getSize());
				interior.setMaterial(i.getMaterial());
				System.out.println("Edited.");
				return true;
			}
		}
		System.out.println("Interiors with id: " + i.getProduct_id() + " does not exist.");
		return false;
	}

	@Override
	public boolean delInterior(Interior i) {
		for(int index = 0; index < TestInterior.interiors.size(); index++) {
			if(TestInterior.interiors.get(index).getProduct_id().compareTo(i.getProduct_id()) == 0) {
				TestInterior.interiors.remove(index);
				System.out.println("Deleted.");
				return true;
			}
		}
		System.out.println("Interiors with id: " + i.getProduct_id() + " does not exist.");
		return false;
	}
	
	@Override
	public Interior searchInteriorById(String id) {
		for(Interior interior : TestInterior.interiors) {
			if(interior.getProduct_id().compareTo(id) == 0) {
				return interior;
			}
		}
		return null;
	}

	@Override
	public List<Interior> searchInteriorByName(String name) {
		List<Interior> interiorsByName = new ArrayList<>();
		for(Interior interior : TestInterior.interiors) {
			if(interior.getProduct_name().toLowerCase().contains(name.toLowerCase())) {
				interiorsByName.add(interior);
			}
		}
		return interiorsByName;
	}

	@Override
	public List<Interior> searchInteriorByPrice(double price) {
		List<Interior> interiorsByPrice = new ArrayList<>();
		for(Interior interior : TestInterior.interiors) {
			if(interior.getProduct_price() == price) {
				interiorsByPrice.add(interior);
			}
		}
		return interiorsByPrice;
	}
	
	@Override
	public List<Interior> searchInteriorByColor(String color) {
		List<Interior> interiorsByColor = new ArrayList<>();
		for(Interior interior : TestInterior.interiors) {
			if(interior.getColor().toLowerCase().contains(color.toLowerCase())) {
				interiorsByColor.add(interior);
			}
		}
		return interiorsByColor;
	}

	@Override
	public List<Interior> searchInteriorByMaterial(String material) {
		List<Interior> interiorsByMaterial = new ArrayList<>();
		for(Interior interior : TestInterior.interiors) {
			if(interior.getMaterial().toLowerCase().contains(material.toLowerCase())) {
				interiorsByMaterial.add(interior);
			}
		}
		return interiorsByMaterial;
	}

	@Override
	public List<Interior> sortedInteriorByPrice(double price) {
		Scanner sc = new Scanner(System.in);
		List<Interior> interiorsSortedByPrice = new ArrayList<>();
		System.out.println("1. Price min to sort.");
		System.out.println("2. Price max to sort.");
		System.out.print("Your choose: ");
		int choose = Integer.parseInt(sc.nextLine());
		if(choose == 1) {
			for(Interior interior : TestInterior.interiors) {
				if(interior.getProduct_price() >= price) {
					interiorsSortedByPrice.add(interior);
				}
			}
		} else if(choose == 2) {
			for(Interior interior : TestInterior.interiors) {
				if(interior.getProduct_price() <= price) {
					interiorsSortedByPrice.add(interior);
				}
			}
		} else {
			throw new IllegalArgumentException("Unexpected value: " + choose);			
		}
		if(TestInterior.sortType()) {
			Collections.sort(interiorsSortedByPrice, new sortByPrice());			
		} else {
			Collections.sort(interiorsSortedByPrice, new sortByPrice().reversed());	
		}
		return interiorsSortedByPrice;
	}
	
	@Override
	public List<Interior> sortedInteriorById(boolean isINC) {
		if(isINC) {
			TestInterior.interiors.sort((i1, i2) -> (int)(i1.getProduct_id().compareTo(i2.getProduct_id())));			
		} else {
			TestInterior.interiors.sort((i1, i2) -> (int)(i2.getProduct_id().compareTo(i1.getProduct_id())));	
		}
		return TestInterior.interiors;
	}

	@Override
	public List<Interior> sortedInteriorByTotal(boolean isINC) {
		if(isINC) {
			TestInterior.interiors.sort((i1, i2) -> i1.getProduct_total() - i2.getProduct_total());			
		} else {
			TestInterior.interiors.sort((i1, i2) -> i2.getProduct_total() - i1.getProduct_total());			
		}
		return TestInterior.interiors;
	}
	
	public boolean checkIdExist(String product_id) {
		for(Interior interior : TestInterior.interiors) {
			if(interior.getProduct_id().compareTo(product_id) == 0) {
				return true;
			}
		}
		return false;
	}
}

class sortByPrice implements Comparator<Interior> {
	@Override
	public int compare(Interior i1, Interior i2) {
		return (int)(i1.getProduct_price() - i2.getProduct_price());
	}
}
