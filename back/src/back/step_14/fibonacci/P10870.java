package back.step_14.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = fibo(Integer.parseInt(br.readLine()));
		System.out.println(result);
	}

	private static int fibo(int parseInt) {
		if (parseInt == 1 || parseInt == 0) {
			return parseInt;
		}
		return fibo(parseInt - 1) + fibo(parseInt - 2);
	}
}
