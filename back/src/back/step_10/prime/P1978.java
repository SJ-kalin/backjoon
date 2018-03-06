package back.step_10.prime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1978 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int repeat = Integer.parseInt(br.readLine());
		int count = 0;
		String temp[] = br.readLine().split(" ");
		int arr[] = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		for (int i = 0; i < repeat; i++) {
			if (findPrimeNumber(arr[i])) {
				count++;
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		br.close();
		bw.close();
	}

	private static boolean findPrimeNumber(int i) {
		boolean isPrime = true;
		if (i == 1 || i == 2) {
			return false;
		}
		for (int k = 2; k < i; k++) {
			if (i % k == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
