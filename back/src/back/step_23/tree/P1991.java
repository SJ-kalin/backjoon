package back.step_23.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1991 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		int count = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		count = Integer.parseInt(br.readLine());
		Map<Character, Node> map = new HashMap<>();
		Tree tree = new Tree();
		Node root = null;
		while (count-- > 0) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			char parent = token.nextToken().charAt(0);
			char leftChild = token.nextToken().charAt(0);
			char rightChild = token.nextToken().charAt(0);
			if (!map.containsKey(parent)) {
				Node node = new Node(parent);
				node.left = new Node(leftChild);
				node.right = new Node(rightChild);
				map.put(parent, node);
				map.put(leftChild, node.left);
				map.put(rightChild, node.right);
			} else {
				for (Character key : map.keySet()) {
					if (map.get(key).value == parent) {
						map.get(key).left = new Node(leftChild);
						map.get(key).right = new Node(rightChild);
						map.put(leftChild, map.get(key).left);
						map.put(rightChild, map.get(key).right);
						break;
					}
				}
			}

		} // while Á¾·á
		root = map.get('A');

		tree.preOrder(root);
		System.out.println();
		tree.inOrder(root);
		System.out.println();
		tree.postOrder(root);
		br.close();
	}
}

class Node {
	Node left;
	Node right;
	char value;

	Node(char value) {
		this.value = value;
	}
}

class Tree {

	public void preOrder(Node node) {
		if (node == null || node.value == '.') {
			return;
		}
		System.out.print(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder(Node node) {
		if (node == null || node.value == '.') {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value);
	}

	public void inOrder(Node node) {
		if (node == null || node.value == '.') {
			return;
		}

		inOrder(node.left);
		System.out.print(node.value);
		inOrder(node.right);

	}
}