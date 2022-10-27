package BT8;
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
		System.out.println("Mảng hiện tại: ");
		show(arr);
		
		
		System.out.print("\nNhập phần tử cần thêm: ");
		int x = sc.nextInt();

		System.out.println("Mảng sau khi thêm: ");
		show(insert(arr, x));
	}
	
	public static int[] insert(int arr[], int x) {
		int n = arr.length;
		int[] temp = new int[n+1];
		int j = n;
		boolean inserted = false;
		for(int i = n-1; i >= 0; i--) {
			if(x < arr[i]) {
				temp[j] = arr[i];
				j--;
			}
			else {
				if(!inserted) {
					temp[j] = x;
					j--;
					inserted = true;
				}
				temp[j] = arr[i];
				j--;
			}
		}
		return temp;
	}
	
	public static void show(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
}
