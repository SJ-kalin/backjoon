package back.step_24.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        NodeP1890 matrix[][] = new NodeP1890[count][count];
        for (int i = 0; i < matrix.length; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < matrix.length; j++) {
                int v = Integer.parseInt(tokenizer.nextToken());
                matrix[i][j] = new NodeP1890(i, j, v);
            }
        }

//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j].v + "\t");
//            }
//            System.out.println();
//        }
        int result = dfs(matrix);
        System.out.println(result);
    }

    private static int dfs(NodeP1890[][] matrix) {
        int count = 0;
        Queue<NodeP1890> q = new LinkedList<>();
        q.add(matrix[0][0]);
        while (!q.isEmpty()) {
            NodeP1890 temp = q.poll();

            if (temp.v == 0) {
                count++;
                continue;
            }

            int x = temp.x;
            int y = temp.y;
            int v = temp.v;

            if (x + v < matrix.length) {
                q.add(matrix[x + v][y]);
            }

            if (y + v < matrix.length) {
                q.add(matrix[x][y + v]);
            }

        }
        return count;
    }
}

class NodeP1890 {
    /*
     * x : 가로, y: 세로, v: 이동가능한 칸
     * */
    public NodeP1890(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }

    int x;
    int y;
    int v;
}