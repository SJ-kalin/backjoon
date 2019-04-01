package back.step_19.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1094 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetBar = Integer.parseInt(br.readLine());

        List<Integer> barList = new ArrayList<>();
        barList.add(64);

        while (true) {

            if (barSum(barList) == targetBar) {
//                System.out.println(barList.toString());
                System.out.println(barList.size());
                break;
            }

            int bar = barList.get(barList.size() - 1);
            barList.remove(barList.size() - 1);
            int first = bar / 2;
            int second = first;
            if (barSum(barList) + first < targetBar) {
                barList.add(first);
            }
            barList.add(second);

        }
    }

    private static int barSum(List<Integer> barList) {
        int sum = 0;
        for (int i = 0; i < barList.size(); i++) {
            sum = sum + barList.get(i);
        }
        return sum;
    }
}
