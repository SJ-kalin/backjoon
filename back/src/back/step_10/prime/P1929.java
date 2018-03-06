package back.step_10.prime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int min = Integer.parseInt(token.nextToken());
		int max = Integer.parseInt(token.nextToken());
		Boolean primeArr[] = new Boolean[max + 1];
		for (int i = 2; i < primeArr.length; i++) {
			primeArr[i] = true;
		}
		primeArr[0] = false;
		primeArr[1] = false;
		for (int i = 2; i < max; i++) {
			if (primeArr[i]) {
				for (int j = 2;; j++) {
					if (i * j > max) {
						break;
					} else {
						primeArr[i * j] = false;
					}
				}
			}
		}
		for (int i = min; i <= max; i++) {
			if (primeArr[i]) {
				bw.write(String.valueOf(i) + "\n");
			}
		}
		bw.flush();
	}
}