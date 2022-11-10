package objects;

public class TestPerson {
	public static void main(String[] args) {
		
		// Khởi tạo địa chỉ
		Address addr = new Address();

		// Khởi tạo đối tượng
		Person s = new Student("Thang", "Nguyen Van", (byte) 20, addr, 2_020_600_875, "Công nghệ thông tin");
		Person e = new Employee("Thang", "Nguyen Van", (byte) 20, addr, 100_000_000, "Coder");
		// In thông tin

		System.out.println(s.toString());
		System.out.println(e.toString());
		
	}
}
