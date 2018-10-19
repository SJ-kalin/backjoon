package back.step_22.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1038 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int num = 0;
        int rank = 0;

        while (count != rank) {
            boolean isOk = true;
            if (num <= 10) {
                num++;
                rank++;
                continue;
            } else {
                int temp = num;
                List<Integer> list = new ArrayList<>();
                while (temp > 0) {
                    list.add(temp % 10);
                    temp = temp / 10;
                }
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i) >= list.get(i + 1)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    rank++;
                }
                num++;
            }
        }
        System.out.println(num);
    }
}


