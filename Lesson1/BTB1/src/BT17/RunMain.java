package BT17;
import java.util.Scanner;

public class RunMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap vao chuoi bat ki: ");
		String str = sc.nextLine();

		str = str.trim().toLowerCase();
		str = str.replaceAll("[0-9]", "");
		str = str.replaceAll("\\s+", " ");

		String[] strings = str.split(" ");
		String newStr = "";
		for (String s : strings) {
			newStr += String.valueOf(s.charAt(0)).toUpperCase() + s.substring(1);
			if (!s.equals(strings[strings.length - 1]))
				newStr += " ";
		}

		System.out.println(newStr);
	}

}
