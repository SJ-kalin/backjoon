package back.step_12.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1966 {

    static int arr[];

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {

            StringTokenizer token = new StringTokenizer(br.readLine());
            int arrSize = Integer.parseInt(token.nextToken());
            int target = Integer.parseInt(token.nextToken());

            arr = new int[arrSize + 1];

            String arrTemp[] = br.readLine().split(" ");
            for (int i = 1; i < arr.length; i++) {
                insert(i, Integer.parseInt(arrTemp[i - 1]));
            }



        }

    }

    private static void insert(int i, int parseInt) {

        if (i == 1) {
            arr[i] = parseInt;
            return;
        }

        if (arr[i / 2] < parseInt) {
            int temp = arr[i / 2];
            arr[i / 2] = parseInt;
            arr[i] = temp;
            insert(i / 2, parseInt);
        } else {
            arr[i] = parseInt;
            return;
        }


    }
}