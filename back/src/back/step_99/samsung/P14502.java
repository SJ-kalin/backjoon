package back.step_99.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P14502 {

    static Boolean visited[][];

    public static void main(String[] args) throws IOException {

        int safeArea = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        NodeP14502[][] nodes = new NodeP14502[n][m];
        List<NodeP14502> list = new ArrayList<>();
        Queue<NodeP14502> queue = new LinkedList<>();
        Stack<NodeP14502> stack = new Stack<>();

        visited = new Boolean[n][m];


        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                nodes[i][j] = new NodeP14502(i, j, Integer.parseInt(tokenizer.nextToken()));
                if (nodes[i][j].v == 0) {
                    list.add(nodes[i][j]);
                }

                if (nodes[i][j].v == 2) {
                    queue.add(nodes[i][j]);
                }

            }
        }

        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    NodeP14502[][] matrix = new NodeP14502[n][m];
                    for (int a = 0; a < nodes.length; a++) {
                        for (int b = 0; b < nodes[a].length; b++) {
                            int x = nodes[a][b].x;
                            int y = nodes[a][b].y;
                            int v = nodes[a][b].v;
                            matrix[a][b] = new NodeP14502(x, y, v);
                        }
                    }
                    int x = list.get(i).x;
                    int y = list.get(i).y;

                    matrix[x][y].v = 1;

                    x = list.get(j).x;
                    y = list.get(j).y;

                    matrix[x][y].v = 1;

                    x = list.get(k).x;
                    y = list.get(k).y;

                    matrix[x][y].v = 1;


                    for (int p = 0; p < visited.length; p++) {
                        Arrays.fill(visited[p], false);
                    }
                    safeArea = Math.max(safeArea, bfs(matrix));
                }
            }
        }

        System.out.print(safeArea);

    }

    private static int bfs(NodeP14502[][] matrix) {

        Queue<NodeP14502> queue = new LinkedList<>();


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].v == 2) {
                    queue.add(matrix[i][j]);
                }
            }
        }

        while (!queue.isEmpty()) {

            NodeP14502 temp = queue.poll();
            int x = temp.x;
            int y = temp.y;

            if (y > 0 && matrix[x][y - 1].v == 0 && !visited[x][y - 1]) {
                queue.add(matrix[x][y - 1]);
                matrix[x][y - 1].v = 2;
            }

            if (y < matrix[0].length - 1 && matrix[x][y + 1].v == 0 && !visited[x][y + 1]) {
                queue.add(matrix[x][y + 1]);
                matrix[x][y + 1].v = 2;
            }

            if (x > 0 && matrix[x - 1][y].v == 0 && !visited[x - 1][y]) {
                queue.add(matrix[x - 1][y]);
                matrix[x - 1][y].v = 2;
            }

            if (x < matrix.length - 1 && matrix[x + 1][y].v == 0 && !visited[x + 1][y]) {
                queue.add(matrix[x + 1][y]);
                matrix[x + 1][y].v = 2;
            }
            visited[x][y] = true;
        }

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].v == 0) {
                    count++;
                }
            }
        }


        return count;
    }


}

class NodeP14502 implements Cloneable {
    int x, y, v;

    NodeP14502(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }

}
