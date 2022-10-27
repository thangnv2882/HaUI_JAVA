package BT9;
import java.util.Scanner;
import java.util.Arrays;

public class RunMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = (int) (Math.random() * 10 + 1);
		System.out.println("Số mảng: " + x);

		int y = (int) (Math.random() * 10 + 1);
		System.out.println("Số phần tử mỗi mảng: " + y);

		int[][] arr = new int[x][y];

		System.out.println("Sinh ngẫu nhiên các phần tử trong mảng.");
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				arr[i][j] = (int) (Math.random() * 10);
			}
		}

		show(arr);
		
		System.out.print("Giá trị cần so sánh: ");
		int k = sc.nextInt();
		
		check(arr, k);
		

	}

	public static void check(int arr[][], int k) {
		int sum;
		int d = 0;
		for(int i = 0; i < arr.length ; i++) {
			sum = 0;
			for(int j = 0; j < arr[0].length; j++) {
				sum += arr[i][j];
			}
			if(sum == k) {
				System.out.println("Mảng số: " + (i+1));
				d++;
			}
		}
		if(d == 0) {
			System.out.println("Không có mảng nào có tổng giá trị các phần tử bằng giá trị cần so sánh.");
		}
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