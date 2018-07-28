package back.step_23.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P9934 {
	public static void main(String[] args) throws IOException {
		Queue<String[]> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new ArrayList<>();
		int level = Integer.parseInt(br.readLine());
		String token = br.readLine();
		String[] arr = token.split(" ");
		queue.offer(arr);
		while (!queue.isEmpty()) {
			String temp[] = queue.poll();
			if (temp.length > 1) {
				list.add(temp[temp.length / 2]);
			} else {
				list.add(temp[0]);
				continue;
			}
			String arrLeft[] = new String[temp.length / 2];
			String arrRight[] = new String[temp.length / 2];
			System.arraycopy(temp, 0, arrLeft, 0, temp.length / 2);
			System.arraycopy(temp, temp.length / 2 + 1, arrRight, 0, temp.length / 2);

			queue.offer(arrLeft);
			queue.offer(arrRight);
		}

		int k = 0;
		for (int i = 0; i < level; i++) {
			for (int j = 0; j < Math.pow(2, i); j++) {
				System.out.print(list.get(k++) + " ");
			}
			if (i != 2) {
				System.out.println();
			}
		}
	}
}
