package homework_17_11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SinhVien {

	static int count = 0;
	private int id;
	private String fullName;
	private int age;
	
	public SinhVien() {
		count++;
		this.id = count;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static List<SinhVien> generateSinhVien(int n) {
		List<SinhVien> list = new ArrayList<>();

//		Danh sách tên
		String[] firstNames = { "Anh", "Anh Tuấn", "Tuấn Anh", "Minh Anh", "Bảo", "Vân", "Hùng", "Chiến", "Châu",
				"Châu Anh", "Minh Châu", "Linh", "Thuỷ", "Hồng", "Việt", "Nam", "Khải", "Huyền Anh", "Huy Anh", "Hưng",
				"Trang", "Yến", "Yến Anh" };

//		Danh sách họ
		String[] lastNames = { "Hoàng", "Nguyễn", "Lê", "Phan", "Phạm", "Vũ", "Đào", "Đoàn", "Lương", "Ngô",
				"Ma", "Trần", "Vũ", "Bùi", "Quách", "Hồ"};

//		Thực hiện sinh ngẫu nhiên danh sách
		int index;
		
		for (int i = 0; i < n; i++) {

			SinhVien sinhVien = new SinhVien();
			index = (int) (Math.random() * lastNames.length);
			sinhVien.setFullName(lastNames[index] + " " + firstNames[index]);
			index = (int) (Math.random() * 8);
			sinhVien.setAge((18 + (int)(Math.random() * 6)));

			list.add(sinhVien);
		}
		return list;
	}
}


