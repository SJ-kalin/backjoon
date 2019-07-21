package back.step_99.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13460 {

    static Node[][] nodes;
    static Boolean[][] visited;


    static int LEFT = 1, RIGHT = 2, UP = 3, DOWN = 4, NOW = 0;
    static int nowDirection = 0;
    static int result = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        nodes = new Node[n][m];
        visited = new Boolean[n][m];

        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }

        Node red = null;
        Node blue = null;
        for (int i = 0; i < n; i++) {
            String temp[] = br.readLine().split("");
            for (int j = 0; j < temp.length; j++) {
                nodes[i][j] = new Node(i, j, temp[j]);
                if (temp[j].equals("R")) {
                    red = nodes[i][j];
                } else if (temp[j].equals("B")) {
                    blue = nodes[i][j];
                }
            }
        }// for

        dfs(blue, red, NOW, 0);
        result = (result >= 10) && (result > 0) ? result = -1 : result;
        System.out.print(result);
    }

    private static void dfs(Node blue, Node node, int direction, int count) {


        System.out.println(node.x + "\t" + node.y + "\t" + count);
        if (direction != nowDirection) {
            count = count + 1;
            nowDirection = direction;
        }

        if (nodes[node.x][node.y].v.equals("O")) {
            if (direction == LEFT && blue.y > 0 && nodes[blue.x][blue.y - 1].v.equals("O")) {
                result = -1;
            } else if (direction == RIGHT && blue.y < nodes[0].length - 1 && nodes[blue.x][blue.y + 1].v.equals("O")) {
                result = -1;
            } else if (direction == UP && blue.x > 0 && nodes[blue.x - 1][blue.y].v.equals("O")) {
                result = -1;
            } else if (direction == DOWN && blue.x < nodes.length - 1 && nodes[blue.x + 1][blue.y].equals("O")) {
                result = -1;
            } else {
                result = Math.min(result, count);
            }
            return;
        }


        if (blue.v.equals("O")) {
            result = Integer.MAX_VALUE;
            return;
        }


        visited[node.x][node.y] = true;
        //left
        if (node.y > 0 && (nodes[node.x][node.y - 1].v.equals(".") || nodes[node.x][node.y - 1].v.equals("O")) && !visited[node.x][node.y - 1]) {
            if (blue.y > 0 && !nodes[blue.x][blue.y - 1].v.equals("#")) {
                dfs(nodes[blue.x][blue.y - 1], nodes[node.x][node.y - 1], LEFT, count);
            } else {
                dfs(blue, nodes[node.x][node.y - 1], LEFT, count);
            }
        }

        //right
        if (node.y < nodes[0].length - 1 && (nodes[node.x][node.y + 1].v.equals(".") || nodes[node.x][node.y + 1].v.equals("O")) && !visited[node.x][node.y + 1]) {
            if (blue.y < nodes[0].length - 1 && !nodes[blue.x][blue.y + 1].v.equals("#")) {
                dfs(nodes[blue.x][blue.y + 1], nodes[node.x][node.y + 1], RIGHT, count);
            } else {
                dfs(blue, nodes[node.x][node.y + 1], RIGHT, count);
            }
        }

        //up
        if (node.x > 0 && (nodes[node.x - 1][node.y].v.equals(".") || nodes[node.x - 1][node.y].v.equals("O")) && !visited[node.x - 1][node.y]) {
            if (blue.x > 0 && !nodes[blue.x - 1][blue.y].v.equals("#")) {
                dfs(nodes[blue.x - 1][blue.y], nodes[node.x - 1][node.y], UP, count);
            } else {
                dfs(blue, nodes[node.x - 1][node.y], UP, count);
            }
        }

        //down
        if (node.x < nodes.length - 1 && (nodes[node.x + 1][node.y].v.equals(".") || nodes[node.x + 1][node.y].v.equals("O")) && !visited[node.x + 1][node.y]) {
            if (blue.x < nodes[0].length && !nodes[blue.x + 1][blue.y].v.equals("#")) {
                dfs(nodes[blue.x + 1][blue.y], nodes[node.x + 1][node.y], DOWN, count);
            } else {
                dfs(blue, nodes[node.x + 1][node.y], DOWN, count);
            }
        }

    }
}

class Node {

    String v;
    int x;
    int y;

    Node(int x, int y, String v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }

}
