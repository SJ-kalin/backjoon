package back.step._14.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9471 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int result = pisano(count);
		System.out.println(result);
	}

	private static int pisano(int count) {

		return 0;
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
