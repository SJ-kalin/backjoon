package back.step_33.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());
        while (--testCases >= 0) {
            tokenizer = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(tokenizer.nextToken());
            int countOfStick = Integer.parseInt(tokenizer.nextToken());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < countOfStick; i++) {
                int num = Integer.parseInt(br.readLine());
                int maxTemp = Math.abs(l - num);

                if (maxTemp > max) {
                    max = maxTemp;
                }
                int tempNum = (l % 2 == 0) ? (l / 2) : ((l / 2) + 1);
                int minTemp = Math.abs(tempNum - num);
                if (minTemp < min) {
                    min = minTemp;
                }
            }
            System.out.println(l / 2 - min + " " + max);
        }
    }
}
