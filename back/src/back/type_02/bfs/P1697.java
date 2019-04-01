package back.type_02.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {

    public static void main(String[] args) throws IOException {
        final int MAX_VALUE = 100001;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        Boolean visited[] = new Boolean[MAX_VALUE];
        Arrays.fill(visited, false);

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(n, 0));
        int count = 0;
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            if (visited[temp.x]) {
                continue;
            } else {
                if (temp.x != k) {
                    if (temp.x - 1 >= 0) {
                        queue.add(new Point(temp.x - 1, temp.count + 1));
                    }
                    if (temp.x + 1 < MAX_VALUE) {
                        queue.add(new Point(temp.x + 1, temp.count + 1));
                    }
                    if (temp.x * 2 < MAX_VALUE) {
                        queue.add(new Point(temp.x * 2, temp.count + 1));
                    }
                } else {
                    count = temp.count;
                    break;
                }
            }
            visited[temp.x] = true;
        }
        System.out.println(count);
    }

}

class Point {
    int count;
    int x;

    Point(int x, int count) {
        this.x = x;
        this.count = count;
    }
}