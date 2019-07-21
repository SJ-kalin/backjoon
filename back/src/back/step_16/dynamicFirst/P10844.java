package back.step_16.dynamicFirst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10844 {

    static long dpArray[][];
    static final long BI = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        dpArray = new long[10][count];

        for (int i = 0; i < dpArray.length; i++) {
            Arrays.fill(dpArray[i], -1);
        }

        if (count < 2) {
            System.out.print(9);
            return;
        }


        for (int i = 1; i < 10; i++) {
            dpArray[i][count - 1] = dp(i, count);
        }

        long sum = 0;
        for (int i = 1; i < dpArray.length; i++) {
            sum = sum + dpArray[i][count - 1];
        }

        System.out.println(sum%BI);
    }


    // 동적계획법
    private static long dp(int num, int count) {

        if (count == 1) {
            return 1;
        }

        long sum = 0;

        if (dpArray[num][count - 1] != -1) {
            return dpArray[num][count - 1];
        }

        if (num != 9) {
            sum = sum + dp(num + 1, count - 1) % BI;
        }

        if (num != 0) {
            sum = sum + dp(num - 1, count - 1) % BI;
        }

        dpArray[num][count - 1] = sum % BI;
        return sum % BI;
    }

}
