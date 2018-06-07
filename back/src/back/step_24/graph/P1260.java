package back.step_24.graph;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1260 {

	static int matrix[][];
	static int startVertex;
	static Boolean isCheck[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// test case 조건 vertex, line, 첫 번째 vertex
		String testCase[] = br.readLine().split(" ");
		int vertex = Integer.valueOf(testCase[0]);
		int line = Integer.valueOf(testCase[1]);
		startVertex = Integer.valueOf(testCase[2]) - 1;
		matrix = new int[vertex][vertex];
		isCheck = new Boolean[matrix.length];
		for (int i = 0; i < line; i++) {
			String token[] = br.readLine().split(" ");
			int x = Integer.valueOf(token[0]) - 1;
			int y = Integer.valueOf(token[1]) - 1;
			matrix[x][y] = 1;
			matrix[y][x] = 1;
		}
		Arrays.fill(isCheck, false);
		dfs(startVertex);
		Arrays.fill(isCheck, false);
		System.out.println();
		bfs(startVertex);

	}

	private static void bfs(int startVertex) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList();
		queue.offer(startVertex);
		isCheck[startVertex] = true;
		System.out.print(startVertex + 1 + " ");
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			for (int i = 0; i < matrix[temp].length; i++) {
				if (matrix[temp][i] == 1 && !isCheck[i]) {
					isCheck[i] = true;
					queue.add(i);
					System.out.print(i + 1 + " ");
				}
			}
		}
	}

	private static void dfs(int startVertex) {
		isCheck[startVertex] = true;
		System.out.print(startVertex + 1 + " ");
		for (int i = 0; i < matrix.length; i++) {
			if (!isCheck[i] && matrix[startVertex][i] == 1) {
				dfs(i);
			}
		}

	}

}
