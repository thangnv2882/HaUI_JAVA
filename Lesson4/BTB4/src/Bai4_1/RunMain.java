package Bai4_1;

public class RunMain {
	
	public static void main(String[] args) {
		HinhVuong hv = new HinhVuong();
		hv.Nhap();
		System.out.println("Hinh vuông có canh la: " + hv.getCanh());
		System.out.println("Chu vi hinh vuong la: " + hv.ChuVi());
		System.out.println("Dien tich hinh vuong la: " + hv.DienTich());
		

		HinhChuNhat hcn = new HinhChuNhat();
		hcn.Nhap();
		System.out.println("Chiều dài hcn là: " + hcn.getChieuDai());
		System.out.println("Chiều rộng hcn là: " + hcn.getChieuRong());
		System.out.println("Chu vi hcn la: " + hcn.ChuVi());
		System.out.println("Dien tich hcn la: " + hcn.DienTich());
	}
	
}
