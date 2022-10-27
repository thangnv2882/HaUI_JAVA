package Bai4_2;

import java.util.Scanner;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private Date ngayRaHoaDon = new Date();
	private int soLuong;
	private double donGia;
	
	public KhachHang() {
		super();
	}

	public KhachHang(String maKH, String tenKH, Date ngayRaHoaDon, int soLuong, double donGia) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.ngayRaHoaDon = ngayRaHoaDon;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ma khach hang: ");
		maKH = sc.nextLine();
		
		System.out.print("Ten khach hang: ");
		tenKH = sc.nextLine();
		
		System.out.println("Ngay ra hoa don: ");
		ngayRaHoaDon.Nhap();
		
		System.out.print("So luong: ");
		soLuong = sc.nextInt();
		
		System.out.print("Don gia: ");
		donGia = sc.nextDouble();
	}
	
	public void Xuat() {
		System.out.println("Ma khach hang: " + maKH);
		System.out.println("Ten khach hang: " + tenKH);
		System.out.println("Ngay ra hoa don: " + ngayRaHoaDon.Xuat());
		System.out.println("So luong: " + soLuong);
		System.out.println("Don gia: " + donGia);
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public Date getNgayRaHoaDon() {
		return ngayRaHoaDon;
	}

	public void setNgayRaHoaDon(Date ngayRaHoaDon) {
		this.ngayRaHoaDon = ngayRaHoaDon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
}
