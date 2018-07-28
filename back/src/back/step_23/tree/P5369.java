package back.step_23.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P5369 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		while (scan.hasNextInt()) {
			list.add(scan.nextInt());
		}
		BinarySearch binarySearch = new BinarySearch();
		for (int i = 0; i < list.size(); i++) {
			binarySearch.insert(list.get(i));
		}
		binarySearch.postOrder(binarySearch.root);
	}
}

class BinaryNode {
	int num;
	BinaryNode left;
	BinaryNode right;

	public BinaryNode(int num) {
		this.num = num;
	}

}

class BinarySearch {
	BinaryNode root;

	public BinarySearch() {
		// TODO Auto-generated constructor stub
	}

	public void insert(int num) {
		this.root = insertNode(root, num);
	}

	private BinaryNode insertNode(BinaryNode node, int num) {
		if (node == null) {
			return new BinaryNode(num);
		} else if (node.num > num) {
			node.left = insertNode(node.left, num);
		} else if (node.num < num) {
			node.right = insertNode(node.right, num);
		}
		return node;
	}

	public void postOrder(BinaryNode root) {

		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.num);
	}
}
