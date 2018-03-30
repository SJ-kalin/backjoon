package back.step_12.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P10845 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList();
		int index = -1;

		for (int i = 0; i < count; i++) {
			String command = br.readLine();
			StringTokenizer token = new StringTokenizer(command);
			switch (token.nextToken()) {
			case "push":
				int tempNum = Integer.parseInt(token.nextToken());
				list.add(tempNum);
				break;
			case "pop":
				if (list.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(list.get(0));
					list.remove(0);
				}
				break;
			case "size":
				System.out.println(list.size());
				break;
			case "empty":
				if (list.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "front":
				if (list.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(list.get(0));
				}
				break;
			case "back":
				if (list.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(list.get(list.size() - 1));
				}
				break;
			}
		}
		br.close();
	}
}
