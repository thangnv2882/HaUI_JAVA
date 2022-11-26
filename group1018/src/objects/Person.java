package objects;

import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {

//	Constants
	public static final String FIRSTNAME = "No firstName";
	public static final String LASTNAME = "No lastName";
	public static final byte AGE = 0;
	public static final Address ADDRESS = new Address();

//	classes variables
	private static int count = 0;

//	Object's properties
	private String firstName;
	private String lastName;
	private byte age;

	private Address address;

//	Construstor methods
	public Person() {
		this(Person.FIRSTNAME, Person.LASTNAME, Person.AGE, Person.ADDRESS);
	}

	public Person(byte age) {
		this(Person.FIRSTNAME, Person.LASTNAME, age, Person.ADDRESS);
	}

	public Person(String firstName, String lastName, byte age, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;

//		Cách 1 - Gán địa chỉ trong bộ nhớ 
//		this.address = address;

//		Cách 2 - Khởi tạo bộ nhớ mới và sao chép giá trị;
		this.address = new Address(address);

//		variable's increase
		Person.count++;
	}

//	Other methods

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return String.format("%-12s %-12s %-5d", firstName, firstName, age);
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setAddress(String cityName, String districtName, String streetName) {
		this.address = new Address(cityName, districtName, streetName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte getAge() {
		return age;

	}

	public void setAge(byte age) {
		this.age = age;
	}

	public static int getCountPerson() {
		return Person.count;
	}

	public static void main(String[] args) {

		Address addr = new Address("Hà Nội", "Đan Phượng", "Tân Hội");

//		Khai báo và khởi tạo đối tượng
		Person p;
		Person p1 = new Person();
		Person p2 = new Person((byte) 18);
		Person p3 = new Person("Nguyễn Văn", "Thắng", (byte) 20, addr);

		addr.setStreetName("Vĩnh Kỳ");

//		System.out.println(p1);
//		System.out.println(p2);
		System.out.println(p3);

		System.out.println("Số thể hiện đối tượng được tạo ra là: " + Person.getCountPerson());

//		String s = "a";
//		String s1 = new String("a");
//		
//		System.out.println(s == s1);

	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.age - o.getAge();
	}

}
