package back.step_99.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14500 {
    static NodeP14500[][] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        nodes = new NodeP14500[n][m];

        int sum = 0;

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < nodes[i].length; j++) {
                int v = Integer.parseInt(token.nextToken());
                nodes[i][j] = new NodeP14500(i, j, v);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Boolean visited[][] = new Boolean[n][m];
                for (int k = 0; k < visited.length; k++) {
                    Arrays.fill(visited[k], false);
                }
                sum = Math.max(sum, dfs(nodes[i][j], 0, 1, visited));
            }
        }
        System.out.println(sum);
    }

    private static int dfs(NodeP14500 node, int sum, int count, Boolean[][] visited) {

        int x = node.x;
        int y = node.y;

        System.out.println("(" + x + "," + y + ")" + "\t" + node.v + "\t sum =" + sum+" count = "+count);
        int l, r, u, d;
        l = r = u = d = 0;

        if (count == 4) {
            System.out.println("result = "+(sum+node.v));
            return sum + node.v;
        } else {
            visited[node.x][node.y] = true;
            sum = sum + node.v;
            if (y > 0 && !visited[x][y - 1]) {
                l = dfs(nodes[x][y - 1], sum, count + 1, visited);
            }
            if (y < nodes[0].length - 1 && !visited[x][y + 1]) {
                r = dfs(nodes[x][y + 1], sum, count + 1, visited);
            }

            if (x > 0 && !visited[x - 1][y]) {
                u = dfs(nodes[x - 1][y], sum, count + 1, visited);
            }

            if (x < nodes.length - 1 && !visited[x + 1][y]) {
                d = dfs(nodes[x + 1][y], sum, count + 1, visited);
            }

        }

        return Math.max(l, Math.max(r, Math.max(u, d)));
    }
}

class NodeP14500 {
    int x, y, v;

    NodeP14500(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }
}
