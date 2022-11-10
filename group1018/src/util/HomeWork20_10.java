// Thống kê số lượng ký tự không phân biệt dấu

// Bài 1
// str = "@dbc@@@ghu@@abc@abc@@@ghu@omn@@min"
// dbc - 1, ghu - 2, abc - 2, omn - 1, min - 1

// Bài 2
// Viết tên riêng cho đúng chuẩn: Nguyễn Văn Thắng

// Bài 3: Cho 1 chuỗi ký tự bất kỳ, tìm kiếm và thay thế định dạng của 1 chuỗi con trong chuỗi ban đầu.

// Bài 4: So sánh độ giống nhau của 2 chuỗi ký tự


package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HomeWork20_10 {

	public static void Bai1(String str) {
		if(str.startsWith("@")) {
			str = str.substring(1);
		}
		
		str = str.trim().replaceAll("\\@+", "@");
		String[] arr = str.split("\\@");
		
		Set<String> setStr = new HashSet<>();
		for (String s : arr) {
			setStr.add(s);
		}
		
		for(String set : setStr) {
			int count = 0;
			for(String s : arr) {
				if(set.equals(s)) {
					count++;
				}
			}
			System.out.println(set + ": " + count);
		}
	}
	
	public static String Bai1V2(String str) {
		if(str.startsWith("@")) {
			str = str.substring(1);
		}
		
		str = str.trim().replaceAll("\\@+", "@");
		System.out.println(str);
		String[] arrStr = str.split("\\@");
		
		Map<String, Integer> map = new HashMap<>();
		for(String s : arrStr) {
			if(map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			}
			else {
				map.put(s, 1);
			}
		}
		return map.toString();
	}
	
	public static String Bai2(String str) {
		System.out.println("\nBài 2");
		String name = "";
		
		str = MyStrings.formatString(str);
		String[] arr = str.split("\\s");
		for(String s: arr) {
			name += s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase() + " ";
		}
		
		return name;
	}
	
	public static void Bai3(String src, String str) {
		int l1 = src.length();
		int l2 = str.length();
		System.out.println("\nBài 3: Vị trí tìm thấy:");
		for(int i = 0; i <= l1 - l2; i++) {
			if(src.substring(i, i+l2).contains(str)) {
				System.out.println(i + "->" + (i+l2));
			}
		}
	}
	
	public static double Bai4(String str1, String str2) {

		System.out.print("\nBài 4: Độ giống nhau của 2 chuỗi:");
		
		double samePercent = 0;
		
//		if(str1.length() < str2.length()) {
//			String temp = str1;
//			str1 = str2;
//			str2 = temp;
//		}
		
		int l2 = str2.length();
		  
        ArrayList<String> subStringStr2 = new ArrayList<String>();
  
        for (int i = 0; i < l2; i++) {
            for (int j = i + 1; j <= l2; j++) {
            	subStringStr2.add(str2.substring(i, j));
            }
        }
        
		int maxx = 0;
		for(String s : subStringStr2) {
			if(str1.contains(s)) {
				maxx = Math.max(maxx, s.length());
			}
		}
		
		samePercent = ((double)maxx / str1.length()) * 100;
		return samePercent;
	}

	public static void main(String[] args) {

		// Bài 1
		String str = "@dbc@@@ghu@@abc@abc@@@ghu@omn@@min";
		Bai1(str);
		System.out.println(Bai1V2(str));
		
		// Bài 2
		System.out.println(Bai2(   "nguyễn    vĂN   thắngG"));
		
		// Bài 3
		Bai3("NguyenVanThanVa", "nVa"); 	 	 
		
		// Bài 4
		System.out.println(Bai4("How are you?", "I’m fine") + "%");

	}

}
