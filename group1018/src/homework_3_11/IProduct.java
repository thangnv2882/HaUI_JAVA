
/** BTVN 3/11/2022
 * 
 * Xây dựng lớp đối tượng sản phẩm. 
 * Khởi tạo interface để quản lý lớp đối tượng con của sản phẩm. 
 * Yêu cầu sản phẩm có 3 con trở lên: điện thoại, xe máy, tv
 * Sản phẩm có giá thì sắp xếp theo giá, tên ngày sản xuất
 * Xây dựng phương thức tìm kiếm theo nhiều điều kiện khác nhau
 * 
 */

package homework_3_11;

import java.util.List;

public interface IProduct {

	void sortByName(List<Product> products, boolean isINC);
	
	void sortByPrice(List<Product> products, boolean isINC);
	
	Product searchByName(List<Product> products, String name);
	
	List<Product> searchByBranch(List<Product> products, String branch);
	
	List<Product> searchByYearOfManufacture(List<Product> products, int yearOfManufacture);
	
	List<Product> searchByPrice(List<Product> products, Double price);

}
