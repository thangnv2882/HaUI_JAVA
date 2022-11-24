package KTTX1;
import java.util.List;

public interface InteriorManager {

	public boolean addInterior(Interior i);
	public boolean editInterior(Interior i);
	public boolean delInterior(Interior i);
	
	public Interior searchInteriorById(String id);
	public List<Interior> searchInteriorByName(String name);
	public List<Interior> searchInteriorByPrice(double price);
	public List<Interior> searchInteriorByColor(String color);
	public List<Interior> searchInteriorByMaterial(String material);
	
	public List<Interior> sortedInteriorByPrice(double price);
	public List<Interior> sortedInteriorById(boolean isINC);
	public List<Interior> sortedInteriorByTotal(boolean isINC);
	
}
