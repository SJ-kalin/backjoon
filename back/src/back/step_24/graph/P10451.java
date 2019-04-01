package back.step_24.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P10451 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {


            int count = Integer.parseInt(br.readLine());
            Matrix matrixArr[][] = new Matrix[2][count];
            Boolean visited[] = new Boolean[count];
            Queue<Matrix> queue = new LinkedList<>();
            int count_o = 0;

            for (int i = 0; i < count; i++) {
                matrixArr[0][i] = new Matrix(0, i, i);
            }

            String line[] = br.readLine().split(" ");

            for (int i = 0; i < count; i++) {
                matrixArr[1][i] = new Matrix(1, i, Integer.parseInt(line[i]) - 1);
            }
            Arrays.fill(visited, false);

            for (int i = 0; i < count; i++) {

                if (visited[i]) {
                    continue;
                }
                int root = i;
                queue.add(matrixArr[0][i]);
                while (!queue.isEmpty()) {
                    Matrix temp = queue.poll();
                    if (temp.value == root && visited[root]) {
                        count_o++;
                        break;
                    }
                    if (temp.x == 0) {
                        queue.add(matrixArr[1][temp.y]);
                    } else if (temp.x == 1) {
                        queue.add(matrixArr[0][temp.value]);
                    }
                    visited[temp.value] = true;
                }
            }
            System.out.println(count_o);
        }
    }
}

class Matrix {
    int x, y, value;

    public Matrix(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
