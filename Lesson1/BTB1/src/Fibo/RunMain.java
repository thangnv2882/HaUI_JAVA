package Fibo;

public class RunMain {
	public static void main(String[] args) {
		
		int n = (int) (Math.random() * 10);
		
		for(int i = 1; i < n; i++) {
			System.out.println("Số fibonacci " + i + ": " + Fibonacci(i));
		}
		
	}
	
	
	
	public static int Fibonacci(int n) {
		if (n == 1 || n == 2)
			
	        return 1;
	    return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
}
