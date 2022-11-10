package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import objects.*;

public class MyArrays {

	/**
	 * Phương thức này sinh ngẫu nhiên <b>n</b> giá trị của mảng 1 chiều
	 * 
	 * @param n
	 * @return int[]
	 */
	public static int[] generateArray(int n) {
		int[] arrInt = new int[n];

		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = (int) (Math.random() * 100);
		}

		return arrInt;
	}

	public static int[][] generateArray(int rows, int cols) {
		int[][] arrInt = new int[rows][cols];

		for (int i = 0; i < arrInt.length; i++) {
			arrInt[i] = MyArrays.generateArray(cols);
		}

		return arrInt;
	}

	public static Person[] generatePerson(int n) {
		Person[] list = new Person[n];

//		Danh sách tên
		String[] firstNames = { "Anh", "Anh Tuấn", "Tuấn Anh", "Minh Anh", "Bảo", "Vân", "Hùng", "Chiến", "Châu",
				"Châu Anh", "Minh Châu", "Linh", "Thuỷ", "Hồng", "Việt", "Nam", "Khải", "Huyền Anh", "Huy Anh", "Hưng",
				"Trang", "Yến", "Yến Anh" };

//		Danh sách họ
		String[] lastNames = { "Hoàng", "Nguyễn", "Lê", "Phan", "Phạm", "Vũ", "Đào", "Đoàn", "Lương", "Ngô",
				"Ma", "Trần", "Vũ", "Bùi", "Quách", "Hồ"};

//		Thực hiện sinh ngẫu nhiên danh sách
		int index;
		
//		Phần tử mảng lưu trữ địa chỉ của đối tượng, không lữu trữ giá trị
		for (int i = 0; i < n; i++) {
//			Khởi tạo bộ nhớ cho phần tử mảng
			list[i] = new Person();

//			Sinh tên
			index = (int) (Math.random() * firstNames.length);
			list[i].setFirstName(firstNames[index]);

//			Sinh họ
			index = (int) (Math.random() * lastNames.length);
			list[i].setLastName(lastNames[index]);

//			Sinh tuổi
			index = 18 + (int) (Math.random() * 5);
			list[i].setAge((byte) index);
		}

		return list;
	}
	
	public static Person[] searchByName(Person[] list, String name) {
		
//		Đếm số kết quả
		int count = 0;
		for(Person p : list) {
			if(p.getFirstName().contains(name)) {
				count++;
			}
		}
		
		Person[] results = new Person[count];
		
//		Ghi nhận kết quả
		count = 0;
		for(Person p : list) {
			if(p.getFirstName().contains(name)) {
				results[count++] = p;
			}
		}
		
		return results;
	}
	
	public static ArrayList<Person> searchByNameV2(Person[] list, String name) {
//		Mảng kết quả
		ArrayList<Person> results = new ArrayList<>();
		
		for(Person p : list) {
			if(p.getFirstName().contains(name)) {
				results.add(p);
			}
		}
		
		return results;
	}
	
	public static void printPerson(Person[] list) {
		for(Person p : list) {
			System.out.println(p);
		}
	}
	public static void printPerson(ArrayList<Person> list) {

		list.forEach(p -> System.out.println(p));
	}
	

	public static int[] sortArray(int[] arrInt, boolean isINC) {

//		Xác định hướng sắp xếp
		byte oriented = (byte) (isINC ? 1 : -1);

		for (int i = 0; i < arrInt.length - 1; i++) {
			for (int j = i + 1; j < arrInt.length; j++) {
				if (arrInt[i] * oriented > arrInt[j] * oriented) {
					int temp = arrInt[i];
					arrInt[i] = arrInt[j];
					arrInt[j] = temp;
				}
			}
		}

		return arrInt;
	}

	public static int[][] sortArray(int[][] arrInt, boolean isINC) {

//		Chuyển về mảng 1 chiều
		int rows = arrInt.length;
		int cols = arrInt[0].length;

		int[] temp = new int[rows * cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				temp[i * cols + j] = arrInt[i][j];
			}
		}

//		Sắp xếp 
		temp = MyArrays.sortArray(temp, isINC);

