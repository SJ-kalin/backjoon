package back.step_12.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1966 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int numOfDocu = Integer.parseInt(tokenizer.nextToken());
            int targetDocuIndex = Integer.parseInt(tokenizer.nextToken());
            StringTokenizer docuList = new StringTokenizer(br.readLine());
            Queue<Node> q = new LinkedList<>();
            for (int i = 0; i < numOfDocu; i++) {
                Node temp = new Node(Integer.parseInt(docuList.nextToken()));
                if (i == targetDocuIndex) {
                    temp.targetDocu = true;
                }
                q.offer(temp);
            }
//

            int printCount = 0;
            while (!q.isEmpty()) {
                Node seletedNode = q.poll();
                Queue tempQueue = (Queue) ((LinkedList<Node>) q).clone();
                if (isMostHighRank(seletedNode, tempQueue)) {
                    printCount++;
                    if (seletedNode.targetDocu) {
                        break;
                    }
                } else {
                    q.offer(seletedNode);
                }
            }
            System.out.println(printCount);
        }//-while
    }

    private static void printQ(Queue<Node> q) {
        while (!q.isEmpty()) {
            System.out.print(q.poll().priority + "\t");
        }
    }

    private static boolean isMostHighRank(Node seletedNode, Queue<Node> q) {
        boolean isHigh = true;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (seletedNode.priority < temp.priority) {
                isHigh = false;
                break;
            }
        }
        return isHigh;
    }


}

class Node {
    int priority;
    boolean targetDocu;

    Node(int priority) {
        this.priority = priority;
    }
}