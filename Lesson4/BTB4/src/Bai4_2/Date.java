package Bai4_2;

import java.util.Scanner;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {
		super();
	}

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ngay: ");
		day = sc.nextInt();
		System.out.print("Thang: ");
		month = sc.nextInt();
		System.out.print("Nam: ");
		year = sc.nextInt();
	}
	
	public String Xuat() {
		return day + "/" + month + "/" + year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}	
