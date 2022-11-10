package objects;

public class Employee extends Person {

	public static final int NET = 0;
	public static final String POSITION = "NONE";

	public int net;
	public String position;

	public Employee() {
		this(Employee.FIRSTNAME, Employee.LASTNAME, Employee.AGE, Employee.ADDRESS,
				Employee.NET, Employee.POSITION);
		this.net = net;
		this.position = position;
	}

	public Employee(String firstName, String lastName, byte age, Address address, int net, String position) {
		// Khởi tạo đối tượng cha (Person)
		super(firstName, lastName, age, address);

		// Khởi tạp dữ liệu đối tượng con (Student)
		this.net = net;
		this.position = position;
	}

	public int getNet() {
		return net;
	}

	public void setNet(int net) {
		this.net = net;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	

	@Override
	public String toString() {
		return "Employee [" + super.toString() + " - net = " + net + ", position = " + position + "]";
	}

	public static void main(String[] args) {

		// Khởi tạo địa chỉ
		Address addr = new Address();

		// Khởi tạo đối tượng sinh viên
//				Student s = new Student("Thang", "Nguyen Van", (byte)20, addr, 2_020_600_875, "Công nghệ thông tin");
		Employee e = new Employee("Thang", "Nguyen Van", (byte) 20, addr, 100_000_000, "Coder");

		// In thông tin
		System.out.println(e.toString());

	}

}
