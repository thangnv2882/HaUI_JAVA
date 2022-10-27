package Bai4_2;

import java.util.Scanner;

public class KhachHangVN extends KhachHang {
	private String doiTuongKH;
	private int dinhMuc;
	
	public KhachHangVN() {
		super();
	}

	public KhachHangVN(String doiTuongKH, int dinhMuc) {
		super();
		this.doiTuongKH = doiTuongKH;
		this.dinhMuc = dinhMuc;
	}
	
	public void Nhap() {
		super.Nhap();
		Scanner sc = new Scanner(System.in);
		System.out.print("Doi tuong khach hang: ");
		doiTuongKH = sc.nextLine();
		System.out.print("Dinh muc: ");
		dinhMuc = sc.nextInt();
	}
	
	public void Xuat() {
		super.Xuat();
		System.out.println("Doi tuong khach hang: " + doiTuongKH);
		System.out.println("Dinh muc: "+ dinhMuc);
	}

	public String getDoiTuongKH() {
		return doiTuongKH;
	}

	public void setDoiTuongKH(String doiTuongKH) {
		this.doiTuongKH = doiTuongKH;
	}

	public int getDinhMuc() {
		return dinhMuc;
	}

	public void setDinhMuc(int dinhMuc) {
		this.dinhMuc = dinhMuc;
	}
	
	
	
}
