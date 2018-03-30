package back.step_13.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P10866 {
	public static void main(String[] args) throws IOException {
		Deque<String> deque = new LinkedList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			switch (token.nextToken()) {
			case "push_front":
				deque.addFirst(token.nextToken());
				break;
			case "push_back":
				deque.addLast(token.nextToken());
				break;
			case "pop_front":
				if (deque.isEmpty()) {
					bw.write(String.valueOf(-1) + "\n");
				} else {
					bw.write(deque.pollFirst() + "\n");
				}
				break;
			case "pop_back":
				if (deque.isEmpty()) {
					bw.write(String.valueOf(-1) + "\n");
				} else {
					bw.write(deque.pollLast() + "\n");
				}
				break;
			case "size":
				bw.write(deque.size());
				break;
			case "empty":
				if (deque.isEmpty()) {
					bw.write(String.valueOf(1) + "\n");
				} else {
					bw.write(String.valueOf(0) + "\n");
				}
				break;
			case "front":
				if (deque.isEmpty()) {
					bw.write(String.valueOf(-1) + "\n");
				} else {
					bw.write(deque.peekFirst() + "\n");
				}
				break;
			case "back":
				if (deque.isEmpty()) {
					bw.write(String.valueOf(-1) + "\n");
				} else {
					bw.write(deque.peekLast() + "\n");
				}
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
