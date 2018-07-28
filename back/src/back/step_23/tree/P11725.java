package back.step_23.tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class P11725 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.valueOf(br.readLine());
		// Map<Integer, ArrayList<Integer>> mapList = new HashMap<>();
		// Map<Integer, Integer> parent = new HashMap<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		int parentArr[] = new int[count + 1];
		for (int i = 1; i <= count + 1; i++) {
			// mapList.put(i, new ArrayList<>());
			list.add(new ArrayList<>());
		}
		for (int i = 1; i < count; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());

			int first = Integer.valueOf(token.nextToken());
			int second = Integer.valueOf(token.nextToken());
			list.get(first).add(second);
			list.get(second).add(first);
			// mapList.get(first).add(second);
			// mapList.get(second).add(first);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int i = 0; i < list.get(temp).size(); i++) {
				if (parentArr[list.get(temp).get(i)] == 0) {
					queue.offer(list.get(temp).get(i));
					parentArr[list.get(temp).get(i)] = temp;
				}
			}
			// for (int i = 1; i < list.size(); i++) {
			// for (int j = 0; j < list.get(i).size(); j++) {
			// if (list.get(i).get(j) == temp) {
			// list.get(i).remove(j);
			// break;
			// }
			// }
			// }

			// for (int i = 0; i < list.get(temp).size(); i++) {
			// queue.add(list.get(temp).get(i));
			// parent.put(mapList.get(temp).get(i), temp);
			// parentArr[list.get(temp).get(i)] = temp;
			// }
			// list.get(temp).clear();

		} // -while ³¡
			// for (int i = 2; i < parent.size() + 2; i++) {
			// bw.write(parent.get(i) + "\n");
			//
			// }

		for (int i = 2; i < parentArr.length; i++) {
			if (parentArr[i] != 0) {
				bw.write(parentArr[i] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
