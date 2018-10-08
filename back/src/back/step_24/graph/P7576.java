package back.step_24.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int col = Integer.parseInt(tokenizer.nextToken());
        int row = Integer.parseInt(tokenizer.nextToken());
        int tomatoNum = 0;
        int nonTomato = 0;
        int date = 0;

        Queue<Tomato> queue = new LinkedList<>();
        Queue<Tomato> queueSe = new LinkedList<>();

        Tomato[][] tomatoes = new Tomato[row][col];

        for (int i = 0; i < tomatoes.length; i++) {
            String temp[] = br.readLine().split(" ");
            for (int j = 0; j < tomatoes[i].length; j++) {
                tomatoes[i][j] = new Tomato();
                tomatoes[i][j].value = Integer.parseInt(temp[j]);
                if (tomatoes[i][j].value == 1) {
                    tomatoes[i][j].visited = true;
                    tomatoNum++;
                    queue.add(tomatoes[i][j]);
                } else if (tomatoes[i][j].value == -1) {
                    nonTomato++;
                }
                tomatoes[i][j].x = i;
                tomatoes[i][j].y = j;
            }
        }

        if (nonTomato + tomatoNum == col * row) {
            System.out.println("0");
            return;
        }

        while (!queue.isEmpty()) {

            while (!queue.isEmpty()) {
                queueSe.add(queue.poll());
            }


            while (!queueSe.isEmpty()) {

                Tomato tomato = queueSe.poll();


                if (tomato.x < row - 1 && tomatoes[tomato.x + 1][tomato.y].value == 0 && !tomatoes[tomato.x + 1][tomato.y].visited) {
                    tomatoes[tomato.x + 1][tomato.y].visited = true;
                    queue.add(tomatoes[tomato.x + 1][tomato.y]);
                    tomatoNum++;
                }

                if (tomato.x > 0 && tomatoes[tomato.x - 1][tomato.y].value == 0 && !tomatoes[tomato.x - 1][tomato.y].visited) {
                    queue.add(tomatoes[tomato.x - 1][tomato.y]);
                    tomatoes[tomato.x - 1][tomato.y].visited = true;
                    tomatoNum++;
                }

                if (tomato.y < col - 1 && tomatoes[tomato.x][tomato.y + 1].value == 0 && !tomatoes[tomato.x][tomato.y + 1].visited) {
                    queue.add(tomatoes[tomato.x][tomato.y + 1]);
                    tomatoes[tomato.x][tomato.y + 1].visited = true;
                    tomatoNum++;
                }

                if (tomato.y > 0 && tomatoes[tomato.x][tomato.y - 1].value == 0 && !tomatoes[tomato.x][tomato.y - 1].visited) {
                    queue.add(tomatoes[tomato.x][tomato.y - 1]);
                    tomatoes[tomato.x][tomato.y - 1].visited = true;
                    tomatoNum++;
                }
            }
            date++;
        }

        if (tomatoNum + nonTomato == col * row) {
            System.out.println(date - 1);
        } else {
            System.out.println(-1);
        }
    }

       /* //print tomatoes
        for (int i = 0; i < tomatoes.length; i++) {
            for (int j = 0; j < tomatoes[i].length; j++) {
                System.out.print(tomatoes[i][j].value);
            }
            System.out.println();
        }
*/


}


class Tomato {

    int x;
    int y;
    int value;
    boolean visited;

}
