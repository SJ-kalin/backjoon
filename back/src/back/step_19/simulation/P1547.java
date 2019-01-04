package back.step_19.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Cup cups[] = new Cup[3];
        cups[0] = new Cup(0, 0);
        cups[1] = new Cup(1, 1);
        cups[2] = new Cup(2, 2);

        for (int i = 0; i < count; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(token.nextToken()) - 1;
            int from = Integer.parseInt(token.nextToken()) - 1;

            int temp = cups[to].value;
            cups[to].value = cups[from].value;
            cups[from].value = temp;

        }

        for (int i = 0; i < cups.length; i++) {
            if(cups[i].value==0){
                System.out.println(i+1);
            }
        }

    }
}

class Cup {
    int name;
    int value;

    public Cup(int name, int value) {
        this.name = name;
        this.value = value;
    }
}
