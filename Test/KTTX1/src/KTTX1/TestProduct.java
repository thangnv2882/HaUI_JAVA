package KTTX1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestProduct {

	static List<Interior> interiors = new ArrayList<>();

	public static void main(String[] args) {
		InteritorManagerImpl interitorManagerImpl = new InteritorManagerImpl();

		Scanner sc = new Scanner(System.in);

		int choose;
		
		do{
			System.out.println("-----------MENU-----------");
			System.out.println("1. Add Interior.");
			System.out.println("2. Edit Interior.");
			System.out.println("3. Delete Interior.");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println("0. Exit");
			System.out.print("Your choose: ");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Input interior need add.");
				Interior iAdd = new Interior();
				iAdd.Input();
				interitorManagerImpl.addInterior(iAdd);
				break;
			case 2: 
				System.out.println("Input interior need edit.");
				Interior iEdit = new Interior();
				iEdit.Input();
				interitorManagerImpl.editInterior(iEdit);
				break;
				
			case 0: 
				System.exit(0);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choose);
			}
		} while (true); 
	}
}
