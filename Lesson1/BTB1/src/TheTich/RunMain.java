package TheTich;

public class RunMain {
	public static void main(String[] args) {
		double h = Math.random() * 10;
		double r = Math.random() * 10;
		Hinh hinh = new Hinh(h, r);
		System.out.println("Chiều cao: " + h);
		System.out.println("Bán kính: " + r);
		
		System.out.println("Thể tích hình nón là: " + hinh.tinhTheTichHinhNon());
		System.out.println("Thể tích hình nón là: " + hinh.tinhTheTichHinhTru());
	}
	
	
}
