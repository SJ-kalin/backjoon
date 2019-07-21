package back.step_99.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12100 {

    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        NodeP12100[][] matrix = new NodeP12100[n][n];
        for (int i = 0; i < n; i++) {
            String temp[] = br.readLine().split(" ");
            for (int j = 0; j < temp.length; j++) {
                matrix[i][j] = new NodeP12100(i, j, Integer.parseInt(temp[j]));
            }
        }

        dfs(matrix, 1);
        System.out.print(result);
    }

    private static void dfs(NodeP12100[][] l, int i) {

        if (i == 6) {
            int value = findValue(l);
            result = Math.max(result, value);
            return;
        }

        NodeP12100[][] a = copy(l);
        NodeP12100[][] b = copy(l);
        NodeP12100[][] c = copy(l);
        NodeP12100[][] d = copy(l);

        a = leftSide(a);
        dfs(a, i + 1);
        b = rightSide(b);
        dfs(b, i + 1);
        c = upSide(c);
        dfs(c, i + 1);
        d = downSide(d);
        dfs(c, i + 1);


    }

    private static int findValue(NodeP12100[][] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                max = Math.max(max, a[i][j].v);
            }
        }
        return max;
    }


    private static NodeP12100[][] downSide(NodeP12100[][] matrix) {

        NodeP12100[][] temp = copy(matrix);

        for (int i = temp.length - 1; i >= 0; i--) {
            for (int j = 0; j < temp.length; j++) {
                down(temp[i][j], temp);
            }
        }
        resetVisited(temp);
        return temp;
    }

    private static NodeP12100[][] copy(NodeP12100[][] matrix) {

        int l = matrix.length;
        NodeP12100[][] clone = new NodeP12100[l][l];
        for (int i = 0; i < clone.length; i++) {
            for (int j = 0; j < clone.length; j++) {
                int x = matrix[i][j].x;
                int y = matrix[i][j].y;
                int v = matrix[i][j].v;
                boolean isChanged = matrix[i][j].isChanged;
                clone[i][j] = new NodeP12100(x, y, v);
                clone[i][j].isChanged = isChanged;
            }
        }
        return clone;
    }

    private static void down(NodeP12100 targetNode, NodeP12100[][] nodeP2048s) {
        if (targetNode.x == nodeP2048s.length - 1 || targetNode.v == 0) {
            return;
        }

        int x = targetNode.x;
        int y = targetNode.y;

        if (nodeP2048s[x + 1][y].v == 0) {
            nodeP2048s[x + 1][y].v = targetNode.v;
            nodeP2048s[x][y].v = 0;
            nodeP2048s[x + 1][y].isChanged = nodeP2048s[x][y].isChanged;
            targetNode.isChanged = false;
            down(nodeP2048s[x + 1][y], nodeP2048s);
        } else if (!nodeP2048s[x + 1][y].isChanged && !nodeP2048s[x][y].isChanged && targetNode.v == nodeP2048s[x + 1][y].v) {
            nodeP2048s[x + 1][y].v = nodeP2048s[x + 1][y].v + targetNode.v;
            nodeP2048s[x][y].v = 0;
            nodeP2048s[x + 1][y].isChanged = true;
        } else {
            return;
        }
    }


    private static NodeP12100[][] upSide(NodeP12100[][] matrix) {
        NodeP12100[][] temp = copy(matrix);

        for (int j = temp.length - 1; j >= 0; j--) {
            for (int i = 0; i < temp.length; i++) {
                up(temp[i][j], temp);
            }
        }
        resetVisited(temp);
        return temp;
    }


    private static void up(NodeP12100 targetNode, NodeP12100[][] nodeP2048s) {

        if (targetNode.x == 0 || targetNode.v == 0) {
            return;
        }

        int x = targetNode.x;
        int y = targetNode.y;


        if (nodeP2048s[x - 1][y].v == 0) {
            nodeP2048s[x - 1][y].v = targetNode.v;
            nodeP2048s[x][y].v = 0;
            nodeP2048s[x - 1][y].isChanged = nodeP2048s[x][y].isChanged;
            targetNode.isChanged = false;
            up(nodeP2048s[x - 1][y], nodeP2048s);
        } else if (!nodeP2048s[x - 1][y].isChanged && !nodeP2048s[x][y].isChanged && targetNode.v == nodeP2048s[x - 1][y].v) {
            nodeP2048s[x - 1][y].v = nodeP2048s[x - 1][y].v + targetNode.v;
            nodeP2048s[x][y].v = 0;
            nodeP2048s[x - 1][y].isChanged = true;
        } else {
            return;
        }
    }

    private static NodeP12100[][] rightSide(NodeP12100[][] matrix) {

        NodeP12100[][] temp = copy(matrix);

        for (int i = temp.length - 1; i >= 0; i--) {
            for (int j = temp.length - 1; j >= 0; j--) {
                right(temp[i][j], temp);
            }
        }
        resetVisited(temp);
        return temp;

    }

    private static void right(NodeP12100 targetNode, NodeP12100[][] nodeP2048s) {
        if (targetNode.y == nodeP2048s.length - 1 || targetNode.v == 0) {
            return;
        }

        int x = targetNode.x;
        int y = targetNode.y;


        if (nodeP2048s[x][y + 1].v == 0) {
            nodeP2048s[x][y + 1].v = targetNode.v;
            nodeP2048s[x][y + 1].isChanged = nodeP2048s[x][y].isChanged;
            nodeP2048s[x][y].v = 0;
            targetNode.isChanged = false;
            right(nodeP2048s[x][y + 1], nodeP2048s);
        } else if (!nodeP2048s[x][y + 1].isChanged && !nodeP2048s[x][y].isChanged && targetNode.v == nodeP2048s[x][y + 1].v) {
            nodeP2048s[x][y + 1].v = nodeP2048s[x][y + 1].v + targetNode.v;
            nodeP2048s[x][y].v = 0;
            nodeP2048s[x][y + 1].isChanged = true;
        } else {
            return;
        }
    }

    private static void printMatrix(NodeP12100[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j].v + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static NodeP12100[][] leftSide(NodeP12100[][] matrix) {

        NodeP12100[][] temp = copy(matrix);

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                left(temp[i][j], temp);
            }
        }

        resetVisited(temp);
        return temp;
    }

    private static void resetVisited(NodeP12100[][] temp) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                temp[i][j].isChanged = false;
            }
        }
    }

    private static void left(NodeP12100 targetNode, NodeP12100[][] nodeP2048s) {
        if (targetNode.y == 0 || targetNode.v == 0) {
            return;
        }

        int x = targetNode.x;
        int y = targetNode.y;


        if (nodeP2048s[x][y - 1].v == 0) {
            nodeP2048s[x][y - 1].v = targetNode.v;
            nodeP2048s[x][y].v = 0;
            nodeP2048s[x][y - 1].isChanged = nodeP2048s[x][y].isChanged;
            targetNode.isChanged = false;
            left(nodeP2048s[x][y - 1], nodeP2048s);
        } else if (!nodeP2048s[x][y - 1].isChanged && !nodeP2048s[x][y].isChanged && targetNode.v == nodeP2048s[x][y - 1].v) {
            nodeP2048s[x][y - 1].v = nodeP2048s[x][y - 1].v + targetNode.v;
            nodeP2048s[x][y].v = 0;
            nodeP2048s[x][y - 1].isChanged = true;
        } else {
            return;
        }

    }
}

class NodeP12100 {
    int x, y, v;
    boolean isChanged;

    NodeP12100(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
        isChanged = false;
    }


}