package back.step_00.datastructure;

import javax.xml.bind.ValidationEvent;

//http://songeunjung92.tistory.com/31
//http://marobiana.tistory.com/82
public class MyTree {
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(8);
		binarySearchTree.insert(3);
		binarySearchTree.insert(5);
		binarySearchTree.insert(1);
		binarySearchTree.insert(6);
		binarySearchTree.insert(8);
		binarySearchTree.insert(7);
		binarySearchTree.insert(2);

		System.out.println(binarySearchTree.count);
		// binarySearchTree.preOrder(binarySearchTree.root);
		// binarySearchTree.inOrder(binarySearchTree.root);
		// binarySearchTree.postOrder(binarySearchTree.root);
	}
}

class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int data) {
		this.data = data;
	}

	int getData() {
		return this.data;
	}

}

class BinarySearchTree {

	TreeNode root;
	static int count = 0;

	void insert(int data) {
		root = insertNode(root, data);
	}

	private TreeNode insertNode(TreeNode node, int data) {
		count++;
		if (node == null) {
			return new TreeNode(data);
		} else if (node.data > data) {
			node.left = insertNode(node.left, data);
		} else {
			node.right = insertNode(node.right, data);
		}
		return node;
	}

	void preOrder(TreeNode node) {

		if (node == null) {
			return;
		}

		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);

	}

	void inOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);
	}

	void postOrder(TreeNode node) {
		if (node == null) {
			return;
		}

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data);

	}
}
