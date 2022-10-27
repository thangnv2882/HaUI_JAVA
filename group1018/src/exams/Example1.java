package exams;

public class Example1 {

	public static void main(String[] args) {

//		Sinh ngẫu nhiên một giá trị nguyên (int) trong phạm vi [0-100)
		int n = (int) (Math.random() * 100);

//		In thông tin
		System.out.println("Giá trị của n: " + n);

		boolean flag = true;

		if (n < 2) {
			flag = false;
		} else {
			for (int i = 2; i <= (int) Math.sqrt(n); i++) {
				if (n % i == 0) {
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			System.out.println(n + " là số nguyên tố");
		} else {
			System.out.println(n + " không là số nguyên tố");
		}

	}

}
