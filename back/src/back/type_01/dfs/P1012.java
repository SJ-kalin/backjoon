package back.type_01.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {

            StringTokenizer tokenizer = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());
            int count = Integer.parseInt(tokenizer.nextToken());

            boolean visited[][] = new boolean[m][n];

            MatrixP1012[][] matrix = new MatrixP1012[m][n];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = new MatrixP1012(i, j, 0);
                }
            }
            Queue<MatrixP1012> queue = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                matrix[x][y] = new MatrixP1012(x, y, 1);
                queue.add(matrix[x][y]);
            }
            int result = 0;
            Stack<MatrixP1012> stack = new Stack<>();
            while (!queue.isEmpty()) {
                MatrixP1012 temp = queue.poll();

                if (visited[temp.x][temp.y]) {
                    continue;
                }

                stack.push(temp);

                while (!stack.isEmpty()) {
                    MatrixP1012 temp2 = stack.pop();
                    int x = temp2.x;
                    int y = temp2.y;
                    if (x + 1 < m && matrix[x + 1][y].v == 1 && !visited[x + 1][y]) {
                        stack.push(matrix[x + 1][y]);
                        visited[x + 1][y] = true;
                    }

                    if (x - 1 >= 0 && matrix[x - 1][y].v == 1 && !visited[x - 1][y]) {
                        stack.push(matrix[x - 1][y]);
                        visited[x - 1][y] = true;
                    }

                    if (y + 1 < n && matrix[x][y + 1].v == 1 && !visited[x][y + 1]) {
                        stack.push(matrix[x][y + 1]);
                        visited[x][y + 1] = true;
                    }

                    if (y - 1 >= 0 && matrix[x][y - 1].v == 1 && !visited[x][y - 1]) {
                        stack.push(matrix[x][y - 1]);
                        visited[x][y - 1] = true;
                    }
                }
                result++;
            }
            System.out.println(result);
        }
    }
}

class MatrixP1012 {
    int x;
    int y;
    int v;

    MatrixP1012(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }

}
