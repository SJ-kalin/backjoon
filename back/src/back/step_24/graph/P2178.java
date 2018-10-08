package back.step_24.graph;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2178 {

    static Node[][] nodeArr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());


        int count = Integer.parseInt(br.readLine());

        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());

        nodeArr = new Node[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String temp[] = br.readLine().split("");
            for (int j = 0; j < temp.length; j++) {
                nodeArr[i][j] = new Node(i, j, temp[j]);
//                System.out.print(nodeArr[i][j].x + "," + nodeArr[i][j].y + "\t");
            }
//            System.out.println();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(nodeArr[0][0]);
        visited[0][0] = true;
        first:
        while (!queue.isEmpty()) {
            Queue<Node> secondQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                secondQueue.add(temp);
            }
//            System.out.println("=====================");
            while (!secondQueue.isEmpty()) {
                Node temp = secondQueue.poll();
//                System.out.println(temp.toString());
                if (temp.x == row - 1 && temp.y == col - 1) {
                    count++;
                    break first;
                }

                if (temp.y < col - 1) {
                    if (nodeArr[temp.x][temp.y + 1].value.equals("1") && !visited[temp.x][temp.y + 1]) {
                        queue.add(nodeArr[temp.x][temp.y + 1]);
                        visited[temp.x][temp.y + 1] = true;
                    }
                }


                if (temp.y > 0) {
                    if (nodeArr[temp.x][temp.y - 1].value.equals("1") && !visited[temp.x][temp.y - 1]) {
                        queue.add(nodeArr[temp.x][temp.y - 1]);
                        visited[temp.x][temp.y - 1] = true;
                    }
                }


                if (temp.x < row - 1) {
                    if (nodeArr[temp.x + 1][temp.y].value.equals("1") && !visited[temp.x + 1][temp.y]) {
                        queue.add(nodeArr[temp.x + 1][temp.y]);
                        visited[temp.x + 1][temp.y] = true;
                    }
                }


                if (temp.x > 0) {
                    if (nodeArr[temp.x - 1][temp.y].value.equals("1") && !visited[temp.x - 1][temp.y]) {
                        queue.add(nodeArr[temp.x - 1][temp.y]);
                        visited[temp.x - 1][temp.y] = true;
                    }
                }


            }
            count++;
        }
        System.out.println(count);
    }
}

class Node {
    public Node(int x, int y, String value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    int x;
    int y;
    String value;

    @Override
    public String toString() {
        return x + "," + y;
    }
}
