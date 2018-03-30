package back.step_13.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class P5430 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			String func = br.readLine();
			int size = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			arr = arr.substring(1, arr.length() - 1);
			String tempArr[] = arr.split(",");
			Deque<String> dq = new ArrayDeque();
			boolean isReversed = false;
			boolean isError = false;
			for (int i = 0; i < tempArr.length; i++) {
				if (tempArr[i].length() != 0) {
					dq.addLast(tempArr[i]);
				}
			}
			loop: for (int i = 0; i < func.length(); i++) {
				switch (func.charAt(i)) {
				case 'R':
					if (isReversed) {
						isReversed = false;
					} else {
						isReversed = true;
					}
					break;
				case 'D':
					if (!dq.isEmpty()) {
						if (!isReversed) {
							dq.pollFirst();
						} else {
							dq.pollLast();
						}
					} else {
						isError = true;
						break loop;
					}
					break;
				}
			}
			if (!isError) {
				System.out.print("[");
				if (!isReversed) {
					while (!dq.isEmpty()) {
						System.out.print(dq.pollFirst());
						if (!dq.isEmpty()) {
							System.out.print(",");
						}
					}
				} else {
					while (!dq.isEmpty()) {
						System.out.print(dq.pollLast());
						if (!dq.isEmpty()) {
							System.out.print(",");
						}
					}
				}
				System.out.println("]");
			} else if (isError) {
				System.out.println("error");
			}
		}
	}
}
