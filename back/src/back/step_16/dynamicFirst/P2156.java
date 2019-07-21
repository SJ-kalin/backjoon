package back.step_16.dynamicFirst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int grapeArr[] = new int[count];
        int resultArr[][] = new int[3][count];
        for (int i = 0; i < count; i++) {
            grapeArr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        if (count > 2) {
            result = dp(grapeArr, resultArr);
        } else {
            for (int i = 0; i < grapeArr.length; i++) {
                result = result + grapeArr[i];
            }
        }
        System.out.println(result);
    }

    private static int dp(int[] grapeArr, int[][] resultArr) {
        resultArr[0][0] = 0;
        resultArr[1][0] = grapeArr[0];
        resultArr[0][2] = 0;

        resultArr[0][1] = grapeArr[0];
        resultArr[1][1] = grapeArr[1];
        resultArr[2][1] = grapeArr[0] + grapeArr[1];
        for (int i = 2, j = 0; i < grapeArr.length; i++, j = 0) {
            resultArr[j][i] = Integer.max(resultArr[j + 2][i - 1], Integer.max(resultArr[j][i - 1], resultArr[j + 1][i - 1]));
            resultArr[j + 1][i] = resultArr[j][i - 1] + grapeArr[i];
            resultArr[j + 2][i] = resultArr[j + 1][i - 1] + grapeArr[i];
        }
        int l = grapeArr.length;
        int a = resultArr[0][l - 1];
        int b = resultArr[1][l - 1];
        int c = resultArr[2][l - 1];
        return Integer.max(a, Integer.max(b, c));
    }

}
