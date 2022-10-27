package BT10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RunMain {
	public static void main(String[] args) {

		int n = (int) (Math.random() * 10 + 1);
		System.out.println("Số phần tử mỗi mảng: " + n);

		List<Integer> arr = new ArrayList<>();

		System.out.println("Sinh ngẫu nhiên các phần tử trong mảng: ");
		for (int i = 0; i < n; i++) {
			arr.add((int) (Math.random() * 10));
		}

		System.out.print("Mảng ban đầu: ");
		show(arr);

		List<Integer> arrPrime = new ArrayList<>();
		List<Integer> arrNormal = new ArrayList<>();

		for (int k = 0; k < n; k++) {
			if (isPrime(arr.get(k))) {
				arrPrime.add(arr.get(k));
			} else {
				arrNormal.add(arr.get(k));
			}
		}

		Collections.sort(arrPrime);
		Collections.sort(arrNormal);

		List<Integer> arrEnd = new ArrayList<>();

		arrEnd.addAll(arrPrime);
		arrEnd.addAll(arrNormal);

		System.out.print("Mảng kết thúc: ");
		show(arrEnd);
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return num > 1;
	}

	public static void show(List<Integer> arrEnd) {
		for (int i = 0; i < arrEnd.size(); i++) {
			System.out.print(arrEnd.get(i) + " ");
		}
		System.out.println();
	}

}
