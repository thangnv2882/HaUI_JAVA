package BT19;
import java.util.Scanner;

public class RunMain {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao chuoi bat ki: ");
        String string = sc.nextLine();
        string.trim();
        string.replace("\\s+", " ");
        String[] str = string.split(" ");

        System.out.print("Nhap vi tri bat dau: ");
        int start = sc.nextInt();

        System.out.print("Nhap so luong tu muon cat: ");
        int amount = sc.nextInt();

        System.out.println("Chuoi sau khi cat: " + handleCut(str, start, amount));

    }
	
	public static String handleCut(String[] str, int start, int amount) {
		String strResult = "";
        int cnt = 0;
        for (int i = start - 1; i < str.length; i++)
        {
            if(cnt < amount)
            {
                strResult += str[i];
                strResult += " ";
                cnt++;
            }
        }

        strResult = strResult.trim();
        return strResult;
	}
}
