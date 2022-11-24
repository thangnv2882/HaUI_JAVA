package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFile {
	
	public static void textOutputFile() throws IOException {
		// Khởi tạo đối tượng file để ghi dữ liệu
		FileWriter outFileWriter = new FileWriter("data.txt");
		// Khởi tạo đối tượng thực thi ghi vào file
		PrintWriter out = new PrintWriter(outFileWriter);
		
		// Xuất dữ liệu ra file
		out.println(12345);
		out.println("Hello World");
		out.println(12345.6789);
		out.println(false);

		out.close(); // Đóng đối tượng thực thi
	}
	
	public static void textInputFile() throws IOException {
		// Khởi tạo đối tượng file để đọc dữ liệu
		FileReader inFileReader = new FileReader("data.txt");
		// Khởi tạo đối tượng thực thi đọc từ file
		BufferedReader in = new BufferedReader(inFileReader);
		
		// Khai báo các biến tương ứng
		String tmpStr;
		int anInt;
		double aDouble;
		boolean aBoolean;
		
		tmpStr = in.readLine();
//		anInt = (new Integer(anInt).intValue());
		anInt = Integer.parseInt(tmpStr);
		System.out.println(anInt);
		
		tmpStr = in.readLine();
		System.out.println(tmpStr);

		tmpStr = in.readLine();
		aDouble = Double.parseDouble(tmpStr);
		System.out.println(aDouble);

		tmpStr = in.readLine();
		System.out.println(tmpStr);

		in.close(); // Đóng đối tượng thực thi
	}
	
	public static void main(String[] args) {
		try {
			textOutputFile();			
			textInputFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
