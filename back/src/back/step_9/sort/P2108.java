package back.step_9.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P2108 {

	public static void main(String[] args) throws IOException {
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		count = Integer.parseInt(br.readLine());
		int arr[] = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.replace(arr[i], map.get(arr[i]) + 1);
			}
		}
		Arrays.sort(arr);

		Double avg = findAvg(arr);
		int mode = findMode(map);

		System.out.println(avg.intValue());
		System.out.println(arr[arr.length / 2]);
		System.out.println(mode);
		System.out.println(arr[arr.length - 1] - arr[0]);
	}

	private static double findAvg(int[] arr) {
		double sum = 0;
		double avg = 0.0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		avg = sum / (double) arr.length;
		avg = Math.round(avg);

		return avg;
	}

	static int findMode(HashMap<Integer, Integer> map) {
		int max = 0;
		int mode = 0;
		ArrayList<Integer> list = new ArrayList();
		for (Integer key : map.keySet()) {
			if (map.get(key) > max) {
				max = map.get(key);
			}
		}
		for (Integer key : map.keySet()) {
			if (map.get(key) == max) {
				list.add(key);
			}
		}
		if (list.size() == 1) {
			mode = list.get(0);
		} else {
			int tempArr[] = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				tempArr[i] = list.get(i);
			}
			Arrays.sort(tempArr);
			mode = tempArr[1];
		}
		return mode;
	}
}