//		Chuyển về 2 chiều
		int row = 0, col = 0;
		for (int i = 0; i < temp.length; i++) {
			arrInt[row][col++] = temp[i];

			if (i > 0 && (i + 1) % cols == 0) {
				row++;
				col = 0;
			}
		}

		return arrInt;
	}

	public static int[] filterPrime(int[] arrInt, boolean isINC) {

//		Sap xep
		arrInt = MyArrays.sortArray(arrInt, isINC);

//		Tách nguyên tố, không nguyên tố
		int[] temp1 = new int[arrInt.length];
		int[] temp2 = new int[arrInt.length];

		int t1 = 0, t2 = 0;
		for (int value : arrInt) {
			if (exams.Example2.isPrime(value)) {
				temp1[t1] = value;
				t1++;
			} else {
				temp2[t2] = value;
				t2++;
			}
		}

//		Ghép lại
		for (int i = t1; i < arrInt.length; i++) {
			temp1[i] = temp2[i - t1];
		}

		return arrInt;
	}
	
	public static ArrayList<Person> sortedByAge(Person[] list, boolean isINC) {
		// Tạo tập hợp trung gian
		ArrayList<Person> tmp = new ArrayList<>();
		
		// Sao chép mảng sang tập hợp
		Collections.addAll(tmp, list);
		
		// Sắp xếp
		if(isINC) {
			Collections.sort(tmp);
//			tmp.sort((p1, p2) -> p1.getAge() - p2.getAge());
		}
		else {
			Collections.sort(tmp, Collections.reverseOrder());
//			tmp.sort((p1, p2) -> p2.getAge() - p1.getAge());
		}

		
		// Trả về kết quả
		return tmp;
		
	}
	
	public static ArrayList<Person> sortedByName(Person[] list, boolean isINC) {
		// Tạo tập hợp trung gian
		ArrayList<Person> tmp = new ArrayList<>();
		
		// Sao chép mảng sang tập hợp
		Collections.addAll(tmp, list);
		
		// Sắp xếp
		if(isINC) {
			Collections.sort(tmp, new sortByName());
//			tmp.sort((p1, p2) -> p1.getFirstName().compareToIgnoreCase(p2.getFirstName()));
		}
		else {
			Collections.sort(tmp, new sortByName().reversed());
//			tmp.sort((p1, p2) -> p2.getFirstName().compareToIgnoreCase(p1.getFirstName()));
		}

		// Trả về kết quả
		return tmp;
		
	}
	

	public static void printArray(int[] arrInt) {
		for (int value : arrInt) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	public static void printArray(int[][] arrInt) {
		for (int[] row : arrInt) {
			MyArrays.printArray(row);
		}
	}

	public static void main(String[] args) {
////		Sinh mảng 1 chiều
//		System.out.println("Mảng 1 chiều");
//		int[] arrInt = generateArray(10);
//
////		In mảng
//		printArray(arrInt);
//
////		Tăng dần
//		sortArray(arrInt, true);
//		printArray(arrInt);
//
////		Giảm dần
//		sortArray(arrInt, false);
//		printArray(arrInt);
//
////		Nguyên tố
//		filterPrime(arrInt, true);
//		printArray(arrInt);
//
////		Sinh mảng 2 chiều
//		System.out.println("Mảng 2 chiều");
//		int[][] arrInt2D = generateArray(3, 5);
//
////		In mảng
//		printArray(arrInt2D);
//
////		Tăng dần
//		System.out.println("Sắp xếp mảng 2 chiều");
//		sortArray(arrInt2D, true);
//		printArray(arrInt2D);
		
		Person[] list = generatePerson(5);
		printPerson(list);
		
		System.out.println("\nTìm theo tên");
		Person[] results = searchByName(list, "Anh");
		printPerson(results);

		System.out.println("\nTìm theo tên v2");
		ArrayList<Person> resultsV2 = searchByNameV2(list, "Anh");
		printPerson(resultsV2);

		System.out.println("\nSắp xếp theo tuổi");
		ArrayList<Person> resultSortAge = sortedByAge(list, true);
		printPerson(resultSortAge);
		
		System.out.println("\nSắp xếp theo tên");
		ArrayList<Person> resultSortName = sortedByName(list, true);
		printPerson(resultSortName);
		

	}
	
}

class sortByName implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		String name1 = o1.getFirstName();
		String name2 = o2.getFirstName();
		
		// Biến xác nhận vị trí cần cắt tên sau cùng
		byte at = (byte)name1.lastIndexOf(" ");
		if(at != -1) {
			name1 = name1.substring(at+1);
		}
		at = (byte)name2.lastIndexOf(" ");
		if(at != -1) {
			name2 = name2.substring(at+1);
		}

		return name1.compareToIgnoreCase(name2);
	}
	
}
