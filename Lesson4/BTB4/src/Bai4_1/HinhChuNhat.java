package Bai4_1;

public class HinhChuNhat implements HinhPhang {
	
	private double chieuDai;
	private double chieuRong;
	
	public void Nhap() {
		chieuDai = (Math.random() * 10) + 1;
		chieuRong = (Math.random() * 10) + 1;
	}
	
	public double getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(double chieuDai) {
		this.chieuDai = chieuDai;
	}

	public double getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}

	@Override
	public double ChuVi() {
		return (chieuDai + chieuRong) * 2;
	}

	@Override
	public double DienTich() {
		return chieuDai * chieuRong;
	}

	
	
}
