package back.step_33.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int numberOfCoin = Integer.parseInt(tokenizer.nextToken());
        int value = Integer.parseInt(tokenizer.nextToken());
        int coins[] = new int[numberOfCoin];
        for (int i = 0; i < numberOfCoin; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        numberOfCoin--;
        while (value > 0) {
            if (value >= coins[numberOfCoin]) {
                value = value - coins[numberOfCoin];
                count++;
            } else {
                numberOfCoin--;
            }
        }
        System.out.println(count);

    }

}
