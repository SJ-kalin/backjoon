package back.step._14.fibonacci;

import java.util.Scanner;

public class P2749 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		long mod = (long) (15 * Math.pow(10, 5));
		long num = scan.nextLong();
		System.out.println(fibo(num));
		System.out.println(fibo(num) % 1500000);
	}

	private static long fibo(long num) {
		long first = 0;
		long second = 1;
		long result = 0;

		if (num == 0 || num == 1) {
			return num;
		}

		for (long i = 1; i < num; i++) {
			result = first + second;
			first = second;
			second = result;
		}

		return result;
	}
}
