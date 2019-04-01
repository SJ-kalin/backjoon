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

        while (count-- > 0) {
            StringTokenizer token = new StringTokenizer(br.readLine());

            char parentNodeValue = token.nextToken().charAt(0);
            char leftChildNodeValue = token.nextToken().charAt(0);
            char rightChildValue = token.nextToken().charAt(0);

            if (!map.containsKey(parentNodeValue)) {
                Node node = new Node(parentNodeValue);
                node.left = new Node(leftChildNodeValue);
                node.right = new Node(rightChildValue);

                map.put(parentNodeValue, node);
                map.put(leftChildNodeValue, node.left);
                map.put(rightChildValue, node.right);

            } else {
                for (Character key : map.keySet()) {
                    if (map.get(key).value == parentNodeValue) {
                        map.get(key).left = new Node(leftChildNodeValue);
                        map.get(key).right = new Node(rightChildValue);
                        map.put(leftChildNodeValue, map.get(key).left);
                        map.put(rightChildValue, map.get(key).right);
                        break;
                    }
                }
            }
        }
        try {
            Node root = map.get('A');
            tree.preOrder(root);
            System.out.println();
            tree.inOrder(root);
            System.out.println();
            tree.postOrder(root);
        } catch (Exception e) {
            System.out.println("A is not defined");
        } finally {
            br.close();
        }
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

    public void preOrder(Node parentNode) {

        if (parentNode == null || parentNode.value == '.') {
            return;
        }
        System.out.print(parentNode.value);
        preOrder(parentNode.left);
        preOrder(parentNode.right);
    }

    public void postOrder(Node parentNode) {
        if (parentNode == null || parentNode.value == '.') {
            return;
        }
        postOrder(parentNode.left);
        postOrder(parentNode.right);
        System.out.print(parentNode.value);
    }

    public void inOrder(Node parentNode) {
        if (parentNode == null || parentNode.value == '.') {
            return;
        }

        inOrder(parentNode.left);
        System.out.print(parentNode.value);
        inOrder(parentNode.right);

    }
}