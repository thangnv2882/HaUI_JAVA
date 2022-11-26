package io;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import objects.Person;
import util.MyArrays;

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

	public static void binaryOutputFile(short n) throws IOException {
		// Xác định đối tượng tệp tin để xuất dữ liệu
		FileOutputStream outFile = new FileOutputStream("abc.bin");
		// Khai báo đối tượng thực hiện xuất
		ObjectOutputStream out = new ObjectOutputStream(outFile);

		// Sinh ngẫu nhiên 1 danh sách
		Person[] list = MyArrays.generatePerson(n);

		// Xuất dữ liệu ra file
		for (int i = 0; i < n; i++) {
			out.writeInt(i + 1);
			out.writeObject(list[i]);
		}

		out.close(); // Đóng đối tượng thực thi
	}

	public static void binaryInputFile(String name, short n, long pos) throws IOException, ClassNotFoundException {
		// Xác định đối tượng tệp tin để xuất dữ liệu
		FileInputStream inFile = new FileInputStream(name);
		// Khai báo đối tượng thực hiện xuất
		ObjectInputStream in = new ObjectInputStream(inFile);

		for (int i = 0; i < n; i++) {
			System.out.printf("%-5d", in.readInt());
			System.out.println((Person) in.readObject());
		}
		
		// Đọc phần đã sắp xếp
		RandomAccessFile raf = new RandomAccessFile("abc.bin", "rw");
	
		// Di chuyển đến vị trí để đọc
		raf.seek(pos);
		for(int i = 0; i < n; i++) {
//			System.out.printf("%-5d", raf.readInt());
			System.out.println(raf.readUTF());
		}
		
		in.close();
	}

	public static long binaryOutputSortAgeFile(short n) throws IOException, ClassNotFoundException {

		// Xác định đối tượng tệp tin để xuất dữ liệu
		FileInputStream inFile = new FileInputStream("abc.bin");
		// Khai báo đối tượng thực hiện xuất
		ObjectInputStream in = new ObjectInputStream(inFile);
		
		List<Person> persons = new ArrayList<>();
		Person person = new Person();
		for (int i = 0; i < n; i++) {
			in.readInt();
			person = (Person) in.readObject();
			persons.add(person);
		}
		in.close();

		Collections.sort(persons, new sortByAge());

		// Xác định đối tượng tệp tin để cập nhật dữ liệu ngẫu nhiên
		RandomAccessFile raf = new RandomAccessFile("abc.bin", "rw");
		
		// Di chuyển xuống cuối file để thêm 
		raf.seek(raf.length());
		
		long pos = raf.length();
		
		// Xuất dữ liệu ra file
//		for (int i = 0; i < n; i++) {
//			raf.writeInt(i + 1);
//			raf.writeUTF(persons.get(i).toString());
//		}
		
		persons.forEach(item -> {
			try {
				raf.writeUTF(item.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		

		raf.close(); // Đóng đối tượng thực thi
		return pos;
	}
	
//	public static void binaryInputFileSortAge(short n) throws IOException, ClassNotFoundException {
//		// Xác định đối tượng tệp tin để xuất dữ liệu
//		FileInputStream inFile = new FileInputStream("abcSortAge.bin");
//		// Khai báo đối tượng thực hiện xuất
//		ObjectInputStream in = new ObjectInputStream(inFile);
//
//		for (int i = 0; i < n; i++) {
//			System.out.printf("%-5d", in.readInt());
//			System.out.println((Person) in.readObject());
//		}
//		in.close();
//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		short n;
		System.out.print("Input n: ");
		n = sc.nextShort();
		try {
//			textOutputFile();			
//			textInputFile();
			binaryOutputFile(n);
			binaryInputFile("abc.bin", n, MyFile.binaryOutputSortAgeFile(n));
			
//			binaryOutputSortAgeFile(n);
//			binaryInputFile("abc.bin", n, MyFile.binaryOutputSortAgeFile(n));

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class sortByAge implements Comparator<Person> {
	@Override
	public int compare(Person p1, Person p2) {
		return p1.getAge() - p2.getAge();
	}
}
