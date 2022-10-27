package BT11;
import java.util.Scanner;
import java.util.Arrays;

public class RunMain {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);

		int x = (int) (Math.random() * 10 + 1);
		System.out.println("Số hàng: " + x);

		int y = (int) (Math.random() * 10 + 1);
		System.out.println("Số cột: " + y);

		int[][] arr = new int[x][y];

		System.out.println("Sinh ngẫu nhiên các phần tử trong mảng: ");
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				arr[i][j] = (int) (Math.random() * 10);
			}
		}

		show(arr);
		System.out.println("Số nguyên tố lớn nhất: " + find(arr));
	}
	
	public static int find(int arr[][]) {
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(isPrime(arr[i][j])) {
					max = max > arr[i][j] ? max : arr[i][j];
				}
			}
		}
		
		return max;
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
		System.out.println("Mảng hiện tại: ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}