package back.step_10.prime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P2581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sbf = new StringBuffer();

		int min = Integer.parseInt(br.readLine());
		int max = Integer.parseInt(br.readLine());
		int sum = 0;

		for (int i = min; i <= max; i++) {
			if (isPrimeNumber(i)) {
				sum = sum + i;
				sbf.append(String.valueOf(i) + ",");
			}
		}
		if (sbf.length() == 0) {
			bw.write(String.valueOf(-1));
		} else {
			bw.write(String.valueOf(sum) + "\n"
					+ String.valueOf(sbf.toString().substring(0, sbf.toString().indexOf(","))));
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static boolean isPrimeNumber(int i) {

		if (i == 1) {
			return false;
		}

		for (int k = 2; k < i; k++) {
			if (i % k == 0) {
				return false;
			}
		}
		return true;
	}
}
