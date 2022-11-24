//Viết chương trình tạo file DANHSACH.txt với những nội dung sau:
//Dòng:
//1. DANHSACHLOP
//2. | STT | HO TEN
//3. Hiển thị STT (tự động tăng) và họ tên 
//Cuối: TONGSO = ?(Sinh viên)
//
//Random khoảng 70 sinh viên
//
//Viết chương trình đọc lại file trên và hiển thị lên màn hình
//Sắp xếp tên, tuổi -> file khác

package homework_17_11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyFile {
	

	static List<SinhVien> sinhViens = SinhVien.generateSinhVien(70);
	
	public static void WriteToFile() {
		try {
			String path = System.getProperty("user.dir");
			// Khởi tạo đối tượng file để ghi dữ liệu
			FileWriter outFileWriter = new FileWriter(path + "\\src\\homework_17_11\\dataSV.txt");
			// Khởi tạo đối tượng thực thi ghi vào file
			PrintWriter out = new PrintWriter(outFileWriter);
			// Xuất dữ liệu ra file
			out.printf("%1s %-10s %1s %-30s %1s %-10s %-1s", "|", "STT", "|", "HO TEN", "|", "Tuoi", "|");
			out.println();
			for (SinhVien s : sinhViens) {
				out.printf("%1s %-10s %1s %-30s %1s %-10s %-1s", "|", s.getId(), "|", s.getFullName(), "|", s.getAge(), "|");
				out.println();
			}
			out.println("TONGSO: " + sinhViens.size() + " (Sinh viên)");

			out.close(); // Đóng đối tượng thực thi
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void ReadFromFile() throws IOException {
		String path = System.getProperty("user.dir");
		// Khởi tạo đối tượng file để đọc dữ liệu
		FileReader inFileReader = new FileReader(path + "\\src\\homework_17_11\\dataSV.txt");
		// Khởi tạo đối tượng thực thi đọc từ file
		BufferedReader in = new BufferedReader(inFileReader);
		String str = in.readLine();
		do {
			System.out.println(str);
		} while((str = in.readLine()) != null);

		in.close(); // Đóng đối tượng thực thi
	}
	
	public static void WriteToFileSortName() throws IOException {
		String path = System.getProperty("user.dir");

		// Khởi tạo đối tượng file để ghi dữ liệu
		FileWriter outFileWriter = new FileWriter(path + "\\src\\homework_17_11\\dataSVSortName.txt");
		// Khởi tạo đối tượng thực thi ghi vào file
		PrintWriter out = new PrintWriter(outFileWriter);
		
		Collections.sort(sinhViens, new sortByName());
		
//		// Xuất dữ liệu ra file
		out.printf("%1s %-10s %1s %-30s %1s %-10s %-1s", "|", "STT", "|", "HO TEN", "|", "Tuoi", "|");
		out.println();
		for (SinhVien s : sinhViens) {
			out.printf("%1s %-10s %1s %-30s %1s %-10s %-1s", "|", s.getId(), "|", s.getFullName(), "|", s.getAge(), "|");
			out.println();
		}
		out.println("TONGSO: " + sinhViens.size() + " (Sinh viên)");

		out.close(); // Đóng đối tượng thực thi
	}
	
	public static void WriteToFileSortAge() throws IOException {
		String path = System.getProperty("user.dir");

		// Khởi tạo đối tượng file để ghi dữ liệu
		FileWriter outFileWriter = new FileWriter(path + "\\src\\homework_17_11\\dataSVSortAge.txt");
		// Khởi tạo đối tượng thực thi ghi vào file
		PrintWriter out = new PrintWriter(outFileWriter);
		
		Collections.sort(sinhViens, new sortByAge());
		
//		// Xuất dữ liệu ra file
		out.printf("%1s %-10s %1s %-30s %1s %-10s %-1s", "|", "STT", "|", "HO TEN", "|", "Tuoi", "|");
		out.println();
		for (SinhVien s : sinhViens) {
			out.printf("%1s %-10s %1s %-30s %1s %-10s %-1s", "|", s.getId(), "|", s.getFullName(), "|", s.getAge(), "|");
			out.println();
		}
		out.println("TONGSO: " + sinhViens.size() + " (Sinh viên)");

		out.close(); // Đóng đối tượng thực thi
	}
	

	public static void main(String[] args) {
		try {
			WriteToFile();
			ReadFromFile();
			WriteToFileSortName();
			WriteToFileSortAge();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class sortByName implements Comparator<SinhVien> {
	@Override
	public int compare(SinhVien s1, SinhVien s2) {
		return s1.getFullName().compareTo(s2.getFullName());
	}
}

class sortByAge implements Comparator<SinhVien> {
	@Override
	public int compare(SinhVien s1, SinhVien s2) {
		return s1.getAge() - s2.getAge();
	}
}

