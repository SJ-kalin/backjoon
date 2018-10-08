package back.step_09.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1427 {
	public static void main(String[] args) throws IOException {
		String num = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		num = br.readLine();
		int arr[] = new int[num.length()];
		for (int i = 0; i < num.length(); i++) {
			arr[i] = Integer.parseInt(num.substring(i, i + 1));
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			bw.write(Integer.toString(arr[i]));
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
