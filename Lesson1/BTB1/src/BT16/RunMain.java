package BT16;
import java.util.Scanner;

public class RunMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao chuoi bat ki: ");
        String str = sc.nextLine();

        str = str.trim();
//        str = str.replaceAll("[0-9]", "");
        str = str.replaceAll("\\s+", " ");

        String[] strings = str.split(" ");
        System.out.println("So tu cua chuoi la: " + strings.length);

	}

}
