package back.step_16.dynamicFirst;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1912 {
static long dp[];

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new long[num + 1];
        for (int i = 1; i < dp.length; i++)
        {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        long max = dp[1];
        for (int i = 1; i < dp.length; i++)
        {

            dp[i] = Math.max(dp[i], dp[i - 1] + dp[i]);

            if (max < dp[i])
                max = dp[i];

            //System.out.print(dp[i] + " ");
        }

        System.out.print(max);

    }
}
