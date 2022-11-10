package objects;

public class TestManager {
	public static void main(String[] args) {

		// Khởi tạo địa chỉ
		Address addr = new Address();

		// Khởi tạo đối tượng
		Person s = new Student("Thang", "Nguyen Van", (byte) 20, addr, 2_020_600_875, "Công nghệ thông tin");
		Person e = new Employee("Thang", "Nguyen Van", (byte) 20, addr, 100_000_000, "Coder");

		// -------------------------------------------------
		
		Manager sm = new StudentManager();
		Manager em = new EmployeeManager();
		
		System.out.println(sm.getInfo(s));
		System.out.println(em.getInfo(e));
		
		

	}
}
