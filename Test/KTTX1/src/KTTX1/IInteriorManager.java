package KTTX1;
import java.util.List;

public interface IInteriorManager {

	public boolean addInterior(Interior i);
	public boolean editInterior(Interior i);
	public boolean delInterior(Interior i);
	
	public List<Interior> searchInteriorByName(String name);
	public List<Interior> searchInteriorByPrice(double price);
	public List<Interior> searchInteriorByMaterial(String material);
	
	public List<Interior> sortInteriorByPrice();
	public List<Interior> sortInteriorByMaterial();
	
}
