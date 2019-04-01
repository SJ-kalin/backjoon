package back.step_11.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word[] = br.readLine().split("");
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < word.length; i++) {
            q.offer(new Node(word[i]));
        }
        Stack<Node> s = new Stack<>();

        while (!q.isEmpty()) {

            // stack 비어있을 경우 연산하지 않음
            if (s.isEmpty()) {
                s.push(q.poll());
                continue;
            }

            for (int i = 0; i < s.size(); i++) {
                System.out.print(s.get(i).value);
            }
            System.out.println("\n------------------------");

            Node tempStackElem = s.pop();
            Node tempQueueElem = q.poll();
            if (tempQueueElem.direction == tempStackElem.direction) {
                s.push(tempQueueElem);
                s.push(tempQueueElem);
            }
            // (,]  [,) 이런 조합은 불가능하다.
            else if (tempStackElem.type.equals("word") && isMatched(tempQueueElem, tempStackElem)) {
                int num = 0;
                if (tempQueueElem.value.equals(")")) {
                    num = 2;
                } else {
                    num = 3;
                }
                if (s.isEmpty()) {
                    s.push(new Node(String.valueOf(num)));
                } else if (s.peek().type.equals("number")) {
                    s.push(new Node(String.valueOf(Integer.parseInt(s.pop().value) + num)));
                } else {
                    s.push(new Node(String.valueOf(num)));
                }
            } else if (tempStackElem.type.equals("number")) {
                System.out.println("여기는?");
                if (s.isEmpty()) {
                    s.push(new Node(tempQueueElem.value));
                } else {
                    Node tempSecondStackElem = s.pop();
                    if (isMatched(tempQueueElem, tempSecondStackElem)) {
                        if (tempQueueElem.value.equals(")")) {
                            s.push(new Node(String.valueOf(Integer.parseInt(tempStackElem.value) * 2)));
                        } else {
                            s.push(new Node(String.valueOf(Integer.parseInt(tempStackElem.value) * 3)));
                        }
                    } else {
                        s.push(tempStackElem);
                        s.push(new Node(tempQueueElem.value));
                    }
                }
            }
        }
    }


    private static boolean isMatched(Node tempQueueElem, Node tempStackElem) {
        if ((tempQueueElem.value.equals(")") && tempStackElem.value.equals("(")) || (tempQueueElem.value.equals("]") && tempStackElem.value.equals("["))) {
            return true;
        }
        return false;
    }


    private static void printQ(Queue<String> q) {
        while (!q.isEmpty()) {
            System.out.print(q.poll());
        }
    }
}

class Node {
    String type;
    String value;
    String direction;

    Node(String value) {
        valueCheck(value);
    }

    private void valueCheck(String value) {
        this.value = value;
        if (value.equals("(") || value.equals("[")) {
            this.type = "word";
            this.direction = "Right";
        } else if (value.equals("]") || value.equals(")")) {
            this.type = "word";
            this.direction = "Left";
        } else {
            this.type = "number";
            this.direction = "none";
        }
    }

}