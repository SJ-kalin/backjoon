package back.step_24.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Block[][] blocks = new Block[size][size];
        StringTokenizer token;

        for (int i = 0; i < blocks.length; i++) {
            String temp[] = br.readLine().split("");
            for (int j = 0; j < temp.length; j++) {
                blocks[i][j] = new Block();
                blocks[i][j].value = Integer.parseInt(temp[j]);
                blocks[i][j].x = i;
                blocks[i][j].y = j;
            }
        }

        Queue<Block> queue = new LinkedList<>();
        List<Integer> counter = new ArrayList<>();

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                int count = 0;
                if (blocks[i][j].value != 0 && !blocks[i][j].visited) {
                    blocks[i][j].visited = true;
                    queue.add(blocks[i][j]);
                    count = 1;
                }
                while (!queue.isEmpty()) {
                    Block blockTmp = queue.poll();
                    int x = blockTmp.x;
                    int y = blockTmp.y;
                    // 오른쪽 확인
                    if (blockTmp.x < size - 1 && !blocks[x + 1][y].visited && blocks[x + 1][y].value == 1) {
                        blocks[x + 1][y].visited = true;
                        queue.add(blocks[x + 1][y]);
                        count++;
                    }
                    // 왼쪽 확인
                    if (blockTmp.x > 0 && !blocks[x - 1][y].visited && blocks[x - 1][y].value == 1) {
                        blocks[x - 1][y].visited = true;
                        queue.add(blocks[x - 1][y]);
                        count++;
                    }
                    if (blockTmp.y < size - 1 && !blocks[x][y + 1].visited && blocks[x][y + 1].value == 1) {
                        blocks[x][y + 1].visited = true;
                        queue.add(blocks[x][y + 1]);
                        count++;
                    }
                    if (blockTmp.y > 0 && !blocks[x][y - 1].visited && blocks[x][y - 1].value == 1) {
                        blocks[x][y - 1].visited = true;
                        queue.add(blocks[x][y - 1]);
                        count++;
                    }
                }
                if (count != 0) {
                    counter.add(count);
                }
            }
        }

        for (int i = 0; i < counter.size(); i++) {
            for (int j = i; j < counter.size(); j++) {
                if (counter.get(i) > counter.get(j)) {
                    int temp = counter.get(i);
                    counter.set(i, counter.get(j));
                    counter.set(j, temp);
                }
            }
        }

        System.out.println(counter.size());
        for (int i = 0; i < counter.size(); i++) {
            System.out.println(counter.get(i));
        }
    }

}


class Block {
    boolean visited;
    int value;
    int x;
    int y;
}
