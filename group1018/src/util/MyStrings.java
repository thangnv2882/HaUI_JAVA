package util;
import java.util.*;

public class MyStrings {

	/**
	 * This method is used to count a char number in string
	 * 
	 * @param str
	 * @param ch
	 * @return
	 */
	public static int countChar(String str, char ch, boolean isIgnoreCase) {
		int count = 0;
		
		// Nếu bỏ qua kiểu chữ HOA - thường
		if(isIgnoreCase) {
			str = str.toLowerCase();
			ch = Character.toLowerCase(ch);
		}
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}

		return count;
	}
	
	public static String formatString(String str) {
		// Danh sách các ký tự đặc biệt
		char[] chs = {
				'`', '!', '@', '#', '$', '%', '^', '&',
				'*', '(', ')', '-', '_', '=', '+', '<',
				',', '>', '.', '/', '?', ';', ':', '"',
				'{', '[', '}', ']', '\\', '|', '\'', '0'
				, '1', '2', '3', '4', '5', '6', '7', '8', '9'
		};
		
		for (char ch: chs) {
			str = str.replace(ch, ' ');
		}
		
		// Loại dấu cách thừa
		str = str.trim();
//		while (str.indexOf("  ") != -1) {
//			str = str.replace("  ", " ");
//		}
		str = str.replaceAll("\\s+", " ");
		
		// Chuẩn hoá đánh dấu câu
		str = str.replace(" . ", ". ");
		str = str.replace(" , ", ", ");
		
		// Trả về kết quả
		return str;
	}
	
	public static int countWords(String str) {
		// Chuẩn hoá
		str = MyStrings.formatString(str);
		
//		String[] arr = str.trim().split(" ");
//		return arr.length;
		return MyStrings.countChar(str, ' ', false) + 1;
	}
	
	public static void frequencyChar(String str, boolean isIgnoreCase) {
		Map<Character, Integer> map = new HashMap<>();
		
		if(isIgnoreCase) {
			str = str.toLowerCase();
		}
		
		for(int i = 0; i< str.length(); i++) {
			if(map.containsKey(str.charAt(i))) {
				map.replace(str.charAt(i), map.get(str.charAt(i))+1);
			}
			else {
				map.put(str.charAt(i), 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}	
	}
	
	public static ArrayList<String> frequencyCharV2(String str, boolean isIgnoreCase) {
		
		if(isIgnoreCase) {
			str = str.toLowerCase();
		}
		
		// Lấy danh sách các ký tự khác nhau trong chuỗi
		String chs = "";
		String tmp = str.trim();
		char ch;
		for(int i = 0; i < str.length(); i++) {
			ch = tmp.charAt(i);
			if(ch != ' ') {
				chs += ch;
				tmp.replace(ch, ' ');
			}
		}
		
		ArrayList<String> fres = new ArrayList<>(chs.length());
		int count = 0;
		for(int i = 0; i < chs.length(); i++) {
			ch = chs.charAt(i);
			count = MyStrings.countChar(str, ch, isIgnoreCase);
			fres.add("[" + ch + " - " + count + "]");
		}
		return fres;
	}
	
	public static String getWords(String str, byte nWords) {

		// Chuẩn hoá
		str = MyStrings.formatString(str);
		String[] arr = str.trim().split("\\s");
		
		String strNew = "";
		for(byte i = 0; i < nWords; i++) {
			strNew += arr[i] + " ";
		}
		strNew += "...";
		
		return strNew;
	}
	
	public static String getWordsV2(String str, byte nWords) {
		// Chuẩn hoá
		str = MyStrings.formatString(str);
		
		// Xác định vị trí cần tách
		int i;
		int count = 0;
		for(i = 0; i < str.length(); i++) {
//			if(str.charAt(i) == ' ') {
//				count++;
//			}
//			if(count >= nWords) {
//				break;
//			}
			if((str.charAt(i) == ' ') && (++count >= nWords)) {
				break;
			}
		}
		
		if(i < str.length()-1) {
			return str.substring(0, i) + "...";
		}
		else {
			return str + "...";
		}
	}
	
	public static void main(String[] args) {
		String str = "Hello Every 123 Good Afternooon";

		System.out.println(MyStrings.getWords(str, (byte)3));

		System.out.println(MyStrings.getWordsV2(str, (byte)3));

//		System.out.println("Có tất cả: " + MyStrings.countChar(str, 'e', true) + " ký tự e.");
//		System.out.println("Chuỗi: " + str + " có " + countWords(str) + " từ.");
//		frequencyChar(str, true);
//		
//		System.out.println(MyStrings.frequencyCharV2(str, false));
//
//		System.out.println(MyStrings.getWords(str, (byte)3));
	}

}
