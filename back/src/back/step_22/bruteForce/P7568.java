package back.step_22.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class P7568 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(br.readLine());
        Man[] arr = new Man[people];

        for (int i = 0; i < people; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            Man man = new Man();
            man.height = Integer.parseInt(tokenizer.nextToken());
            man.weight = Integer.parseInt(tokenizer.nextToken());
            arr[i] = man;
        }

        for (int i = 0; i < people; i++) {
            int count = 0;
            for (int j = 0; j < people; j++) {
                if (arr[i].weight < arr[j].weight && arr[i].height < arr[j].height) {
                    count++;
                }
            }
            System.out.print(count + 1 + "\t");
        }

    }

}

class Man {
    int weight;
    int height;
}