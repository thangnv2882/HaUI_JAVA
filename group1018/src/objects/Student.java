package objects;

public class Student extends Person {

	// Constants
	public static final int ID = 0;
	public static final String SPECIALY = "NONE";
	
	// Student's properties
	private int id;
	private String specialy;
	
	// Constructor methods
	public Student() {
		this(Student.FIRSTNAME, Student.LASTNAME, Student.AGE, Student.ADDRESS
				, Student.ID, Student.SPECIALY);
	}

	public Student(String firstName, String lastName, byte age, Address address, int id, String specialy) {
		// Khởi tạo đối tượng cha (Person)
		super(firstName, lastName, age, address);
		
		// Khởi tạp dữ liệu đối tượng con (Student)
		this.id = id;
		this.specialy = specialy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecialy() {
		return specialy;
	}

	public void setSpecialy(String specialy) {
		this.specialy = specialy;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + " - id = " + id + ", - specialy = " + specialy + "]";
	}
	
	
	public static void main(String[] args) {
		// Khởi tạo địa chỉ
		Address addr = new Address();
		
		// Khởi tạo đối tượng sinh viên
//		Student s = new Student("Thang", "Nguyen Van", (byte)20, addr, 2_020_600_875, "Công nghệ thông tin");
		Person s = new Student("Thang", "Nguyen Van", (byte)20, addr, 2_020_600_875, "Công nghệ thông tin");
		
		// In thông tin
		System.out.println(s.toString());
		

		
	}
	
	
	
	
	
}
