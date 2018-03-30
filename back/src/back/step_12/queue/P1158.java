package back.step_12.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1158 {
	public static void main(String[] args) throws IOException {
		int count = 0;
		int size = 0;
		int queue[];
		int printQueue[];
		int k = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		StringTokenizer token = new StringTokenizer(input);

		size = Integer.parseInt(token.nextToken());
		count = Integer.parseInt(token.nextToken());
		queue = new int[size];
		printQueue = new int[size];
		for (int i = 0; i < size; i++) {
			queue[i] = i + 1;
		}
		int front = 0;
		for (int i = 0; i < size; i++) {
			int temp = 0;
			while (temp < count - 1) {
				if (queue[front % queue.length] != 0) {
					temp++;
				}
				front++;
				if (temp == count - 1) {
					while (queue[front % queue.length] == 0) {
						front++;
					}
				}
			}

			printQueue[k++] = queue[front % queue.length];
			queue[front % queue.length] = 0;
			if (count == 1) {
				front++;
			}
			front = front % queue.length;
		}
		System.out.print("<");
		for (k = 0; k < printQueue.length; k++) {
			System.out.print(printQueue[k]);
			if (k != printQueue.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println(">");
	}
}
