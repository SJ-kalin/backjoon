package back.step_13.deque;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class P1021 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Deque<String> dq = new ArrayDeque();
		ArrayList<String> list = new ArrayList();
		int size = 0;
		int count = 0;
		int searchCount = 0;
		String word[];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		size = Integer.parseInt(token.nextToken());
		count = Integer.parseInt(token.nextToken());

		for (int i = 1; i <= size; i++) {
			dq.add(i + "");
		}

		word = br.readLine().split(" ");

		for (int i = 0; i < word.length; i++) {
			list.add(word[i]);
		}

		while (!list.isEmpty()) {

			if (dq.peekFirst().equals(list.get(0))) {
				dq.pollFirst();
				list.remove(0);
			} else {
				int temp = 0;
				while (!dq.peekFirst().equals(list.get(0))) {
					String tempWord = dq.pollFirst();
					dq.addLast(tempWord);
					temp++;
				}
				if (temp > dq.size() / 2) {
					temp =dq.size()-temp;
				}
				searchCount = searchCount + temp;
			}

		}
		System.out.println(searchCount);

	}

}
