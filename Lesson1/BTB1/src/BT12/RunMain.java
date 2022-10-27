package BT12;
import java.util.Scanner;
import java.util.Arrays;

public class RunMain {
	public static void main(String[] args) {

		int x1 = (int) (Math.random() * 10 + 1);
		System.out.println("Số hàng: " + x1);

		int y1 = (int) (Math.random() * 10 + 1);
		System.out.println("Số cột: " + y1);

		int[][] arr1 = new int[x1][y1];

		System.out.println("Sinh ngẫu nhiên các phần tử trong mảng 1: ");
		for (int i = 0; i < x1; i++) {
			for (int j = 0; j < y1; j++) {
				arr1[i][j] = (int) (Math.random() * 10);
			}
		}
		
		int x2 = y1;
		System.out.println("Số hàng: " + x2);

		int y2 = (int) (Math.random() * 10 + 1);
		System.out.println("Số cột: " + y2);

		int[][] arr2 = new int[x2][y2];

		System.out.println("Sinh ngẫu nhiên các phần tử trong mảng 1: ");
		for (int i = 0; i < x2; i++) {
			for (int j = 0; j < y2; j++) {
				arr2[i][j] = (int) (Math.random() * 10);
			}
		}

		System.out.println("Mảng 1: ");
		show(arr1);

		System.out.println("Mảng 2: ");
		show(arr2);
		
		System.out.println("Mảng kết quả: ");
		show(multi(arr1, arr2));
		
	}
	
	public static int[][] multi(int arr1[][], int arr2[][]) {
		int x = arr1.length;
		int y = arr2[0].length;
		int[][] arr3 = new int[x][y];
		
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				int s = 0;
				for(int k = 0; k < arr1[0].length; k++) {
					s +=  arr1[i][k] * arr2[k][j];
				}
				arr3[i][j] = s;
			}
		}
		
		return arr3;
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return num > 1;
	}


	public static void show(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}