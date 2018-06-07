package back.step_24.graph;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P2178 {

	static int N;
	static int M;
	static int X_SIZE;
	static int Y_SIZE;
	static Node[][] matrix;
	static Boolean isChecked[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp[] = br.readLine().split(" ");
		N = Integer.valueOf(temp[0]);
		M = Integer.valueOf(temp[1]);
		matrix = new Node[N][M];
		X_SIZE = matrix.length;
		Y_SIZE = matrix[0].length;
		isChecked = new Boolean[X_SIZE][Y_SIZE];

		for (int i = 0; i < matrix.length; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = new Node(i, j, Integer.valueOf(temp[j]));
			}
		}

		bfs();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j].value);
			}
			System.out.println();
		}
	}

	private static void bfs() {

		Queue<Node> queue = new LinkedList();
		queue.add(matrix[0][0]);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp.x + 1 < X_SIZE && temp.value != 0) {
			}
		}

	}
}

class Node {
	public Node(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	int x;
	int y;
	int value;
}
