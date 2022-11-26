package objects;

import java.io.Serializable;

public class Address implements Serializable {
	

//	Constants
	public static final String CITYNAME = "No cityName";
	public static final String DISTRICTNAME = "No districtName";
	public static final String STREETNAME = "No streetName";

//	Object's properties
	private String cityName;
	private String districtName;
	private String streetName;
		
	public Address() {
		this(Address.CITYNAME, Address.DISTRICTNAME, Address.STREETNAME);
	}

	public Address(String cityName, String districtName, String streetName) {
		super();
		this.cityName = cityName;
		this.districtName = districtName;
		this.streetName = streetName;
	}
	
	public Address(Address addr) {
		this(addr.getCityName(), addr.districtName, addr.streetName);
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@Override
	public String toString() {
		return "Address [cityName=" + cityName + ", districtName=" + districtName + ", streetName=" + streetName + "]";
	}

	public static void main(String[] args) {
		
//		Khai báo và khởi tạo đối tượng
		Address p = new Address("Hà Nội", "Đan Phượng", "Tân Hội");
		
		System.out.println(p);
		
	}
	
}
