package BT18;
import java.util.Scanner;

public class RunMain {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao chuoi bat ki 1: ");
        String str1 = sc.nextLine();

        System.out.print("Nhap vao chuoi bat ki 2: ");
        String str2 = sc.nextLine();

        System.out.println("1. So sanh khong phan biet chu hoa chu thuong.");
        System.out.println("2. So sanh co phan biet chu hoa chu thuong.");
        System.out.print("Nhap kieu so sanh: ");
        int choose = sc.nextInt();

        switch (choose)
        {
            case 1:
                compare2String(str1.compareToIgnoreCase(str2));
                break;
            case 2:
                compare2String(str1.compareTo(str2));
                break;
            default:
                System.out.println("Lua chon khong hop le.");
        }

    }

    public static void compare2String(int result)
    {
        if(result == 0)
            System.out.println("Giống nhau");
        else
            System.out.println("Khác nhau");
    }
}
