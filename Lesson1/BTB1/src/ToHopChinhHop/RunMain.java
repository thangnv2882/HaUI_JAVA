package ToHopChinhHop;

public class RunMain {
	public static void main(String[] args) {

		int k = (int) (Math.random() * 10 + 1);
		int n = (int) (Math.random() * 10 + 1);
		if(k > n) {
			int temp = k;
			k = n;
			n = temp;
		}

		System.out.println("Tổ hợp chập " + k + " của " + n + " phần tử là: " + C(k, n));
		System.out.println("Chỉnh hợp chập " + k + " của " + n + " phần tử là: " + A(k, n));
		
		
	}
	
	public static int gt(int x) {
		if(x == 1 || x == 0) {
			return 1;
		}
		return x * gt(x-1);
	}
	
//	C(k, n) = n! / (k! * (n-k)! )
	public static int C(int k, int n) {
		return gt(n) / (gt(k) * gt(n-k));
	}
	
//	C(k, n) = n! / (n-k)!
	public static int A(int k, int n) {
		return gt(n) / gt(n-k);
	}

}
