package back.step_10.prime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class P4948 {
	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList();

		int min = scan.nextInt();
		while (min != 0) {
			int count = 0;
			int max = min * 2;
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
			for (int i = min + 1; i <= max; i++) {
				if (primeArr[i]) {
					count++;
				}
			}
			list.add(count);
			min = scan.nextInt();
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
