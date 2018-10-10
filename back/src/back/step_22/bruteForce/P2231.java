package back.step_22.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int i = 0;
        while (++i <= num) {
            int temp = i;
            int sum = temp;

            while (temp > 0) {
                sum = sum + temp % 10;
                temp /= 10;
            }
            if (sum == num) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);

    }

}