package back.step_12.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11866 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer token = new StringTokenizer(input);
		int count = Integer.parseInt(token.nextToken());
		int round = Integer.parseInt(token.nextToken());

		Queue<Integer> queue = new LinkedList();
		Queue<Integer> result = new LinkedList();

		for (int i = 1; i <= count; i++) {
			queue.offer(i);
		}

		while (!queue.isEmpty()) {

			for (int i = 0; i < round - 1; i++) {
				int temp = queue.poll();
				queue.offer(temp);
			}
			result.offer(queue.poll());
		}

		System.out.print("<");
		while (result.size() != 0) {
			System.out.print(result.poll());
			if (result.size() != 0) {
				System.out.print(", ");
			}
		}
		System.out.println(">");
	}
}
