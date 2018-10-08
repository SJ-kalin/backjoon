package back.step_14.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2747 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Integer.parseInt(br.readLine());
		long result = fibo(num);
		System.out.println(result);
		br.close();
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
