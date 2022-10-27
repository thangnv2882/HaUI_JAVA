package BT7;
import java.util.Scanner;
import java.util.Arrays;

public class RunMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = (int) (Math.random() * 10 + 1);
		System.out.println("Số phần tử của mảng: " + n);
		
		int[] arr = new int[n];
		
		System.out.println("Sinh ngẫu nhiên các phần tử trong mảng.");
		for(int i = 0; i < n; i++) {
			arr[i] = (int)(Math.random() * 10);
		}
		
		Arrays.sort(arr);
		
		System.out.println("Các phần tử trong mảng tăng dần: ");
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.print("\nNhập phần tử cần tìm: ");
		int x = sc.nextInt();
		
		int result = binarySearch(arr, 0, n, x);
		if(result == -1) {
			System.out.println("Không có phần tử cần tìm kiếm.");
		}
		else {
			System.out.println("Vị trị của phần tử cần tìm: " + result);			
		}
		
	}
	public static int binarySearch(int a[], int left, int right, int x) {
		int mid;
		while(left < right) {
			mid = (left + right) / 2;
			if(x == a[mid]) {
				return mid;
			}
			else if(x < a[mid]) {
				return binarySearch(a, left, mid, x);
			}
			else {
				return binarySearch(a, mid+1, right, x);
			}
		}
		return -1;
	}
	
	
}
