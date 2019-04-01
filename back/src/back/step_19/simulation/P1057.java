package back.step_19.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1057 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int playersNum = Integer.parseInt(tokenizer.nextToken());
        int kim = Integer.parseInt(tokenizer.nextToken());
        int lim = Integer.parseInt(tokenizer.nextToken());

        Player players[] = new Player[playersNum];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
        players[kim - 1].isSpecial = true;
        players[lim - 1].isSpecial = true;

        Queue<Player> queue = new LinkedList();

        for (int i = 0; i < players.length; i++) {
            queue.add(players[i]);
        }

        int count = 0;

        count = findMatch(queue, count);

        System.out.println(count + 1);
    }

    private static int findMatch(Queue<Player> queue, int count) {
        Queue<Player> tempQueue = new LinkedList<>();
        int num = count;
        while (!queue.isEmpty()) {
            Player firstPlayer = queue.poll();
            Player secondPlayer = queue.poll();
            if (secondPlayer == null) {
                secondPlayer = new Player();
            }
            if (firstPlayer.isSpecial && secondPlayer.isSpecial) {
                break;
            } else if (firstPlayer.isSpecial) {
                tempQueue.add(firstPlayer);
            } else if (secondPlayer.isSpecial) {
                tempQueue.add(secondPlayer);
            } else {
                tempQueue.add(firstPlayer);
            }

            if (queue.isEmpty()) {
                num = findMatch(tempQueue, num + 1);
            }
        }
        return num;
    }
}

class Player {
    boolean isSpecial = false;
}
