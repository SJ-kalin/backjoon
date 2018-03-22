package back.step_11.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());
		int seq[] = new int[count];
		int arr[] = new int[count];
		int index = 0;
		ArrayList<Integer> stack = new ArrayList();
		boolean isSeq = true;
		StringBuffer sbr = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			seq[i] = i + 1;
		}

		for (int i = 0; i < arr.length; i++) {

			if (stack.size() == 0) {
				stack.add(seq[index++]);
				sbr.append("+\n");
			}

			if (stack.get(stack.size() - 1) > arr[i]) {
				isSeq = false;
				break;
			}

			while (arr[i] > stack.get(stack.size() - 1)) {
				stack.add(seq[index++]);
				sbr.append("+\n");
			}

			if (arr[i] == stack.get(stack.size() - 1)) {
				stack.remove(stack.size() - 1);
				sbr.append("-\n");
			}
		}

		if (isSeq) {
			System.out.println(sbr);
		} else {
			System.out.println("NO");
		}
	}

}
