package TheTich;

public class Hinh {
	public double h;
	public double r;
	
	public Hinh(double h, double r) {
		super();
		this.h = h;
		this.r = r;
	}
	
	public double tinhTheTichHinhNon() {
		return (1.0/3)* h * Math.PI * r * r ;
	}
	
	public double tinhTheTichHinhTru() {
		return h * Math.PI * r * r ;
	}
}
