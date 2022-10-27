package exams;

public class Example2 {

	/**
	 * This method is used to check a value <b>is prime</b>? <br>
	 * 
	 * <i>Update 22/09/2022</i>
	 * 
	 * @author Nguyen Van Thang
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return n > 1;
	}

	/**
	 * This method is used to get UCLN value from two parameters <br>
	 * 
	 * <i>Update 22/09/2022</i>
	 * 
	 * @author Nguyen Van Thang
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int UCLN(int a, int b) {

//		if(b==0) {
//			return a;
//		}
//		else {
//			return UCLN(b, a%b);
//		}

		int ucln = -1;
		if (a * b != 0) {
			while (a != b) {
				if (a > b) {
					a -= b;
				} else {
					b -= a;
				}
			}

			ucln = a; // ucln = b;
		}

		return ucln;
	}
	
	public static int UCLN(int a, int b, int c) {
		return Example2.UCLN(Example2.UCLN(a, b), c);
	}
	
	public static void biEqua(int a, int b, int c, int d, int e, int f) {
		

		System.out.println(a+"x + " + b + "y = " + c);
		System.out.println(d+"x + " + e + "y = " + f);
		
		a *= d;
		b *= d;
		c *= d;
		
		d = a; 
		e *= a;
		f *= a;
		
		double y = (double)(c-f)/(b-e);
		double x = (c - y*b) / a;
		
		System.out.println("Nghiệm của hệ phương trình là: ");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}

	public static void main(String[] args) {

//		int n = (int) (Math.random() * 100);
//		System.out.println("Giá trị của n: " + n);

//		Example2 ex2 = new Example2();

//		if (Example2.isPrime(n)) {
//			System.out.println(n + " là số nguyên tố");
//		} else {
//			System.out.println(n + " không là số nguyên tố");
//		}

		int a = (int) (Math.random() * 100);
		int b = (int) (Math.random() * 100);
		int c = (int) (Math.random() * 100);
		int d = (int) (Math.random() * 100);
		int e = (int) (Math.random() * 100);
		int f = (int) (Math.random() * 100);
		
		biEqua(a, b, c, d, e, f);
//		System.out.println("UCLN của " + a + " và " + b + " là: " + Example2.UCLN(a, b));
//		System.out.println("UCLN của " + a + " và " + b + " và " + c + " là: " + Example2.UCLN(a, b, c));

	}

}
