package back.step_00.datastructure;

import java.util.LinkedList;
import java.util.List;

public class MyLinkedList {

	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		list.remove();
		System.out.println(list.toString());
	}

}

class Node {
	Node next;
	Node prev;
	Object value;

	Node() {

	}

	Node(Object value) {
		this.prev = null;
		this.next = null;
		this.value = value;
	}
}

class CustomLinkedList {
	private Node root;
	private int size;

	public CustomLinkedList() {
		root = new Node();
	}

	boolean add(Object value) {
		Node temp = new Node(value);
		Node head = root;
		while (head.next != null) {
			head = head.next;
		}
		head.next = temp;
		temp.prev = head;
		temp.next = null;

		size++;
		return true;
	}

	int size() {
		return this.size;
	}

	boolean remove() {
		if (root.next == null) {
			return false;
		}
		Node head = root;
		while (head.next != null) {
			head = head.next;
		}
		Node temp = head.prev;
		temp.next = null;
		size--;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		Node head = root.next;
		while (head != null) {
			buffer.append(head.value + " ");
			head = head.next;
		}
		return buffer.toString();
	}

}