package Bai4_1;

public class HinhVuong implements HinhPhang {
	
	private double canh;
	
	public void Nhap() {
		canh = (Math.random() * 10) + 1;
	}
	

	public double getCanh() {
		return canh;
	}


	public void setCanh(double canh) {
		this.canh = canh;
	}


	@Override
	public double ChuVi() {
		return canh*4;
	}

	@Override
	public double DienTich() {
		return canh*canh;
	}

	
	
}
