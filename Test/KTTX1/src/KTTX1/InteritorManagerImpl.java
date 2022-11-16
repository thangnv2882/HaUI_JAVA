package KTTX1;

import java.util.List;

public class InteritorManagerImpl implements IInteriorManager {

	@Override
	public boolean addInterior(Interior i) {
		if(checkIdExist(i.getProduct_id())) {
			System.out.println("Invalid Product ID");
			return false;
		}
		TestProduct.interiors.add(i);
		return true;
	}

	@Override
	public boolean editInterior(Interior i) {
		if(!checkIdExist(i.getProduct_id())) {
			System.out.println("Not Found");
			return false;
		}
		for(Interior interior : TestProduct.interiors) {
			if(interior.getProduct_id().compareTo(i.getProduct_id()) == 0) {
				interior.setProduct_id(i.getProduct_id());
				interior.setProduct_name(i.getProduct_name());
				interior.setProduct_price(i.getProduct_price());
				interior.setProduct_total(i.getProduct_total());
				interior.setColor(i.getColor());
				interior.setSize(i.getSize());
				interior.setMaterial(i.getMaterial());
			}
		}
		return true;
	}

	@Override
	public boolean delInterior(Interior i) {
		if(!checkIdExist(i.getProduct_id())) {
			System.out.println("Not Found");
			return false;
		}
		
		for(int index = 0; index < TestProduct.interiors.size(); index++) {
			if(TestProduct.interiors.get(index).getProduct_id().compareTo(i.getProduct_id()) == 0) {
				TestProduct.interiors.remove(index);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Interior> searchInteriorByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Interior> searchInteriorByPrice(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Interior> searchInteriorByMaterial(String material) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Interior> sortInteriorByPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Interior> sortInteriorByMaterial() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean checkIdExist(String product_id) {
		for(Interior interior : TestProduct.interiors) {
			if(interior.getProduct_id().compareTo(product_id) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public Interior find(String product_id) {
		for(Interior interior : TestProduct.interiors) {
			if(interior.getProduct_id().compareTo(product_id) == 0) {
				return (interior);
			}
		}
		return null;
	}
	
}
