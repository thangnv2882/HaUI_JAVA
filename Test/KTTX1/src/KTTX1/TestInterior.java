package KTTX1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestInterior {

	static List<Interior> interiors = new ArrayList<>();
	
	static {
		interiors.add(new Interior("1", "Ghế", 12_000_000, 50, "Xám", "D2200 - R950 - C750", "Khung gỗ bọc vải"));
		interiors.add(new Interior("2", "Bàn ăn", 7_000_000,120, "Màu gỗ + MDF sơn trắng", "D1800 -R900 - C750", "Gỗ tần bì "));
		interiors.add(new Interior("3", "Tủ TV", 9_000_000, 100, "Màu gỗ tự nhiên", "D1500 - R450 - C450", "Gỗ sồi"));
		interiors.add(new Interior("4", "Giường ngủ", 15_900_000, 40, "Màu gỗ + Xám Trắng", "D2000 - R1200 - C1210", "Gỗ sồi, Vải"));
		interiors.add(new Interior("5", "Tủ đồ", 17_000_000, 90, "Màu gỗ + Trắng", "D1600 - R600 - C2000", "Gỗ sồi + Tràm"));
	}

	public static void main(String[] args) {
		
		InteritorManagerImpl interitorManagerImpl = new InteritorManagerImpl();

		Scanner sc = new Scanner(System.in);

		int choose;

		do {
			System.out.println("\n-----------MENU-----------");
			System.out.println("1. Show List Interior.");
			System.out.println("2. Add Interior.");
			System.out.println("3. Edit Interior.");
			System.out.println("4. Delete Interior.");
			System.out.println("5. Search Interior By Id.");
			System.out.println("6. Search Interior By Name.");
			System.out.println("7. Search Interior By Price.");
			System.out.println("8. Search Interior By Color.");
			System.out.println("9. Search Interior By Material.");
			System.out.println("10. Sort Interior By Price.");
			System.out.println("11. Sort Interior By Id.");
			System.out.println("12. Sort Interior By Total.");
			System.out.println("0. Exit");
			System.out.print("Your choose: ");
			choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				showListInterior(TestInterior.interiors);
				break;
			case 2:
				System.out.println("Input interior need add.");
				Interior iAdd = new Interior();
				iAdd.Input();
				interitorManagerImpl.addInterior(iAdd);
				showListInterior(TestInterior.interiors);
				break;
			case 3:
				System.out.println("Input interior need edit.");
				Interior iEdit = new Interior();
				iEdit.Input();
				interitorManagerImpl.editInterior(iEdit);
				break;
			case 4:
				System.out.print("Input id interior need delete: ");
				Interior iDel = new Interior();
				iDel.setProduct_id(sc.nextLine());
				interitorManagerImpl.delInterior(iDel);
				break;
			case 5:
				System.out.print("Input id to search: ");
				String idSearch = sc.nextLine();
				Interior interior = interitorManagerImpl.searchInteriorById(idSearch);
				if (interior != null) {
					System.out.println("Interior need search.");
					interior.OutputAInterior();
				} else {
					System.out.println("Interior with id: " + idSearch + " does not exist.");
				}
				break;
			case 6:
				System.out.print("Input name to search: ");
				String name = sc.nextLine();
				List<Interior> interiorsByName = interitorManagerImpl.searchInteriorByName(name);
				if (interiorsByName.size() > 0) {
					System.out.println("Interiors need search.");
					showListInterior(interiorsByName);
				} else {
					System.out.println("Interiors with name: " + name + " does not exist.");
				}
				break;

			case 7:
				System.out.print("Input price to search: ");
				double priceToSearch = Double.parseDouble(sc.nextLine());
				List<Interior> interiorsByPrice = interitorManagerImpl.searchInteriorByPrice(priceToSearch);
				if (interiorsByPrice.size() > 0) {
					System.out.println("Interiors need search.");
					showListInterior(interiorsByPrice);
				} else {
					System.out.println("Interiors with price: " + priceToSearch + " does not exist.");
				}
				break;
			case 8:
				System.out.print("Input color to search: ");
				String color = sc.nextLine();
				List<Interior> interiorsByColor = interitorManagerImpl.searchInteriorByColor(color);
				if (interiorsByColor.size() > 0) {
					System.out.println("Interiors need search.");
					showListInterior(interiorsByColor);
				} else {
					System.out.println("Interiors with color: " + color + " does not exist.");
				}
				break;
			case 9:
				System.out.print("Input material to search: ");
				String material = sc.nextLine();
				List<Interior> interiorsByMaterial = interitorManagerImpl.searchInteriorByMaterial(material);
				if (interiorsByMaterial.size() > 0) {
					System.out.println("Interiors need search.");
					showListInterior(interiorsByMaterial);
				} else {
					System.out.println("Interiors with material: " + material + " does not exist.");
				}
				break;
			case 10:
				System.out.print("Input price to sort: ");
				double priceToSort = Double.parseDouble(sc.nextLine());
				showListInterior(interitorManagerImpl.sortedInteriorByPrice(priceToSort));
				break;
			case 11:
				interitorManagerImpl.sortedInteriorById(sortType());
				showListInterior(TestInterior.interiors);
				break;
				
			case 12:
				interitorManagerImpl.sortedInteriorByTotal(sortType());
				showListInterior(TestInterior.interiors);
				break;
			case 0:
				System.out.println("Exit Program");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid selection");
			}
		} while (true);
	}

	public static void Tilte() {
		System.out.printf("%-10s %-20s %-20s %-10s %-30s %-25s %-30s", "Id", "Name", "Price", "Total", "Color", "Size",
				"Material");
		System.out.println();
	}

	public static void showListInterior(List<Interior> interiors) {
		System.out.println("Result for you.");
		Tilte();
		for (Interior interior : interiors) {
			interior.Output();
			System.out.println();
		}
	}
	
	public static boolean sortType() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sort type: ");
		System.out.println("1. ASC");
		System.out.println("2. DESC");
		System.out.print("Your choose: ");
		int choose = Integer.parseInt(sc.nextLine());
		if(choose == 1) {
			return true;
		}
		else if(choose == 2) {
			return false;
		}
		throw new IllegalArgumentException("Unexpected value: " + choose);
	}
}
