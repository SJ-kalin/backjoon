package back.step_09.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		int numCount = 0;
		int max = 0;
		int arr[];
		int accumulater[];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		numCount = Integer.parseInt(br.readLine());
		arr = new int[numCount];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		accumulater = new int[max + 1];

		for (int i = 0; i < arr.length; i++) {
			accumulater[arr[i]]++;
		}
		for (int i = 0; i < accumulater.length - 1; i++) {
			accumulater[i + 1] = accumulater[i + 1] + accumulater[i];
		}
		for (int i = 0; i < accumulater.length - 1; i++) {
			if (accumulater[i + 1] - accumulater[i] != 0) {
				for (int j = 0; j < accumulater[i + 1] - accumulater[i]; j++) {
					bw.write(i + 1 + "\n");
				}
			}
		}
		br.close();
		bw.close();
	}
}
