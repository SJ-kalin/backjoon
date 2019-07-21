package back.step_16.dynamicFirst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1520 {
    static int visited[][];
    static Elem matrix[][];
    static int row;
    static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        row = Integer.parseInt(tokenizer.nextToken());
        col = Integer.parseInt(tokenizer.nextToken());
        matrix = new Elem[row][col];
        visited = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int j = 0;
            while (tokenizer.hasMoreTokens()) {
                matrix[i][j] = new Elem(i, j, Integer.parseInt(tokenizer.nextToken()));
                j++;
            }
        }

        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], 0);
        }

        int result = dfs(matrix[0][0], 0);
    }

    private static int dfs(Elem elem, int num) {

        int x = elem.x;
        int y = elem.y;

        int l, r, d, u;
        l = r = u = d = num;

        System.out.println("x :" + x + "\t,y: " + y);

        if (x == row - 1 && y == col - 1) {
            return num + 1;
        }

        if (checkRight(elem)) {
            if (visited[x][y + 1] != 0) {
                num = num + visited[x][y + 1];
            } else {
                num = dfs(matrix[x][y + 1], 0);
            }
        }
        if (x == 0 && y == 0) {
            toStrings();
        }

        if (checkLeft(elem)) {
            if (visited[x][y - 1] != 0) {
                num = num + visited[x][y - 1];
            } else {
                num = dfs(matrix[x][y - 1], 0);
            }
        }
        if (x == 0 && y == 0) {
            toStrings();
        }

        if (checkUp(elem)) {
            if (visited[x - 1][y] != 0) {
                num = num + visited[x - 1][y];
            } else {
                num = dfs(matrix[x - 1][y], 0);
            }
        }
        if (x == 0 && y == 0) {
            toStrings();
        }

        if (checkDown(elem)) {
            if (visited[x + 1][y] != 0) {
                num = num + visited[x + 1][y];
            } else {
                num = dfs(matrix[x + 1][y], 0);
            }
        }
        if (x == 0 && y == 0) {
            toStrings();
        }

        if (num != 0) {
            System.out.println("여긴" + x + "\t" + y);
            visited[x][y] = num;
        }
        return num;
    }

    private static boolean checkDown(Elem elem) {
        return elem.x < row - 1 && elem.v > matrix[elem.x + 1][elem.y].v;
    }

    private static boolean checkUp(Elem elem) {
        return elem.x > 0 && elem.v > matrix[elem.x - 1][elem.y].v;
    }

    private static boolean checkLeft(Elem elem) {
        return elem.y > 0 && elem.v > matrix[elem.x][elem.y - 1].v;
    }

    private static boolean checkRight(Elem elem) {
        return (elem.y < col - 1) && (elem.v > matrix[elem.x][elem.y + 1].v);
    }

    public static void toStrings() {
        System.out.println();
        for (int i = 0; i < visited.length; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
        System.out.println();
    }


}

class Elem {
    int x, y, v;

    public Elem(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }
}
