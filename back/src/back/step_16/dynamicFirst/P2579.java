package back.step_16.dynamicFirst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfStep = Integer.parseInt(br.readLine());
        int stepValue[] = new int[numberOfStep];
        int dp[] = new int[numberOfStep];

        for (int i = 0; i < numberOfStep; i++) {
            stepValue[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stepValue[0];
        dp[1] = stepValue[0] + stepValue[1];
        dp[2] = Math.max(stepValue[0] + stepValue[2], stepValue[1] + stepValue[2]);
        for (int i = 3; i < numberOfStep; i++) {
            dp[i] = Math.max(dp[i - 2] + stepValue[i], dp[i - 3] + stepValue[i - 1] + stepValue[i]);
        }
        System.out.println(dp[numberOfStep - 1]);
    }
}
