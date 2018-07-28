package back.step_23.tree;

import java.util.Scanner;

public class P2957 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		BinodeTree binodeTree = new BinodeTree();
		while (count-- > 0) {
			binodeTree.insertNode(scan.nextInt());
			System.out.println(binodeTree.count);
		}

	}
}

class Binode {
	Binode left;
	Binode right;
	int num;

	Binode(int num) {
		this.num = num;
	}
}

class BinodeTree {
	Binode root;
	static int count = 0;

	void insertNode(int num) {
		if (this.root == null) {
			this.root = new Binode(num);
		} else {
			insert(this.root, num);
		}
	}

	void insert(Binode node, int num) {
		count++;
		if (num < node.num) {
			if (node.left == null) {
				node.left = new Binode(num);
			} else {
				insert(node.left, num);
			}
		} else {
			if (node.right == null) {
				node.right = new Binode(num);
			} else {
				insert(node.right, num);
			}
		}
	}
}