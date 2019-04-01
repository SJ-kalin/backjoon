package back.step_16.dynamicFirst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfHouse = Integer.parseInt(br.readLine());
        int matrix[][] = new int[numOfHouse][numOfHouse];
        int dp[][] = new int[numOfHouse][numOfHouse];

        for (int i = 0; i < numOfHouse; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int j = 0;
            while (tokenizer.hasMoreTokens()) {
                matrix[i][j++] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        dp[0][0] = matrix[0][0];
        dp[0][1] = matrix[0][1];
        dp[0][2] = matrix[0][2];


        for (int i = 1; i < numOfHouse; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + matrix[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + matrix[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][2];
        }

        System.out.println(Math.min(Math.min(dp[numOfHouse - 1][0], dp[numOfHouse - 1][1]), dp[numOfHouse - 1][2]));

    }
}
